package com.diegomfv.gooutforlunch.viewviewmodel.base

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.diegomfv.refractaticket.di.scope.PerActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class BaseActivityModule {

    @Module
    companion object {

        const val ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager"

        @JvmStatic
        @Provides
        @Named(ACTIVITY_FRAGMENT_MANAGER)
        @PerActivity
        fun activityFragmentManager (activity: AppCompatActivity) : FragmentManager = activity.supportFragmentManager
    }

    @Binds
    @PerActivity
    abstract fun activity (appCompatActivity: AppCompatActivity): Activity

    @Binds
    @PerActivity
    abstract fun actContext(activity:Activity) : Context

}