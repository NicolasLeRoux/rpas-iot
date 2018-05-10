package com.nicolasleroux.rpasiot

import android.os.Handler
import android.os.HandlerThread

class CameraThreadWrapper private constructor() {

    var thread: HandlerThread? = null

    var handler: Handler? = null

    init {
        start()
    }

    companion object Factory {
        private var instance: CameraThreadWrapper? = null

        fun instance(): CameraThreadWrapper {
            if (instance == null) {
                instance = CameraThreadWrapper()
            }

            return instance!!
        }
    }

    fun start() {
        if (thread == null) {
            thread = HandlerThread("CameraThread")
            thread!!.start()

            handler = Handler(thread!!.looper)
        }
    }

    fun stop() {
        thread!!.quitSafely()

        try {
            thread!!.join()
            thread = null
            handler = null
        } catch (e: InterruptedException) {
            throw Exception("Something went wrong during the safely thread quitting ! $e")
        }
    }
}