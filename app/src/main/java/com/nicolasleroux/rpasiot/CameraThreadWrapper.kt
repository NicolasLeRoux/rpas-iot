package com.nicolasleroux.rpasiot

import android.os.Handler
import android.os.HandlerThread

class CameraThreadWrapper {

    var thread: HandlerThread? = null

    var handler: Handler? = null

    fun start() {
        thread = HandlerThread("CameraThread")
        thread!!.start()

        handler = Handler(thread!!.looper)
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