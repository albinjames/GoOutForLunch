package com.diegomfv.gooutforlunch.di.module

import android.app.Application
import com.diegomfv.gooutforlunch.data.network.InternetMonitorTool
import com.diegomfv.gooutforlunch.data.service.ErrorService
import com.diegomfv.gooutforlunch.data.service.LoginService
import com.diegomfv.gooutforlunch.data.usecase.LoginUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class UseCaseModule {

    @Module
    companion object {

        @Singleton
        @Provides
        @JvmStatic
        fun provideLoginService(app: Application, loginService: LoginService, errorService: ErrorService, internetMonitorTool: InternetMonitorTool): LoginUseCase {
            return LoginUseCase(
                app = app,
                loginService = loginService,
                errorService = errorService,
                imt = internetMonitorTool)
        }

    }
}