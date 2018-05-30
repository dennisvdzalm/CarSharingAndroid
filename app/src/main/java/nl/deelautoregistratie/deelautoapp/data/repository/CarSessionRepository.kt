package nl.deelautoregistratie.deelautoapp.data.repository

import android.arch.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import nl.deelautoregistratie.deelautoapp.data.db.CarSessionDao
import nl.deelautoregistratie.deelautoapp.data.model.CarSession
import nl.deelautoregistratie.deelautoapp.data.networking.ApiService
import nl.deelautoregistratie.deelautoapp.data.networking.DataResponse
import nl.deelautoregistratie.deelautoapp.utils.arch.*
import nl.deelautoregistratie.deelautoapp.utils.rx.Scheduler
import javax.inject.Inject

/**
 * Created by dennisvanderzalm on 28-05-18.
 */
class CarSessionRepository @Inject constructor(val apiService: ApiService,
                                               val carSessionDao: CarSessionDao,
                                               val scheduler: Scheduler,
                                               val compositeDisposable: CompositeDisposable) {

    val carSessionsResult: PublishSubject<DataResponse<PagedList<CarSession>>> =
            PublishSubject.create<DataResponse<PagedList<CarSession>>>()

    fun getCarSessions() {
        carSessionsResult.loading(true)

        apiService.getRecentCarSessions()
                .performOnBackOutOnMain(scheduler)
                .subscribe({ carSessions ->
                    carSessionsResult.success(carSessions)
                }, { error -> handleError(error) })
                .addTo(compositeDisposable)
    }

    private fun handleError(error: Throwable) {
        carSessionsResult.failed(error)
    }
}