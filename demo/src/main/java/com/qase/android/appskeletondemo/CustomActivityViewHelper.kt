package com.qase.android.appskeletondemo

import android.content.Intent
import com.qase.android.appskeleton.activity.BaseActivityViewHelper
import com.qase.android.appskeleton.activity.BaseMainActivity
import com.qase.android.appskeletondemo.main.test.TestFragment
import kotlinx.android.synthetic.main.activity_custom_view.*

class CustomActivityViewHelper : BaseActivityViewHelper() {

    override val mainLayoutRes: Int = R.layout.activity_custom_view

    override fun onCreate(activity: BaseMainActivity) {
        activity.button.setOnClickListener { activity.startActivity(Intent(activity, MainActivity::class.java)); activity.finish()}
        activity.tryFragment.setOnClickListener { App.instance.fragmentManager.changeFragment(TestFragment::class.java, TestFragment::class.java.getSimpleName()) }
    }
}
