package com.diegomfv.gooutforlunch.di.module

import android.app.Application
import com.diegomfv.gooutforlunch.App
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.MainActivity
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.MainActivityModule
import com.diegomfv.refractaticket.di.scope.PerActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module (includes = [
    AndroidSupportInjectionModule::class,
    DatabaseModule::class,
    NetworkModule::class,
    BroadcastReceiverModule::class,
    UtilsModule::class
])
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun application(app: App): Application

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector(): MainActivity

}