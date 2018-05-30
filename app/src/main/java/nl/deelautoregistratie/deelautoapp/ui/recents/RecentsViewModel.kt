package nl.deelautoregistratie.deelautoapp.ui.recents

import android.arch.lifecycle.ViewModel
import nl.deelautoregistratie.deelautoapp.data.repository.CarSessionRepository
import javax.inject.Inject

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
class RecentsViewModel @Inject constructor(val carSessionRepository: CarSessionRepository) : ViewModel() {

    private val repoResult = carSessionRepository.getCarSessions()

    val carSessions = repoResult.pagedList
    val networkState = repoResult.networkState
    val refreshState = repoResult.refreshState

    fun refresh() {
        repoResult.refresh.invoke()
    }

    fun retry(){
        repoResult.retry.invoke()
    }

    override fun onCleared() {
        super.onCleared()
    }
}