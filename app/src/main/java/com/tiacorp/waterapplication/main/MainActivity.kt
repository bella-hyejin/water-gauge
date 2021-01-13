package com.tiacorp.waterapplication.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.fangxu.allangleexpandablebutton.AllAngleExpandableButton
import com.fangxu.allangleexpandablebutton.ButtonData
import com.fangxu.allangleexpandablebutton.ButtonEventListener
import com.gelitenight.waveview.library.WaveView
import com.tiacorp.waterapplication.R
import com.tiacorp.waterapplication.base.BaseActivity
import com.tiacorp.waterapplication.common.BounceInterpolator
import com.tiacorp.waterapplication.common.WaveHelper
import com.tiacorp.waterapplication.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {

    lateinit var waveHelper: WaveHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        waveHelper = WaveHelper(wave_view)

        with(wave_view) {
            setWaveColor(
                resources.getColor(R.color.start, null),
                resources.getColor(R.color.end, null)
            )
            setBorder(0, Color.parseColor("#FFFFFF"))
            setShapeType(WaveView.ShapeType.SQUARE)
        }

        installButtons()

        val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)
        val interpolator = BounceInterpolator(0.2, 20.0)
        animation.interpolator = interpolator
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {}

            override fun onAnimationStart(animation: Animation?) {
                Log.e("asdf", "start animation")
            }
        })
        fab.animation = animation
        fab.setOnClickListener { v -> v.startAnimation(animation) }
    }

    private fun installButtons() {
        val button = fab as AllAngleExpandableButton
        val buttonDatas: MutableList<ButtonData> =
            ArrayList()
        val drawable = intArrayOf(
                R.drawable.round_add_white_48,
                R.drawable.refresh,
                R.drawable.mark,
                R.drawable.settings,
                R.drawable.heart,
                R.drawable.search
        )
        val color = intArrayOf(
                R.color.main,
                R.color.orange,
                R.color.blue,
                R.color.pink,
                R.color.yellow,
                R.color.red
        )
        for (i in 0..5) {
            val buttonData: ButtonData = if (i == 0) {
                ButtonData.buildIconButton(this, drawable[i], 15f)
            } else {
                ButtonData.buildIconButton(this, drawable[i], 0f)
            }
            buttonData.setBackgroundColorId(this, color[i])
            buttonDatas.add(buttonData)
        }
        button.buttonDatas = buttonDatas
        setListener(button)
    }

    private fun setListener(button: AllAngleExpandableButton) {
        button.setButtonEventListener(object : ButtonEventListener {
            override fun onButtonClicked(index: Int) {}

            override fun onExpand() {}

            override fun onCollapse() {}
        })
    }

    private fun resetWater() {
        waveHelper.cancel()
        wave_view.waterLevelRatio = 0f
        waveHelper.start()
    }

    override fun onPause() {
        super.onPause()
        waveHelper.cancel()
    }

    override fun onResume() {
        super.onResume()
        waveHelper.start()

    }

    fun goSettings(view: View) {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}