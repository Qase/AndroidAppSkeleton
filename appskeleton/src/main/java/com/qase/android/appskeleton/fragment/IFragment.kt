package com.qase.android.appskeleton.fragment

interface IFragment<BundleType : BaseBundle> {

    var data: BundleType?

    fun onBackPressed(): Boolean
}
