package com.qase.android.appskeleton.fragment

import android.os.Bundle
import android.support.v7.preference.PreferenceFragmentCompat
import com.qase.android.appskeleton.BaseApp
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject

abstract class BasePreferenceFragment<BundleType : BaseBundle> : PreferenceFragmentCompat(), IFragment<BundleType> {

    override var data: BundleType? = null

    override var fragmentStateSubject: Subject<FragmentState> = BehaviorSubject.create()

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        //Save the fragment's state here
        outState.putSerializable("fragmentData", data)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            //Restore the fragment's state here

            //if mData is not null then it was set by FragmentManager (e.g. in changeFragment(..., extras, ...) method) and we do not want to overwrite it
            if (data == null) {
                data = savedInstanceState.getSerializable(BUNDLE_KEY) as BundleType?
            }
        }
    }

    override fun onBackPressed(): Boolean {
        return false
    }

    override fun onResume() {
        super.onResume()

        BaseApp.instance.fragmentManager.evaluateConstraints(this.javaClass)
    }

    companion object {
        private val BUNDLE_KEY = "fragmentData"
    }
}
