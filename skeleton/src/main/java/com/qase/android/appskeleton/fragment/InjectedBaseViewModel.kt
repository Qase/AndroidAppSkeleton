package com.qase.android.appskeleton.fragment

import com.qase.android.appskeleton.BaseAppComponent
import com.qase.android.appskeleton.DaggerBaseApp

abstract class InjectedBaseViewModel<BundleType : BaseBundle, AppComponentType: BaseAppComponent> : BaseViewModel<BundleType>() {
    abstract fun injectMySelf(appComponent: AppComponentType)

    init {
        val component = DaggerBaseApp.instance.component
        injectMySelf(component as AppComponentType)
    }
}