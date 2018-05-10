package com.nicolasleroux.rpasiot

import android.hardware.camera2.CameraDevice
import android.util.Log

private val TAG = CameraStateCallback::class.java.simpleName

class CameraStateCallback : CameraDevice.StateCallback {

    var camera: CameraDevice? = null

    private constructor()

    /**
     * The CameraStateCallback is a singleton because only one camera is available
     * on the device.
     */
    companion object Factory {
        private var instance: CameraStateCallback? = null

        fun instance(): CameraStateCallback {
            if (instance == null) {
                instance = CameraStateCallback()
            }

            return instance!!
        }
    }

    override fun onOpened(cam: CameraDevice?) {
        Log.i(TAG, "Camera is opened !")

        camera = cam
    }

    override fun onDisconnected(cam: CameraDevice?) {
        Log.i(TAG, "Camera is disconnected !")
    }

    override fun onError(cam: CameraDevice?, error: Int) {
        Log.i(TAG, "An error occurred with the camera !")
    }

    override fun onClosed(camera: CameraDevice?) {
        Log.i(TAG, "Camera is closed !")

        super.onClosed(camera)
    }
}