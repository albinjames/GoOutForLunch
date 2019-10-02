package com.diegomfv.gooutforlunch.utils.extensions

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.refreshOnBackgroundThread() {
    this.value?.let { this.postValue(this.value) }
}

fun <T> MutableLiveData<T>.refreshOnMainThread() {
    this.value?.let { this.value = this.value }
}