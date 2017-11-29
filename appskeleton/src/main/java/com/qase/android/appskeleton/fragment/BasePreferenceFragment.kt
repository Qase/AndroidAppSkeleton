package com.qase.android.appskeleton.fragment

import android.os.Bundle
import android.support.v7.preference.PreferenceFragmentCompat
import com.qase.android.appskeleton.BaseApp

abstract class BasePreferenceFragment<BundleType : BaseBundle> : PreferenceFragmentCompat(), IFragment<BundleType> {

    var fragmentData: BundleType? = null

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        //Save the fragment's state here
        outState?.putSerializable("fragmentData", fragmentData)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            //Restore the fragment's state here

            //if mData is not null then it was set by FragmentManager (e.g. in changeFragment(..., extras, ...) method) and we do not want to overwrite it
            if (fragmentData == null) {
                fragmentData = savedInstanceState.getSerializable(BUNDLE_KEY) as BundleType?
            }
        }
    }

    override fun onResume() {
        super.onResume()

        BaseApp.instance.fragmentManager.evaluateConstraints(this.javaClass)
    }

    companion object {
        private val BUNDLE_KEY = "fragmentData"
    }
}
