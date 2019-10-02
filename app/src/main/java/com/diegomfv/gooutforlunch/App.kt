package com.diegomfv.gooutforlunch

import android.app.Activity
import android.app.Application
import android.content.BroadcastReceiver
import com.diegomfv.gooutforlunch.di.DaggerAppComponent
import com.diegomfv.gooutforlunch.utils.FirebaseProvider
import com.diegomfv.gooutforlunch.utils.applicationprovider.ApplicationProvider
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasBroadcastReceiverInjector
import timber.log.Timber
import javax.inject.Inject

class App : Application(), HasActivityInjector, HasBroadcastReceiverInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    @Inject
    lateinit var broadcastReceiverInjector: DispatchingAndroidInjector<BroadcastReceiver>

    override fun broadcastReceiverInjector(): AndroidInjector<BroadcastReceiver> = broadcastReceiverInjector

    override fun onCreate() {
        super.onCreate()

        ApplicationProvider.create(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        //Dagger2
        DaggerAppComponent.builder().create(this).inject(this)

        FirebaseProvider.fillFirebaseSingletons()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Timber.w("onLowMemory() called ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Timber.w("onTrimMemory) called ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
    }

    override fun onTerminate() {
        super.onTerminate()
        Timber.w("onTerminate() called ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
    }
}