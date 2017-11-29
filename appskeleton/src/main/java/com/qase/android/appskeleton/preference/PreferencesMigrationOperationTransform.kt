package com.qase.android.appskeleton.preference

/**
 * Represents transform function for transforming data between oldKey -> newKey
 */
abstract class PreferencesMigrationOperationTransform(c1: Class<*>, c2: Class<*>) {
    var oldType: Class<*>
    var newType: Class<*>

    init {
        oldType = c1
        newType = c2
    }

    abstract fun transform(data: Any): Any
}

