package nl.deelautoregistratie.deelautoapp.data.repository.fromNetworkAndDb

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.paging.LivePagedListBuilder
import io.reactivex.disposables.CompositeDisposable
import nl.deelautoregistratie.deelautoapp.data.ListDataObject
import nl.deelautoregistratie.deelautoapp.data.NetworkState
import nl.deelautoregistratie.deelautoapp.data.db.CarSessionDatabase
import nl.deelautoregistratie.deelautoapp.data.model.CarSession
import nl.deelautoregistratie.deelautoapp.data.networking.ApiService
import nl.deelautoregistratie.deelautoapp.data.repository.ICarSessionRepository
import nl.deelautoregistratie.deelautoapp.utils.arch.addTo
import nl.deelautoregistratie.deelautoapp.utils.rx.Scheduler
import java.util.concurrent.Executor
import javax.inject.Inject

/**
 * Created by dennisvanderzalm on 28-05-18.
 */
class CarSessionRepository @Inject constructor(private val apiService: ApiService,
                                               val db: CarSessionDatabase,
                                               private val scheduler: Scheduler,
                                               private val compositeDisposable: CompositeDisposable,
                                               private val executor: Executor) : ICarSessionRepository {

    private fun refresh(): LiveData<NetworkState> {
        val networkState = MutableLiveData<NetworkState>()
        networkState.value = NetworkState.LOADING
        apiService.getRecentCarSessions(1)
                .subscribe(
                        { carsessions ->
                            executor.execute {
                                db.runInTransaction {
                                    db.carSessionDao().deleteCarSessions()
                                    insertIntoDb(carsessions)
                                }
                                // since we are in bg thread now, post the result.
                                networkState.postValue(NetworkState.LOADED)
                            }
                        }, { error -> networkState.value = NetworkState.error(error.message) })
                .addTo(compositeDisposable)

        return networkState
    }

    override fun getCarSessions(): ListDataObject<CarSession> {
        val dataSourceFactory = db.carSessionDao().getAllCarSessions()
        val boundaryCallback = CarSessionBoundaryCallback(
                apiService = apiService,
                handleResponse = this::insertIntoDb,
                executor = executor,
                compositeDisposable = compositeDisposable,
                scheduler = scheduler)

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