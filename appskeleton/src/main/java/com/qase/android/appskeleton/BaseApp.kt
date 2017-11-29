package com.qase.android.appskeleton

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import android.util.Log
import com.qase.android.appskeleton.fragment.BaseFragmentManager
import com.qase.android.appskeleton.preference.BasePreferences

open class BaseApp : MultiDexApplication() {

    companion object {
        private lateinit var _instance: BaseApp
        val instance: BaseApp
            get() = _instance ?: throw RuntimeException("App instance terminated or not yet created")
    }

    var baseActivity: BaseMainActivity? = null

    var fragmentManager: BaseFragmentManager = BaseFragmentManager()
        private set

    open val preferences: BasePreferences by lazy { BasePreferences(applicationContext) }

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        _instance = this
        Log.d("BaseApp", "App: initializing application preferences")
        preferences.init()
    }

}
