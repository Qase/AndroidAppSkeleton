package com.qase.android.appskeletondemo.main.preference

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.qase.android.appskeleton.preference.BasePreferences
import com.qase.android.appskeleton.preference.BasePreferencesMigration

/**
 * Per project persistent settings
 */
class Preferences(context: Context) : BasePreferences(context), SharedPreferences.OnSharedPreferenceChangeListener {

    init {
        settings.registerOnSharedPreferenceChangeListener(this)
    }

    override val settingsMigration: BasePreferencesMigration
        get() = PreferencesMigration()

    /**
     * Per project default values (sets only if key doesn't exists)
     */
    override fun setDefaultValues() {
        if (isFirstStart) {
            // ...
        }

        setDefaultStringValueFromResource(TEST_STRING, "This is test setting string")
        setDefaultIntValueFromResource(TEST_INT, 1234)
        setDefaultBooleanValueFromResource(TEST_BOOL, true)
    }

    /**
     * Per project getters/setters
     */

    var testString: String
        get() = settings.getString(TEST_STRING, "")
        set(sipProxy) = settings.edit().putString(TEST_STRING, sipProxy).apply()

    // ...

    /**
     * Per project onSharedPreference change custom logic
     */
    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        Log.d("Preferences", "onSharedPreferenceChanged: " + key)

        // ...
    }

    companion object {
        private val TEST_STRING = "test_string"
        private val TEST_INT = "test_int"
        private val TEST_BOOL = "test_bool"
    }
}
