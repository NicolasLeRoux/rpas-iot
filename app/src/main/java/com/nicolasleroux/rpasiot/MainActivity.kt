package com.nicolasleroux.rpasiot

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.util.Log

private val TAG = MainActivity::class.java.simpleName

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i(TAG, "Main activity created !")

        openCamera()
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

    /**
     * Method to get the ID of the camera plugged on the device from the CameraManager.
     */
    private fun cameraId(manager: CameraManager): String {
        val camIds = manager.cameraIdList

        if (camIds.isEmpty()) {
            throw Exception("No camera were found on this device !")
        }

        // Only one camera is set on the raspberry, so the first and only one is return.
        return camIds[0]
    }

    /**
     * Method to open the camera of the raspberry
     */
    private fun openCamera() {
        val threadWrapper = CameraThreadWrapper()
        threadWrapper.start()

        val manager = cameraManager()

        try {
            manager.openCamera(cameraId(manager), CameraStateCallback.instance(), threadWrapper.handler)
        } catch (e: CameraAccessException) {
            throw Exception("Unable to access the camera. $e")
        }
    }

    /**
     * Method to check if the camera is plugged to the device
     * NOTE: Return false even if the camera is plugged on the raspberry :(
     */
    private fun isCameraPlugged(): Boolean {
        val ctx: Context = this.applicationContext

        return ctx.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)
    }
}
