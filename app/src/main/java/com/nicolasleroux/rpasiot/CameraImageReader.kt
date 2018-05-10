package com.nicolasleroux.rpasiot

import android.graphics.ImageFormat
import android.media.ImageReader
import android.os.Handler
import android.view.Surface

class CameraImageReader() {
    val IMAGE_WIDTH = 320
    val IMAGE_HEIGHT = 240
    val MAX_IMAGES = 3

    val imageReader = ImageReader.newInstance(IMAGE_WIDTH, IMAGE_HEIGHT, ImageFormat.JPEG, MAX_IMAGES)

    init {
        val handler = CameraThreadWrapper.instance().handler

        imageReader.setOnImageAvailableListener(ImageAvailableCallback(), handler)
    }

    fun surface(): Surface {
        return imageReader.surface
    }
}