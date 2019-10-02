package com.diegomfv.gooutforlunch.utils.extensions

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.diegomfv.gooutforlunch.utils.HIDE_PROGRESS_LAYOUT
import com.diegomfv.gooutforlunch.utils.INEFFECTIVE_PROGRESS_LAYOUT
import com.diegomfv.gooutforlunch.utils.SHOW_PROGRESS_LAYOUT
import com.diegomfv.gooutforlunch.utils.TriggerOnce
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.CancellationException

@SuppressLint("CheckResult")
inline fun <reified T> Observable<T>.execute(
    compositeDisposable: CompositeDisposable,
    crossinline onNext: (result: T) -> Unit,
    crossinline onError: (error: Throwable) -> Unit = ({ e -> e.printStackTrace(); Timber.e(e) }),
    crossinline onComplete: () -> Unit = ({}),
    progressBarLiveData: MutableLiveData<TriggerOnce<Int>>? = null
): Disposable =
    this.doOnSubscribe { compositeDisposable.add(it) }
        .doOnSubscribe { progressBarLiveData?.postValue(TriggerOnce(INEFFECTIVE_PROGRESS_LAYOUT)) }
        .doOnTerminate { progressBarLiveData?.postValue(TriggerOnce(INEFFECTIVE_PROGRESS_LAYOUT)) }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { onNext(it) },
            { e -> onError(e) },
            { onComplete() })

@SuppressLint("CheckResult")
inline fun Completable.execute(
    compositeDisposable: CompositeDisposable,
    crossinline onComplete: () -> Unit = ({}),
    crossinline onError: (error: Throwable) -> Unit = ({ e -> e.printStackTrace(); Timber.e(e) }),
    progressBarLiveData: MutableLiveData<TriggerOnce<Int>>? = null
): Disposable =
    this.doOnSubscribe { compositeDisposable.add(it)}
        .doOnSubscribe { progressBarLiveData?.postValue(TriggerOnce(SHOW_PROGRESS_LAYOUT)) }
        .doOnTerminate { progressBarLiveData?.postValue(TriggerOnce(HIDE_PROGRESS_LAYOUT)) }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { onComplete() },
            { e -> onError(e) })


/** Ensure error is not handled
 * */
fun <T, R> Observable<T>.flatMapBlocker(blocker: Boolean, func: () -> Observable<R>): Observable<R> {
    return this
        .flatMap {
            if (blocker) throw CancellationException("Error") else func.invoke()
        }
}