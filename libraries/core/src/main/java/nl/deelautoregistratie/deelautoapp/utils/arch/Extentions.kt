package nl.deelautoregistratie.deelautoapp.utils.arch

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import nl.deelautoregistratie.deelautoapp.utils.rx.Scheduler

fun Disposable.addTo(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun <T> Single<T>.subscribeBy(success: (T) -> Unit, error: (Throwable) -> Unit): Disposable {
    return this.subscribe({ result ->
        success.invoke(result)
    }, { throwable -> error.invoke(throwable) })
}

fun Completable.subscribeBy(onComplete: () -> Unit, error: (Throwable) -> Unit): Disposable {
    return this.subscribe(
            { onComplete.invoke() },
            { throwable -> error.invoke(throwable) }
    )
}

fun <T> Flowable<T>.schedule(scheduler: Scheduler): Flowable<T> {
    return this.subscribeOn(scheduler.io())
            .observeOn(scheduler.mainThread())
}

fun <T> Single<T>.schedule(scheduler: Scheduler): Single<T> {
    return this.subscribeOn(scheduler.io())
            .observeOn(scheduler.mainThread())
}

fun Completable.schedule(scheduler: Scheduler): Completable {
    return this.subscribeOn(scheduler.io())
            .observeOn(scheduler.mainThread())
}