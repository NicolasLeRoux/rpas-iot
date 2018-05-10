package com.nicolasleroux.rpasiot

import android.hardware.camera2.CameraCaptureSession
import android.util.Log

private val TAG = CameraCaptureSessionStateCallback::class.java.simpleName

class CameraCaptureSessionStateCallback: CameraCaptureSession.StateCallback() {
    override fun onConfigureFailed(session: CameraCaptureSession?) {
        Log.i(TAG, "Camera session configuration failed !")
    }

    override fun onConfigured(session: CameraCaptureSession?) {
        Log.i(TAG, "Camera is now configured !")
    }
}