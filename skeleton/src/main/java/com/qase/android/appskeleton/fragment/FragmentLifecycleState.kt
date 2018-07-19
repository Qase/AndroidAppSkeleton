package com.qase.android.appskeleton.fragment

open class FragmentLifecycleState(val value: String) {

    companion object {
        val VIEW_CREATED: FragmentLifecycleState = FragmentLifecycleState("VIEW_CREATED")
        val VIEW_DESTROYED: FragmentLifecycleState = FragmentLifecycleState("VIEW_DESTROYED")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FragmentLifecycleState) return false

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }


}