package com.diegomfv.gooutforlunch.data.service

import android.app.Application
import com.diegomfv.gooutforlunch.data.model.dto.login.LoginResponseModelDTO
import com.diegomfv.gooutforlunch.utils.Response
import io.reactivex.Observable

class LoginService(val app: Application) {

    //TODO Fake login for the moment
    fun login(email: String, password: String): Observable<Response<LoginResponseModelDTO>> {
        return Observable.defer {
            Observable.just(Response.Success(LoginResponseModelDTO("")))
        }
    }
}