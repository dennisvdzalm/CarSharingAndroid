package nl.deelautoregistratie.deelautoapp.login

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import nl.deelautoregistratie.deelautoapp.utils.arch.addTo
import nl.deelautoregistratie.deelautoapp.utils.arch.schedule
import nl.deelautoregistratie.deelautoapp.utils.arch.subscribeBy
import nl.deelautoregistratie.deelautoapp.utils.rx.Scheduler
import nl.deelautregistratie.domain.interactor.LoginInteractor
import timber.log.Timber
import javax.inject.Inject

class LoginViewModel @Inject constructor(
        private val schedulerProvider: Scheduler,
        private val loginInteractor: LoginInteractor) : ViewModel() {

    private val disposables = CompositeDisposable()

    fun login(username: String, password: String) {
        loginInteractor.get(LoginInteractor.RequestValues(username, password))
                .schedule(schedulerProvider)
                .subscribeBy(
                        onComplete = { Timber.d("Succesfully logged in") },
                        error = { Timber.e(it, "Failed to login") }
                )
                .addTo(disposables)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}