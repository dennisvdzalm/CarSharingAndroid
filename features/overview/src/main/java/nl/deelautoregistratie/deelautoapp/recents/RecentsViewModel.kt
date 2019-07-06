package nl.deelautoregistratie.deelautoapp.recents


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import nl.deelautoregistratie.deelautoapp.utils.arch.addTo
import nl.deelautoregistratie.deelautoapp.utils.arch.schedule
import nl.deelautoregistratie.deelautoapp.utils.arch.subscribeBy
import nl.deelautoregistratie.deelautoapp.utils.rx.Scheduler
import nl.deelautregistratie.domain.interactor.GetCarSessionsInteractor
import nl.deelautregistratie.domain.model.CarSession
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
class RecentsViewModel @Inject constructor(private val interactor: GetCarSessionsInteractor,
                                           private val scheduler: Scheduler) : ViewModel() {

    private val disposables = CompositeDisposable()

    val carSessions: LiveData<List<CarSession>> by lazy {
        interactor.prepare(GetCarSessionsInteractor.RequestValues(0))
                .schedule(scheduler)
                .subscribeBy(
                        success = {
                            _carSessionLiveData.value = it
                        },
                        error = { Timber.e("Error while retrieving carsessions: '$it'") })
                .addTo(disposables)

        _carSessionLiveData
    }

    private val _carSessionLiveData = MutableLiveData<List<CarSession>>()


    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}