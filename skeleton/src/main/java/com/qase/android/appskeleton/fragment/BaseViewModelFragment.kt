package com.qase.android.appskeleton.fragment

import androidx.lifecycle.ViewModelProviders


/**
 * Created by tomas on 22.08.2017.
 */

abstract class BaseViewModelFragment<BundleType : BaseBundle, ViewModelType : BaseViewModel<BundleType>> : BaseFragment<BundleType> {

    private var viewModelClass: Class<ViewModelType>

    constructor(viewModelClass: Class<ViewModelType>) {
        this.viewModelClass = viewModelClass
    }

    open val viewModel: ViewModelType
        get() = ViewModelProviders.of(this).get(viewModelClass)
}
