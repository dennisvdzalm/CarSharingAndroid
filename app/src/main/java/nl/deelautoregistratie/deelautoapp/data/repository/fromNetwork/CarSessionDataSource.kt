package nl.deelautoregistratie.deelautoapp.data.repository.fromNetwork

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PageKeyedDataSource
import android.net.Network
import io.reactivex.disposables.CompositeDisposable
import nl.deelautoregistratie.deelautoapp.data.NetworkState
import nl.deelautoregistratie.deelautoapp.data.model.CarSession
import nl.deelautoregistratie.deelautoapp.data.networking.ApiService
import nl.deelautoregistratie.deelautoapp.utils.arch.addTo
import nl.deelautoregistratie.deelautoapp.utils.arch.performOnBackOutOnMain
import nl.deelautoregistratie.deelautoapp.utils.rx.Scheduler
import java.util.concurrent.Executor

class CarSessionDataSource(private val apiService: ApiService,
                           private val retryExecutor: Executor,
                           private val scheduler: Scheduler,
                           private val compositeDisposable: CompositeDisposable) : PageKeyedDataSource<Int, CarSession>() {

    private var retry: (() -> Any)? = null

    val networkState = MutableLiveData<NetworkState>()

    val initialLoad = MutableLiveData<NetworkState>()

    fun retryAllFailed() {
        val prevRetry = retry
        retry = null
        prevRetry?.let {
            retryExecutor.execute {
                it.invoke()
            }
        }
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, CarSession>) {
        initialLoad.postValue(NetworkState.LOADING)
        networkState.postValue(NetworkState.LOADING)

        apiService.getRecentCarSessions(1)
                .performOnBackOutOnMain(scheduler)
                .subscribe({ carsessions ->
                    callback.onResult(carsessions.data, 1, 2)
                    networkState.postValue(NetworkState.LOADED)
                    initialLoad.postValue(NetworkState.LOADED)
                }, { error ->
                    retry = {
                        loadInitial(params, callback)
                    }
                    val error = NetworkState.error(error.message)
                    networkState.postValue(error)
                    initialLoad.postValue(error)
                }).addTo(compositeDisposable)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CarSession>) {
        performRequest(params.key, params.key + 1, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CarSession>) {
        performRequest(params.key, params.key - 1, callback)
    }

    private fun performRequest(pageNumber: Int, adjacentKey: Int, callback: LoadCallback<Int, CarSession>) {
        networkState.postValue(NetworkState.LOADING)

        apiService.getRecentCarSessions(pageNumber)
                .performOnBackOutOnMain(scheduler)
                .subscribe({ carsessions ->
                    callback.onResult(carsessions.data, adjacentKey)
                    networkState.postValue(NetworkState.LOADED)
                }, { error ->
                    networkState.postValue(NetworkState.error(error.message))
                }).addTo(compositeDisposable)
    }
}