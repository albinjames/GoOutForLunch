package com.diegomfv.gooutforlunch.di.module

import com.diegomfv.gooutforlunch.data.service.LoginService
import com.diegomfv.gooutforlunch.data.usecase.LoginUseCase
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

abstract class UseCaseModule {

    //TODO Temporary
    @Binds
    @Singleton
    abstract fun loginUseCase(loginService: LoginService): LoginUseCase

    @Module
    companion object {

//        @Singleton
//        @Provides
//        @JvmStatic
//        fun provideLoginService(app: Application): LoginService {
//            return LoginService(app)
//        }

    }
}