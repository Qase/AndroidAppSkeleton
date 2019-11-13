package com.qase.android.appskeletondemo.main.testdagger

import com.qase.android.appskeleton.BaseAppComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestModule::class])
interface AppComponent: BaseAppComponent {

    fun inject(noticesDetailViewModel: TestDaggerViewModel)

}
