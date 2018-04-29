package nl.deelautoregistratie.deelautoapp.recents

import android.arch.lifecycle.ViewModel
import nl.deelautoregistratie.deelautoapp.networking.ApiService
import javax.inject.Inject

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
class RecentsViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {



    override fun onCleared() {
        super.onCleared()
    }
}