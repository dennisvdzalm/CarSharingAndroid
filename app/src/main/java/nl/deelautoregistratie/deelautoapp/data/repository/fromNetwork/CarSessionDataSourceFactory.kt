package nl.deelautoregistratie.deelautoapp.data.repository.fromNetwork

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import nl.deelautoregistratie.deelautoapp.data.model.CarSession
import nl.deelautoregistratie.deelautoapp.data.networking.ApiService
import nl.deelautoregistratie.deelautoapp.utils.rx.Scheduler
import java.util.concurrent.Executor
import javax.inject.Inject

class CarSessionDataSourceFactory @Inject constructor(private val apiService: ApiService,
                                                      private val executor: Executor,
                                                      private val scheduler: Scheduler,
                                                      private val compositeDisposable: CompositeDisposable) : DataSource.Factory<Int, CarSession>() {

    val carSessionLiveData = MutableLiveData<CarSessionDataSource>()

    override fun create(): DataSource<Int, CarSession> {
        val carSessionDataSource = CarSessionDataSource(apiService, executor, scheduler, compositeDisposable)
        carSessionLiveData.postValue(carSessionDataSource)
        return carSessionDataSource
    }
}