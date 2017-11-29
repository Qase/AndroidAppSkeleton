package com.qase.android.appskeleton.fragment

import com.qase.android.appskeleton.BaseApp
import com.qase.android.appskeleton.dagger.BaseAppComponent

abstract class InjectedBaseViewModel<BundleType : BaseBundle>() : BaseViewModel<BundleType>() {
    abstract fun injectMySelf(appComponent: BaseAppComponent)

    init {
        val component = BaseApp.instance.component
        injectMySelf(component)
    }
}
