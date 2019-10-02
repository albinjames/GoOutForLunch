package com.diegomfv.gooutforlunch.utils.enumutils

sealed class Duration {
    abstract val duration: Long

    object SHORT : Duration() {
        override val duration : Long = 200

    }
    object MEDIUM : Duration() {
        override val duration : Long = 400
    }

    object LONG : Duration() {
        override val duration : Long = 500
    }
}