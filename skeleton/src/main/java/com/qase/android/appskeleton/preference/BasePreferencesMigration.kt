package com.qase.android.appskeleton.preference

import android.preference.PreferenceManager
import android.util.Log
import com.qase.android.appskeleton.BaseApp
import java.util.TreeMap

/**
 * Base class for settings migration
 */
open class BasePreferencesMigration {
    val migrationMap: MutableMap<Int, Runnable> by lazy { TreeMap<Int, Runnable>() }

    /**
     * Entry point method for start settings migration
     * @param fromVersion From which version we want to start - represent index in map
     */
    fun updateConfigSchema(fromVersion: Int) {
        try {
            val fromIndex = if (fromVersion <= 0) 0 else fromVersion

            for ((key, value) in migrationMap) {
                if (key >= fromIndex) {
                    Log.d("BasePreferenceMigration", "RUNNING MIGRATION v. " + key)
                    value.run()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * Represents batch of settings keys migrations
     * @param operation Array of PreferencesMigrationOperation
     */
    fun migrateBatch(operation: Array<PreferencesMigrationOperation>) {
        val context = BaseApp.instance.applicationContext
        val sp = PreferenceManager.getDefaultSharedPreferences(context)

        for (i in operation.indices) {
            Log.d("BasePreferenceMigration", "HUNK " + i)

            val oldKey = operation[i].oldKey
            val newKey = operation[i].newKey
            val oldKeyExists = sp.contains(oldKey)
            val newKeyExists = sp.contains(newKey)

            Log.d("BasePreferenceMigration", "Keys: $oldKey --> $newKey")
            Log.d("BasePreferenceMigration", "Exists: $oldKeyExists --> $newKeyExists")

            if (oldKeyExists && !newKeyExists) {
                // transformation function exists
                if (operation[i].transformFunction != null) {
                    var oldVal = Any()
                    var newVal = Any()

                    val allPreferences = sp.all

                    val allTypes = arrayOf(Boolean::class.java, Int::class.java, Long::class.java, String::class.java)

                    // read data
                    for (type in allTypes) {
                        if (type == operation[i].transformFunction.oldType) {
                            oldVal = allPreferences.get(oldKey)!!
                            newVal = operation[i].transformFunction.transform(type.cast(oldVal))
                            break
                        }
                    }

                    Log.d("BasePreferenceMigration", "Doing migration: " + oldVal.toString() + " --> " + newVal.toString())

                    // remove old key
                    sp.edit().remove(oldKey).apply()

                    /*
                    for(Class type : allTypes) {

                        if (type == operation[i].transformFunction.newType) {
                            allPreferences.put(newKey, newVal);

                        }
                    }
                    */

                    // save data @TODO put data in cycle
                    if (operation[i].transformFunction.newType == Boolean::class.java) {
                        sp.edit().putBoolean(newKey, newVal as Boolean).apply()
                    } else if (operation[i].transformFunction.newType == Int::class.java) {
                        sp.edit().putInt(newKey, newVal as Int).apply()
                    } else if (operation[i].transformFunction.newType == Long::class.java) {
                        sp.edit().putLong(newKey, newVal as Long).apply()
                    } else if (operation[i].transformFunction.newType == String::class.java) {
                        sp.edit().putString(newKey, newVal as String).apply()
                    }
                }
            }
        }
    }
}
