package com.diegomfv.gooutforlunch.utils.applicationprovider

import android.app.Application

object ApplicationProvider {

    lateinit var application : Application
    private set

    fun create (app: Application) {
        application = app
    }
}