package com.qase.android.appskeleton.fragment

import io.reactivex.subjects.Subject

interface IFragment<BundleType : BaseBundle> {

    var data: BundleType?

    fun onBackPressed(): Boolean

    var fragmentStateSubject: Subject<FragmentState>
}
