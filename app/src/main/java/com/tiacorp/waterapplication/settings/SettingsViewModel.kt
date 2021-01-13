package com.tiacorp.waterapplication.settings

import androidx.lifecycle.ViewModel
import com.tiacorp.waterapplication.repository.DataRepository

class SettingsViewModel constructor(dataRepository: DataRepository) : ViewModel() {
    private val repos = dataRepository

    fun save() {
        repos.saveSettings()
    }
}