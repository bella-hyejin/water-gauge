package com.tiacorp.waterapplication.repository

import android.content.Context
import com.tiacorp.waterapplication.repository.persistence.Preference

class DataRepository constructor(context: Context) {
    private val pref: Preference = Preference(context)

    var weight = 0f
    var todayWater = 0f
    var targetWater = 0f
    var cup_volume = 0f
    var alarm = true

    lateinit var language: String

    init {
        setup()
    }

    private fun setup() {
        weight = pref.getFloat(DataKey.USER_WEIGHT)
        todayWater = pref.getFloat(DataKey.TODAY_WATER_VOLUME)
        cup_volume = pref.getFloat(DataKey.USER_CUP_VOLUME)
    }

    fun saveSettings() {
        pref.put(DataKey.USER_CUP_VOLUME, cup_volume)
        pref.put(DataKey.USER_WEIGHT, weight)
        pref.put(DataKey.USER_LANGUAGE, language)
        pref.put(DataKey.USER_ALARM, alarm)
        pref.put(DataKey.TARGET_WATER_VOLUME, targetWater)
    }
}