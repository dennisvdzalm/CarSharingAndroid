package nl.deelautoregistratie.deelautoapp.data.repository

import android.arch.paging.PagedList
import nl.deelautoregistratie.deelautoapp.data.model.CarSession
import nl.deelautoregistratie.deelautoapp.data.networking.ApiService
import nl.deelautoregistratie.deelautoapp.utils.arch.PagingRequestHelper
import nl.deelautoregistratie.deelautoapp.utils.arch.createStatusLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor

class CarSessionBoundaryCallback(
        private val apiService: ApiService,
        private val handleResponse: (ApiService.CarSessions<CarSession>?) -> Unit,
        private val executor: Executor) : PagedList.BoundaryCallback<CarSession>() {

    val helper = PagingRequestHelper(executor)
    val networkState = helper.createStatusLiveData()

    override fun onZeroItemsLoaded() {
        helper.runIfNotRunning(PagingRequestHelper.RequestType.INITIAL) {
            apiService.getRecentCarSessions(1).enqueue(createWebserviceCallback(it))
        }
    }

    override fun onItemAtEndLoaded(itemAtEnd: CarSession) {
        helper.runIfNotRunning(PagingRequestHelper.RequestType.AFTER) {
            apiService.getRecentCarSessions(2).enqueue(createWebserviceCallback(it))
        }
    }

    private fun insertItemsIntoDb(response: Response<ApiService.CarSessions<CarSession>>, it: PagingRequestHelper.Request.Callback) {
        executor.execute {
            handleResponse(response.body())
            it.recordSuccess()
        }
    }

    private fun createWebserviceCallback(it: PagingRequestHelper.Request.Callback)
            : Callback<ApiService.CarSessions<CarSession>> {

        return object : Callback<ApiService.CarSessions<CarSession>> {

            override fun onFailure(call: Call<ApiService.CarSessions<CarSession>>, t: Throwable) {
                it.recordFailure(t)
            }

            override fun onResponse(call: Call<ApiService.CarSessions<CarSession>>, response: Response<ApiService.CarSessions<CarSession>>) {
                insertItemsIntoDb(response, it)
            }
        }
    }
}