package com.nicolasleroux.rpasiot

import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CameraMetadata
import android.hardware.camera2.CaptureRequest
import android.util.Log

private val TAG = CameraCaptureSessionStateCallback::class.java.simpleName

class CameraCaptureSessionStateCallback(val camera: CameraDevice): CameraCaptureSession.StateCallback() {
    override fun onConfigureFailed(session: CameraCaptureSession?) {
        Log.i(TAG, "Camera session configuration failed !")
    }

    override fun onConfigured(session: CameraCaptureSession?) {
        Log.i(TAG, "Camera is now configured !")

        val captureBuilder = camera.createCaptureRequest(CameraDevice.TEMPLATE_RECORD)
        captureBuilder.addTarget(CameraImageReader.instance().surface())
        captureBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO)

        session!!.setRepeatingRequest(captureBuilder.build(),
                CameraCaptureSessionCaptureCallback(),
                CameraThreadWrapper.instance().handler)
    }
}