package com.qase.android.appskeletondemo.main.testviewmodel

import android.os.Bundle
import android.view.View
import com.qase.android.appskeleton.fragment.BaseViewModelFragment

class TestvmFragment : BaseViewModelFragment<TestvmBundle, TestvmViewModel>(TestvmViewModel::class.java) {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onBackPressed(): Boolean {
        return false
    }
}
