package com.qase.android.appskeleton.activity

import android.os.Bundle
import android.support.design.widget.NavigationView

abstract class BaseDrawerMainActivity : BaseMainActivity() {

    open val activityViewHelper: BaseActivityViewHelper = DefaultDrawerActivityViewHelper(NavigationView.OnNavigationItemSelectedListener {false })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityViewHelper.mainLayoutRes)
        activityViewHelper.onCreate(this)
    }
}
