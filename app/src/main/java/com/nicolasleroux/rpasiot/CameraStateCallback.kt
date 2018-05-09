package com.nicolasleroux.rpasiot

import android.hardware.camera2.CameraDevice

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
        camera = cam
    }

    override fun onDisconnected(cam: CameraDevice?) {
        TODO("not implemented")
    }

    override fun onError(cam: CameraDevice?, error: Int) {
        TODO("not implemented")
    }
}