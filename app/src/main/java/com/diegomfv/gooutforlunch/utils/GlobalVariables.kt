package com.diegomfv.gooutforlunch.utils

import androidx.lifecycle.MutableLiveData

object GlobalVariables {

    //Only use in mainActivity
    val progressBarLiveData = MutableLiveData<TriggerOnce<Int>>()

}
