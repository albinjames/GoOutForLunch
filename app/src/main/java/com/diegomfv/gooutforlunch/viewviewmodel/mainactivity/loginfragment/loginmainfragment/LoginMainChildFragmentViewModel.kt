package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.loginmainfragment

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.diegomfv.gooutforlunch.utils.Result
import com.diegomfv.gooutforlunch.utils.TriggerOnce
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginMainChildFragmentViewModel(
    private val app: Application
) : BaseViewModel(app) {

    val startMainActivityLiveData = MutableLiveData<TriggerOnce<Unit>>()

    //TODO Temporary till implemented
    @SuppressLint("CheckResult")
    fun login() {
        Observable.just(Result.Success(true))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { compositeDisposable?.add(it) }
            .subscribe {
                startMainActivityLiveData.value = TriggerOnce(Unit)
            }
    }


    class Factory(private val app: Application) :
        ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginMainChildFragmentViewModel(app) as T
        }
    }

}