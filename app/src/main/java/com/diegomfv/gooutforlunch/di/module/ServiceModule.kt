package com.diegomfv.gooutforlunch.di.module

import android.app.Application
import com.diegomfv.gooutforlunch.App
import com.diegomfv.gooutforlunch.data.service.ErrorService
import com.diegomfv.gooutforlunch.data.service.LoginService
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class ServiceModule {

    @Module
    companion object {

        @Singleton
        @Provides
        @JvmStatic
        fun provideLoginService(app: Application): LoginService {
            return LoginService(app)
        }

        @Singleton
        @Provides
        @JvmStatic
        fun provideErrorService(): ErrorService {
            return ErrorService()
        }

    }
}