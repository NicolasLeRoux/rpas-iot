package com.nicolasleroux.rpasiot

import android.graphics.ImageFormat
import android.media.ImageReader
import android.os.Handler

class CameraImageReader(val handler: Handler) {
    val IMAGE_WIDTH = 320
    val IMAGE_HEIGHT = 240
    val MAX_IMAGES = 3

    val imageReader = ImageReader.newInstance(IMAGE_WIDTH, IMAGE_HEIGHT, ImageFormat.JPEG, MAX_IMAGES)

    init {
        imageReader.setOnImageAvailableListener(ImageAvailableCallback(), handler)
    }
}