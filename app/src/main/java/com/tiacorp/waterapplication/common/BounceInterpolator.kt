package com.tiacorp.waterapplication.common

import android.view.animation.Interpolator
import kotlin.math.cos
import kotlin.math.pow

class BounceInterpolator constructor(amp: Double, freq: Double) : Interpolator {
    private var amplitude: Double = 0.0
    private var frequency: Double = 0.0

    init {
        amplitude = amp
        frequency = freq
    }

    override fun getInterpolation(time: Float): Float = ((-1 * Math.E.pow(-time / amplitude)) * cos(frequency * time) + 1).toFloat()
}