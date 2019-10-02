package com.diegomfv.gooutforlunch.utils

open class TriggerOnce <out T> (private val content: T) {

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent() : T = content
}