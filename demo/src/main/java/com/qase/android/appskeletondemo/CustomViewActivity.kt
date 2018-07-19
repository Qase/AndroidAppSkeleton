package com.qase.android.appskeletondemo

import com.qase.android.appskeleton.activity.BaseActivityViewHelper
import com.qase.android.appskeleton.activity.BaseMainActivity

class CustomViewActivity : BaseMainActivity() {

    override val activityViewHelper: BaseActivityViewHelper = CustomActivityViewHelper()

}
