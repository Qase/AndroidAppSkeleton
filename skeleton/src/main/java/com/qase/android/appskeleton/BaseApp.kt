package com.qase.android.appskeleton

import android.app.Application
import android.util.Log
import com.qase.android.appskeleton.activity.BaseMainActivity
import com.qase.android.appskeleton.fragment.BaseFragmentManager
import com.qase.android.appskeleton.preference.BasePreferences

open class BaseApp : Application() {

    companion object {
        private lateinit var _instance: BaseApp
        val instance: BaseApp
            get() = _instance
    }

    var baseActivity: BaseMainActivity? = null

    var fragmentManager: BaseFragmentManager = BaseFragmentManager()
        private set

    open val preferences: BasePreferences by lazy { BasePreferences(applicationContext) }

    override fun onCreate() {
        super.onCreate()
        _instance = this
        Log.d("BaseApp", "App: initializing application preferences")
        preferences.init()
    }

}
