package nl.deelautoregistratie.deelautoapp.data.repository.fromNetwork

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import nl.deelautoregistratie.deelautoapp.data.ListDataObject
import nl.deelautoregistratie.deelautoapp.data.model.CarSession
import nl.deelautoregistratie.deelautoapp.data.repository.ICarSessionRepository
import javax.inject.Inject

class CarSessionRepositoryNetworkOnly @Inject constructor(private var sourceFactory: CarSessionDataSourceFactory) : ICarSessionRepository {

    override fun getCarSessions(): ListDataObject<CarSession> {
        val config = PagedList.Config.Builder()
                .setPageSize(20)
                .setInitialLoadSizeHint(2)
                .setEnablePlaceholders(false)
                .build()

        val builder = LivePagedListBuilder(sourceFactory, config)

        val refreshState = Transformations.switchMap(sourceFactory.carSessionLiveData, {
            it.initialLoad
        })

        return ListDataObject(
                pagedList = builder.build(),
                networkState = Transformations.switchMap(sourceFactory.carSessionLiveData, {
                    it.networkState
                }),
                retry = {
                    sourceFactory.carSessionLiveData.value?.retryAllFailed()
                },
                refresh = {
                    sourceFactory.carSessionLiveData.value?.invalidate()
                },
                refreshState = refreshState
        )
    }
}
