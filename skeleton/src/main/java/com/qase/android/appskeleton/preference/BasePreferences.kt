package com.qase.android.appskeleton.preference

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.preference.PreferenceManager
import android.util.Log
import java.util.HashSet

/**
 * Base hybrid class for Preferences - implements basic keys and basic getters/setters
 */
open class BasePreferences(protected val mContext: Context) {
    val settings: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext)
    open val SETTINGS_VERSION = 1
    open val settingsMigration: BasePreferencesMigration = BasePreferencesMigration()

    protected open fun setDefaultValues() {}

    init {
        setDefaultValues()

        // Settings migration
        try {
            var previousSettingsVersion = 0
            if (settings.contains(SETTINGS_VERSION_KEY)) {
                previousSettingsVersion = settings.getInt(SETTINGS_VERSION_KEY, 0)
            }

            settingsMigration.updateConfigSchema(previousSettingsVersion)

            settings.edit().putInt(SETTINGS_VERSION_KEY, SETTINGS_VERSION).apply()
        } catch (ex: Exception) {
            Log.e("BasePreferences", "Could not migrate Settings", ex)
            ex.printStackTrace()
        }

    }

    /**
     * Called on application create
     */
    open fun init() {
        setIsFirstStart()
    }

    /**
     * If Boolean doesn't exists in persistent storage, get default Boolean from resource file if exists, otherwise use defaultValue.
     * @param resName Key
     * *
     * @param defaultValue Value
     */
    protected fun setDefaultBooleanValueFromResource(resName: String, defaultValue: Boolean?) {
        if (!settings.contains(resName)) {
            var value = defaultValue

            try {
                value = mContext.resources.getBoolean(mContext.resources.getIdentifier(resName, "bool", mContext.packageName))
            } catch (nfe: Resources.NotFoundException) {
            } finally {
                settings.edit().putBoolean(resName, value!!).apply()
            }
        }
    }

    /**
     * If integer doesn't exists in persistent storage, get default integer from resource file if exists, otherwise use defaultValue.
     * @param resName Key
     * *
     * @param defaultValue Value
     */
    protected fun setDefaultIntValueFromResource(resName: String, defaultValue: Int) {
        if (!settings.contains(resName)) {
            var value = defaultValue

            try {
                value = mContext.resources.getInteger(mContext.resources.getIdentifier(resName, "integer", mContext.packageName))
            } catch (nfe: Resources.NotFoundException) {
            } finally {
                settings.edit().putInt(resName, value).apply()
            }
        }
    }

    /**
     * If long doesn't exists in persistent storage, get default long from resource file if exists, otherwise use defaultValue.
     * @param resName Key
     * *
     * @param defaultValue Value
     */
    protected fun setDefaultLongValueFromResource(resName: String, defaultValue: Long) {
        if (!settings.contains(resName)) {
            var value = defaultValue

            try {
                value = mContext.resources.getInteger(mContext.resources.getIdentifier(resName, "long", mContext.packageName)).toLong()
            } catch (nfe: Resources.NotFoundException) {
            } finally {
                settings.edit().putLong(resName, value).apply()
            }
        }
    }

    /**
     * If String doesn't exists in persistent storage, get default String from resource file if exists, otherwise use defaultValue.
     * @param resName Key
     * *
     * @param defaultValue Value
     */
    protected fun setDefaultStringValueFromResource(resName: String, defaultValue: String) {
        if (!settings.contains(resName)) {
            var value = defaultValue

            try {
                value = mContext.resources.getString(mContext.resources.getIdentifier(resName, "string", mContext.packageName))
            } catch (nfe: Resources.NotFoundException) {
            } finally {
                settings.edit().putString(resName, value).apply()
            }
        }
    }

    /**
     * Basic getters/setters
     */

    val isFirstStart: Boolean
        get() = settings.getBoolean(SETTINGS_FIRST_START, true)

    fun setIsFirstStart() {
        settings.edit().putBoolean(SETTINGS_FIRST_START, false).apply()
    }

    fun setSetting(key: String, value: String?) {
        if (value == null)
            return

        Log.d("BasePreferences", "Set $key: $value")
        settings.edit().putString(key, value).apply()
    }

    fun setSetting(key: String, value: Boolean) {
        Log.d("BasePreferences", "Set $key: $value")
        settings.edit().putBoolean(key, value).apply()
    }

    fun setSetting(key: String, value: Int) {
        Log.d("BasePreferences", "Set $key: $value")
        settings.edit().putInt(key, value).apply()
    }

    fun setSetting(key: String, value: Set<String>) {
        Log.d("BasePreferences", "Set $key: $value")
        settings.edit().putStringSet(key, value).apply()
    }

    fun setSettingIntegerSet(key: String, value: Set<Int>) {
        val values = HashSet<String>()
        for (item in value) {
            values.add(item.toString())
        }
        settings.edit().putStringSet(key, values).apply()
    }

    fun getSettingIntegerSet(key: String): Set<Int> {
        val originalValues = settings.getStringSet(key, HashSet<String>())
        val values = HashSet<Int>()
        for (item in originalValues) {
            values.add(Integer.valueOf(item))
        }
        return values
    }

    companion object {

        // Mandatory setting keys
        private val SETTINGS_VERSION_KEY = "settings_version"
        private val SETTINGS_FIRST_START = "setting_first_start"
    }
}
