package nl.deelautoregistratie.deelautoapp.data.repository.fromNetworkAndDb

import android.arch.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import nl.deelautoregistratie.deelautoapp.data.model.CarSession
import nl.deelautoregistratie.deelautoapp.data.networking.ApiService
import nl.deelautoregistratie.deelautoapp.utils.arch.PagingRequestHelper
import nl.deelautoregistratie.deelautoapp.utils.arch.addTo
import nl.deelautoregistratie.deelautoapp.utils.arch.createStatusLiveData
import nl.deelautoregistratie.deelautoapp.utils.arch.performOnBackOutOnMain
import nl.deelautoregistratie.deelautoapp.utils.rx.Scheduler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rx.Observable
import rx.Observer
import java.util.concurrent.Executor

class CarSessionBoundaryCallback(
        private val apiService: ApiService,
        private val compositeDisposable: CompositeDisposable,
        private val handleResponse: (ApiService.CarSessions<CarSession>?) -> Unit,
        private val scheduler : Scheduler,
        private val executor: Executor) : PagedList.BoundaryCallback<CarSession>() {

    val helper = PagingRequestHelper(executor)
    val networkState = helper.createStatusLiveData()

    override fun onZeroItemsLoaded() {
        performRequest(PagingRequestHelper.RequestType.INITIAL, 2)

    }

    override fun onItemAtEndLoaded(itemAtEnd: CarSession) {
        performRequest(PagingRequestHelper.RequestType.AFTER, 2)
    }

    private fun performRequest(type: PagingRequestHelper.RequestType, pageNumber: Int) {
        helper.runIfNotRunning(type) {
            apiService.getRecentCarSessions(pageNumber)
                    .performOnBackOutOnMain(scheduler)
                    .subscribe({ carsessions ->
                        insertItemsIntoDb(carsessions, it)
                    }, { error ->
                        it.recordFailure(error)
                    }).addTo(compositeDisposable)
        }
    }

    private fun insertItemsIntoDb(data: ApiService.CarSessions<CarSession>, it: PagingRequestHelper.Request.Callback) {
        executor.execute {
            handleResponse(data)
            it.recordSuccess()
        }
    }
}



