package com.qase.android.appskeletondemo.main.preference

import com.qase.android.appskeleton.preference.BasePreferencesMigration
import com.qase.android.appskeleton.preference.PreferencesMigrationOperation
import com.qase.android.appskeleton.preference.PreferencesMigrationOperationTransform
import java.util.TreeMap

/**
 * Per project settings migration
 */
class PreferencesMigration : BasePreferencesMigration() {
    init {
        migrationMap = TreeMap<Int, Runnable>()
        migrationMap?.put(0, Runnable {
            migrateBatch(arrayOf(PreferencesMigrationOperation("test_string", "test_string_new", object : PreferencesMigrationOperationTransform(String::class.java, String::class.java) {
                override fun transform(data: Any): Any {
                    return data
                }
            }), PreferencesMigrationOperation("test_bool", "test_int", object : PreferencesMigrationOperationTransform(Boolean::class.java, Int::class.java) {
                override fun transform(data: Any): Any {
                    return if (data as Boolean) 1 else 0
                }
            })))
        })
    }
}
