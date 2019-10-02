package com.diegomfv.gooutforlunch.utils

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

object RxUtils {

    fun <T> applyViewsSchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer {
            it.subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> applyOnlyBackgroundSchedulersObservable(): ObservableTransformer<T, T> {
        return ObservableTransformer {
            it.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
        }
    }

    fun <T> applyBackgroundSchedulersSingle(): SingleTransformer<T, T> {
        return SingleTransformer {
            it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> applyBackgroundSchedulersObservable(): ObservableTransformer<T, T> {
        return ObservableTransformer {
            it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun applyBackgroundSchedulersCompletable(): CompletableTransformer {
        return CompletableTransformer {
            it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> applyBackgroundSchedulersMaybe(): MaybeTransformer<T, T> {
        return MaybeTransformer {
            it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> applyBackgroundSchedulersFlowable(): FlowableTransformer<T, T> {
        return FlowableTransformer {
            it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> delayAndGoBackToIOScheduler(millis: Long = 2000): ObservableTransformer<T, T> {
        return ObservableTransformer {
            it.delay(millis, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io())
        }

    }
}
