package com.qase.android.appskeletondemo.main.preference

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qase.android.appskeleton.fragment.BaseBundle
import com.qase.android.appskeleton.fragment.BasePreferenceFragment
import com.qase.android.appskeletondemo.R

class SettingsFragment : BasePreferenceFragment<BaseBundle>() {

    override var data: BaseBundle? = null

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.main_preferences)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onBackPressed(): Boolean {
        return false
    }
}
