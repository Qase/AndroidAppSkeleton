package com.qase.android.appskeletondemo.main.preference

import android.os.Bundle
import com.qase.android.appskeleton.fragment.BaseBundle
import com.qase.android.appskeleton.fragment.BasePreferenceFragment
import com.qase.android.appskeletondemo.R

class SettingsFragment : BasePreferenceFragment<BaseBundle>() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.main_preferences)
    }

    override fun onBackPressed(): Boolean {
        return false
    }
}
