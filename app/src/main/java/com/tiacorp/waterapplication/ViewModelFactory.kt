package com.tiacorp.waterapplication

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tiacorp.waterapplication.main.MainViewModel
import com.tiacorp.waterapplication.repository.DataRepository
import com.tiacorp.waterapplication.settings.SettingsActivity
import com.tiacorp.waterapplication.settings.SettingsViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
            return SettingsViewModel(DataRepository(context)) as T
        } else if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(DataRepository(context)) as T
        }

        throw IllegalArgumentException("")
    }

}