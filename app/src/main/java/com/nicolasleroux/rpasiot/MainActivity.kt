package com.nicolasleroux.rpasiot

import android.app.Activity
import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle

private val TAG = MainActivity::class.java.simpleName

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    /**
     * Method to get the CameraManager from the MainActivity context.
     */
    private fun cameraManager(): CameraManager {
        val ctx: Context = this.applicationContext

        return ctx.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    }
}
