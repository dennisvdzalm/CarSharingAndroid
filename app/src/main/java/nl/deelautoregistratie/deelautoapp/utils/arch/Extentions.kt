package nl.deelautoregistratie.deelautoapp.utils.arch

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.MutableLiveData
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import nl.deelautoregistratie.deelautoapp.networking.DataResponse
import nl.deelautoregistratie.deelautoapp.utils.rx.Scheduler

fun <T> Flowable<T>.toLiveData(): LiveData<T> = LiveDataReactiveStreams.fromPublisher(this)

fun <T> LiveData<T>.toFlowable(lifecycleOwner: LifecycleOwner) : Flowable<T> =
        Flowable.fromPublisher(LiveDataReactiveStreams.toPublisher(lifecycleOwner, this))

fun <T> PublishSubject<T>.toLiveData(compositeDisposable: CompositeDisposable): LiveData<T> {
    val data = MutableLiveData<T>()
    compositeDisposable.add(this.subscribe({ t: T -> data.value = t }))
    return data
}

/**
 * Extension function to push a failed event with an exception to the observing outcome
 * */
fun <T> PublishSubject<DataResponse<T>>.failed(e: Throwable) {
    with(this){
        loading(false)
        onNext(DataResponse.failure(e))
    }
}

/**
 * Extension function to push  a success event with data to the observing outcome
 * */
fun <T> PublishSubject<DataResponse<T>>.success(t: T) {
    with(this){
        loading(false)
        onNext(DataResponse.success(t))
    }
}

/**
 * Extension function to push the loading status to the observing outcome
 * */
fun <T> PublishSubject<DataResponse<T>>.loading(isLoading: Boolean) {
    this.onNext(DataResponse.loading(isLoading))
}

/**
 * Extension function to subscribe on the background thread and observe on the main thread for a Completable
 * */
fun Completable.performOnBackOutOnMain(scheduler: Scheduler): Completable {
    return this.subscribeOn(scheduler.io())
            .observeOn(scheduler.mainThread())
}

/**
 * Extension function to subscribe on the background thread and observe on the main thread  for a Flowable
 * */
fun <T> Flowable<T>.performOnBackOutOnMain(scheduler: Scheduler): Flowable<T> {
    return this.subscribeOn(scheduler.io())
            .observeOn(scheduler.mainThread())
}

/**
 * Extension function to add a Disposable to a CompositeDisposable
 */
fun Disposable.addTo(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}