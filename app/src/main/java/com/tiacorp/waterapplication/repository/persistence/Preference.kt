package com.tiacorp.waterapplication.repository.persistence

import android.content.Context
import android.content.SharedPreferences
import java.lang.ref.WeakReference

class Preference constructor(appContext: Context) {

    private lateinit var sharedPreference: SharedPreferences
    var context: WeakReference<Context>? = WeakReference(appContext)

    init {
        sharedPreference = context?.get()?.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)!!
    }

    fun getString(key: String): String? = sharedPreference.getString(key, null)
    fun getInt(key: String): Int = sharedPreference.getInt(key, 0)
    fun getFloat(key: String): Float = sharedPreference.getFloat(key, 0f)
    fun getLong(key: String): Long = sharedPreference.getLong(key, 0L)
    fun getBoolean(key: String): Boolean = sharedPreference.getBoolean(key, false)

    fun <T> put(key: String, value: T) {
        val editor = sharedPreference.edit()
        when (value) {
            is String -> editor.putString(key, value)
            is Int -> editor.putInt(key, value)
            is Float -> editor.putFloat(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is Long -> editor.putLong(key, value)
        }
        editor.apply()
    }

    fun clear() {
        val editor = sharedPreference.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        private const val PREF_NAME = "pref_water"
    }
}