package com.diegomfv.gooutforlunch.data.usecase

import android.app.Application
import com.diegomfv.gooutforlunch.data.model.domainmodel.login.LoginRequestModel
import com.diegomfv.gooutforlunch.data.model.dto.login.LoginResponseModelDTO
import com.diegomfv.gooutforlunch.data.network.InternetMonitorTool
import com.diegomfv.gooutforlunch.data.service.ErrorService
import com.diegomfv.gooutforlunch.data.service.LoginService
import com.diegomfv.gooutforlunch.utils.Response
import com.diegomfv.gooutforlunch.utils.error.ErrorCode
import io.reactivex.Observable

class LoginUseCase (
    val app: Application,
    val loginService: LoginService,
    val errorService: ErrorService,
    val imt: InternetMonitorTool) {

    //TODO Fake login for the moment
    fun login (loginRequestModel: LoginRequestModel) : Observable<Response<LoginResponseModelDTO>> {
        requireNotNull(loginRequestModel.email)
        requireNotNull(loginRequestModel.password)
        check(loginRequestModel.email.isNotBlank())
        check(loginRequestModel.email.contains('@')) //TODO Pass regex for emailLiveData
        check(loginRequestModel.password.isNotBlank())

        return imt.isInternetAvailableRx()
            .flatMap { internetAvailable ->
                if (!internetAvailable) {
                    Observable.just(Response.Failure(Throwable(errorService.getErrorForUser(ErrorCode.ERROR_001_INTERNET_NOT_AVAILABLE))))

                } else {
                    loginService.login(loginRequestModel.email, loginRequestModel.password)
                }
            }
    }
}