package nl.deelautoregistratie.deelautoapp.ui.recents

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import nl.deelautoregistratie.deelautoapp.model.CarSession
import nl.deelautoregistratie.deelautoapp.networking.ApiService
import nl.deelautoregistratie.deelautoapp.networking.DataResponse
import nl.deelautoregistratie.deelautoapp.utils.arch.*
import nl.deelautoregistratie.deelautoapp.utils.rx.Scheduler
import javax.inject.Inject

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
class RecentsViewModel @Inject constructor(val apiService: ApiService, val compositeDisposable: CompositeDisposable, val scheduler: Scheduler) : ViewModel() {
    val carsessionResult: PublishSubject<DataResponse<List<CarSession>>> =
            PublishSubject.create<DataResponse<List<CarSession>>>()

    val recentCarSessions: LiveData<DataResponse<List<CarSession>>> by lazy {
        carsessionResult.toLiveData(compositeDisposable)
    }

    public fun getCarSessions() {
        apiService.getRecentCarSessions()
                .performOnBackOutOnMain(scheduler)
                .subscribe({ carssesions ->
                    carsessionResult.success(carssesions)
                }, { error -> handleError(error) })
                .addTo(compositeDisposable)
    }

    fun handleError(error: Throwable) {
        carsessionResult.failed(error)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}