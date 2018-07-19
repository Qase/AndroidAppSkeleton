package com.qase.android.appskeleton.activity

/**
 * Class used for creating main activity view
 * mainLayoutRes should contain the main layout resource with fragment container with id R.id.fragment_container (@+id/fragment_container)
 */
abstract class BaseActivityViewHelper {

    abstract fun onCreate(activity: BaseMainActivity)

    abstract val mainLayoutRes: Int

}