package com.tiacorp.waterapplication.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.tiacorp.waterapplication.R
import com.tiacorp.waterapplication.ViewModelFactory
import com.tiacorp.waterapplication.base.BaseActivity

class SettingsActivity : BaseActivity() {
    private lateinit var vm: SettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        vm = ViewModelProvider(this, ViewModelFactory(this)).get(SettingsViewModel::class.java)
    }
}