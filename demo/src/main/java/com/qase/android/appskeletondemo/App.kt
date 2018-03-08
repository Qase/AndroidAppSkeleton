package com.qase.android.appskeletondemo

import com.qase.android.appskeleton.DaggerBaseApp
import com.qase.android.appskeleton.preference.BasePreferences
import com.qase.android.appskeletondemo.main.preference.Preferences
import com.qase.android.appskeletondemo.main.testdagger.AppComponent
import com.qase.android.appskeletondemo.main.testdagger.DaggerAppComponent

class App : DaggerBaseApp<AppComponent>() {

    override lateinit var component: AppComponent

    var activity: MainActivity? = null
    override val preferences: BasePreferences by lazy { Preferences(applicationContext) }

    override fun onCreate() {
        super.onCreate()
        _instance = this
        component = DaggerAppComponent.builder().build()
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
