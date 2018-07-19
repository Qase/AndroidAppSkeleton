package com.qase.android.appskeletondemo

import android.os.Bundle
import com.qase.android.appskeleton.activity.BaseActivityViewHelper
import com.qase.android.appskeleton.activity.BaseMainActivity

class CustomViewActivity : BaseMainActivity() {

    override val activityViewHelper: BaseActivityViewHelper = CustomActivityViewHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // FIRST SET ACTIVITY REFERENCE:
        // App.instance.activity = this

        // ... YOUR CODE ...
    }
}
