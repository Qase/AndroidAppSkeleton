package com.qase.android.appskeletondemo.main.testdagger

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TestModule {

    @Provides
    @Singleton
    fun provideTestManager(): TestManager {
        return TestManager()
    }
}
