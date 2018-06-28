package com.qase.android.appskeletondemo.main.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qase.android.appskeleton.fragment.BaseBundle
import com.qase.android.appskeleton.fragment.BaseFragment
import com.qase.android.appskeletondemo.R

class TestFragment2 : BaseFragment<BaseBundle>() {
    init {
        mActualFragment = this.javaClass.simpleName
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view2, container, false)
    }

    override fun onBackPressed(): Boolean {
        return false
    }
}
