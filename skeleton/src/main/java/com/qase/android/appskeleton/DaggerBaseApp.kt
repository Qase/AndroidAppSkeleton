package com.qase.android.appskeleton

abstract class DaggerBaseApp<AppComponentType> : BaseApp() {

    companion object {
        private lateinit var _instance: DaggerBaseApp<*>
        val instance: DaggerBaseApp<*>
            get() = _instance
    }

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    abstract var component: AppComponentType

}
