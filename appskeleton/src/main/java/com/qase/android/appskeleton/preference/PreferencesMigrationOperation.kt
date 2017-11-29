package com.qase.android.appskeleton.preference

/**
 * Represents one operation of pair oldKey -> newKey
 */
class PreferencesMigrationOperation(val oldKey: String, val newKey: String, var transformFunction: PreferencesMigrationOperationTransform) {

    override fun hashCode(): Int {
        return oldKey.hashCode() xor newKey.hashCode()
    }

    override fun equals(o: Any?): Boolean {
        if (o !is PreferencesMigrationOperation) return false
        val pairo = o as PreferencesMigrationOperation?
        return this.oldKey == pairo?.oldKey && this.newKey == pairo.newKey
    }
}
