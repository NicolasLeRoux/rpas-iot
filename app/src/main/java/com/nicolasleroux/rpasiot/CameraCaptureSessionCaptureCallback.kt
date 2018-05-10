package com.nicolasleroux.rpasiot

import android.hardware.camera2.*
import android.util.Log
import android.view.Surface

private val TAG = CameraCaptureSessionCaptureCallback::class.java.simpleName

class CameraCaptureSessionCaptureCallback: CameraCaptureSession.CaptureCallback() {
    override fun onCaptureSequenceAborted(session: CameraCaptureSession?, sequenceId: Int) {
        Log.i(TAG, "onCaptureSequenceAborted")
        super.onCaptureSequenceAborted(session, sequenceId)
    }

    override fun onCaptureCompleted(session: CameraCaptureSession?, request: CaptureRequest?, result: TotalCaptureResult?) {
        Log.i(TAG, "onCaptureCompleted")
        super.onCaptureCompleted(session, request, result)
    }

    override fun onCaptureFailed(session: CameraCaptureSession?, request: CaptureRequest?, failure: CaptureFailure?) {
        Log.i(TAG, "onCaptureFailed")
        super.onCaptureFailed(session, request, failure)
    }

    override fun onCaptureSequenceCompleted(session: CameraCaptureSession?, sequenceId: Int, frameNumber: Long) {
        Log.i(TAG, "onCaptureSequenceCompleted")
        super.onCaptureSequenceCompleted(session, sequenceId, frameNumber)
    }

    override fun onCaptureStarted(session: CameraCaptureSession?, request: CaptureRequest?, timestamp: Long, frameNumber: Long) {
        Log.i(TAG, "onCaptureStarted")
        super.onCaptureStarted(session, request, timestamp, frameNumber)
    }

    override fun onCaptureProgressed(session: CameraCaptureSession?, request: CaptureRequest?, partialResult: CaptureResult?) {
        Log.i(TAG, "onCaptureProgressed")
        super.onCaptureProgressed(session, request, partialResult)
    }

    override fun onCaptureBufferLost(session: CameraCaptureSession?, request: CaptureRequest?, target: Surface?, frameNumber: Long) {
        Log.i(TAG, "onCaptureBufferLost")
        super.onCaptureBufferLost(session, request, target, frameNumber)
    }
}