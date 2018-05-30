package nl.deelautoregistratie.deelautoapp.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.paging.LivePagedListBuilder
import nl.deelautoregistratie.deelautoapp.data.ListDataObject
import nl.deelautoregistratie.deelautoapp.data.NetworkState
import nl.deelautoregistratie.deelautoapp.data.db.CarSessionDatabase
import nl.deelautoregistratie.deelautoapp.data.model.CarSession
import nl.deelautoregistratie.deelautoapp.data.networking.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import javax.inject.Inject

/**
 * Created by dennisvanderzalm on 28-05-18.
 */
class CarSessionRepository @Inject constructor(private val apiService: ApiService,
                                               val db: CarSessionDatabase,
                                               private val executor: Executor) {

    private fun refresh(): LiveData<NetworkState> {
        val networkState = MutableLiveData<NetworkState>()
        networkState.value = NetworkState.LOADING
        apiService.getRecentCarSessions(1).enqueue(
                object : Callback<ApiService.CarSessions<CarSession>> {
                    override fun onFailure(call: Call<ApiService.CarSessions<CarSession>>, t: Throwable) {
                        // retrofit calls this on main thread so safe to call set value
                        networkState.value = NetworkState.error(t.message)
                    }

                    override fun onResponse(
                            call: Call<ApiService.CarSessions<CarSession>>,
                            response: Response<ApiService.CarSessions<CarSession>>) {

                        executor.execute {
                            db.runInTransaction {
                                db.carSessionDao().deleteCarSessions()
                                insertIntoDb(response.body())
                            }
                            // since we are in bg thread now, post the result.
                            networkState.postValue(NetworkState.LOADED)
                        }
                    }
                }
        )
        return networkState
    }

    fun getCarSessions(): ListDataObject<CarSession> {
        val dataSourceFactory = db.carSessionDao().getAllCarSessions()
        val boundaryCallback = CarSessionBoundaryCallback(
                apiService = apiService,
                handleResponse = this::insertIntoDb,
                executor = executor)

        val builder = LivePagedListBuilder(dataSourceFactory, 10)
                .setBoundaryCallback(boundaryCallback)

        val refreshTrigger = MutableLiveData<Unit>()
        val refreshState = Transformations.switchMap(refreshTrigger, {
            refresh()
        })

        return ListDataObject(
                pagedList = builder.build(),
                networkState = boundaryCallback.networkState,
                retry = {
                    boundaryCallback.helper.retryAllFailed()
                },
                refresh = {
                    refreshTrigger.value = null
                },
                refreshState = refreshState
        )
    }

    private fun insertIntoDb(body: ApiService.CarSessions<CarSession>?) {
        body!!.data.let { carsessions ->
            db.runInTransaction {
                db.carSessionDao().insertCarSessions(carsessions)
            }
        }
    }
}