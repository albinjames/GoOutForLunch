package com.diegomfv.gooutforlunch.di.module

import com.diegomfv.gooutforlunch.App
import com.diegomfv.gooutforlunch.data.service.LoginService
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

abstract class ServiceModule {

    //TODO Temporary
    @Binds
    @Singleton
    abstract fun loginService(app: App): LoginService

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