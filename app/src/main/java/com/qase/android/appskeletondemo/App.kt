package com.qase.android.appskeletondemo

import com.qase.android.appskeleton.BaseApp
import com.qase.android.appskeleton.preference.BasePreferences
import com.qase.android.appskeletondemo.main.preference.Preferences

class App : BaseApp() {
    var activity: MainActivity? = null
    override val preferences: BasePreferences by lazy { Preferences(applicationContext) }

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    override fun onTerminate() {
        super.onTerminate()
        _instance = null
    }

    companion object {
        private var _instance: App? = null
        val instance: App
            get() = _instance ?: throw RuntimeException("App instance terminated or not yet created")
    }
}
