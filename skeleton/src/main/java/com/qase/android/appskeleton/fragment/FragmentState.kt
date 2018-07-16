package com.qase.android.appskeleton.fragment

open class FragmentState(val value: String) {

    companion object {
        val STARTING: FragmentState = FragmentState("starting")
        val READY: FragmentState = FragmentState("ready")
        val DESTROYED: FragmentState = FragmentState("destroyed")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FragmentState) return false

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }


}