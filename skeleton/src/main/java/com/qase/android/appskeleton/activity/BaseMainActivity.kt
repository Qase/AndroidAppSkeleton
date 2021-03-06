package com.qase.android.appskeleton.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import com.qase.android.appskeleton.BaseApp

/**
 * Base activity which should be used as parent for app's main activity
 * To customize it's view set activityViewHelper
 */
abstract class BaseMainActivity : AppCompatActivity() {

    open val activityViewHelper: BaseActivityViewHelper = DefaultDrawerActivityViewHelper(NavigationView.OnNavigationItemSelectedListener {false })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApp.instance.baseActivity = this
        BaseApp.instance.fragmentManager.androidFragmentManager = supportFragmentManager
        setContentView(activityViewHelper.mainLayoutRes)
        activityViewHelper.onCreate(this)
    }

    override fun onBackPressed() {
        val currentFragment = BaseApp.instance.fragmentManager.currentIFragment
        if (currentFragment?.onBackPressed() == true) {
            Log.d("BaseMainActivity", "BackPressed Handled by Fragment: " + currentFragment.javaClass.canonicalName)
        } else if (onHandleBackPressed()) {
            Log.d("BaseMainActivity", "BackPressed Handled by Child Activity")
        } else {
            Log.d("BaseMainActivity", "BackPressed Default handle branch.")
            super.onBackPressed()
        }

        BaseApp.instance.fragmentManager.onBackPressed()

        // @INFO backpress once more if we are on first fragment (we want to shutdown whole app)
        if (BaseApp.instance.fragmentManager.fragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        }
    }

    /**
     * Override in child activity to provide custom onBackPressed navigation or actions
     * Also onBackPressed can be overridden to achieve more complex behaviour
     * @return true if back pressed is handled
     */
    protected fun onHandleBackPressed(): Boolean {
        return false
    }
}
