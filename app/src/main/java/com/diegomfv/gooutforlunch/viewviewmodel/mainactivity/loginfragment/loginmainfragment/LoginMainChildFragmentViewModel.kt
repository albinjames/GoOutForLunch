package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.loginmainfragment

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.diegomfv.gooutforlunch.data.model.domainmodel.login.LoginRequestModel
import com.diegomfv.gooutforlunch.data.usecase.LoginUseCase
import com.diegomfv.gooutforlunch.utils.Response
import com.diegomfv.gooutforlunch.utils.TriggerOnce
import com.diegomfv.gooutforlunch.utils.extensions.execute
import com.diegomfv.gooutforlunch.utils.extensions.shortToast
import com.diegomfv.gooutforlunch.utils.logSimple
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseViewModel

class LoginMainChildFragmentViewModel(
    val app: Application,
    val loginUseCase: LoginUseCase
) : BaseViewModel(app) {

    var emailLiveData = MutableLiveData<String>("user@email.com")
    var passwordLiveData = MutableLiveData<String>("123456")

    val loginSuccessfulLiveData = MutableLiveData<TriggerOnce<Unit>>()

    init {
        logSimple("ViewModel init")
    }

    fun login() {
        val loginRequestModel = LoginRequestModel(
            email = emailLiveData.value,
            password = passwordLiveData.value)

        loginUseCase.login(loginRequestModel)
            .execute(compositeDisposable,
                { response ->
                    when (response) {
                        is Response.Success -> {
                            loginSuccessfulLiveData.value = TriggerOnce(Unit)
                        }
                        is Response.Failure -> {
                            response.throwable.message?.let { app.shortToast(it) }
                        }
                    }
                })
    }

    class Factory(val app: Application, val loginUseCase: LoginUseCase) :
        ViewModelProvider.AndroidViewModelFactory(app) {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginMainChildFragmentViewModel(
                app = app,
                loginUseCase = loginUseCase
            ) as T
        }
    }

}