package com.nicolasleroux.rpasiot

import android.hardware.camera2.CameraDevice

class CameraStateCallback : CameraDevice.StateCallback() {
    override fun onOpened(camera: CameraDevice?) {
        TODO("not implemented")
    }

    override fun onDisconnected(camera: CameraDevice?) {
        TODO("not implemented")
    }

    override fun onError(camera: CameraDevice?, error: Int) {
        TODO("not implemented")
    }
}