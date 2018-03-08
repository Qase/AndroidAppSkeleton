package com.qase.android.appskeleton.fragment

class BaseConstraint {
    fun <FragmentType : IFragment<BundleType>, BundleType : BaseBundle> evaluate(fragmentClass: Class<FragmentType>): Boolean {
        return true
    }
}
