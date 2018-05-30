package nl.deelautoregistratie.deelautoapp.ui.recents

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations.switchMap
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import nl.deelautoregistratie.deelautoapp.data.datasource.CarSessionDataSource
import nl.deelautoregistratie.deelautoapp.data.model.CarSession
import nl.deelautoregistratie.deelautoapp.data.networking.DataResponse
import nl.deelautoregistratie.deelautoapp.data.repository.CarSessionRepository
import nl.deelautoregistratie.deelautoapp.utils.arch.toLiveData
import javax.inject.Inject

/**
 * Created by dennisvanderzalm on 27-04-18.
 */
class RecentsViewModel @Inject constructor(val carSessionRepository: CarSessionRepository, val compositeDisposable: CompositeDisposable) : ViewModel() {

    val recentCarSessions: LiveData<DataResponse<PagedList<CarSession>>> by lazy {
        carSessionRepository.carSessionsResult.toLiveData(compositeDisposable)
    }

    val myPagingConfig = PagedList.Config.Builder()
            .setPageSize(50)
            .setPrefetchDistance(150)
            .setEnablePlaceholders(true)
            .build()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}