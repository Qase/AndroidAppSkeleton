package com.qase.android.appskeletondemo.main.testdagger

import androidx.lifecycle.MutableLiveData
import com.qase.android.appskeleton.fragment.BaseBundle
import com.qase.android.appskeleton.fragment.InjectedBaseViewModel
import javax.inject.Inject

class TestDaggerViewModel : InjectedBaseViewModel<BaseBundle, AppComponent>() {

    @Inject
    lateinit var manager: TestManager

    override fun injectMySelf(appComponent: AppComponent) {
        appComponent.inject(this)
    }

    val testLiveData: MutableLiveData<Int> by lazy { manager.getData() }

}
