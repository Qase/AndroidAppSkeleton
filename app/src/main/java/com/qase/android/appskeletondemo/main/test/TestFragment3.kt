package com.qase.android.appskeletondemo.main.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qase.android.appskeleton.fragment.BaseBundle
import com.qase.android.appskeleton.fragment.BaseFragment
import com.qase.android.appskeletondemo.App
import com.qase.android.appskeletondemo.R

class TestFragment3 : BaseFragment<BaseBundle>() {
    init {
        mActualFragment = this.javaClass.simpleName
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        App.instance.fragmentManager.changeFragment(TestSubfragment::class.java, TestSubfragment::class.java.simpleName + "_1", null, R.id.fragment_container_test, childFragmentManager)
        App.instance.fragmentManager.changeFragment(TestSubfragment::class.java, TestSubfragment::class.java.simpleName + "_2", null, R.id.fragment_container_test2, childFragmentManager)

        super.onCreateView(inflater, container, savedInstanceState)

        return inflater?.inflate(R.layout.fragment_view3, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onBackPressed(): Boolean {
        return false
    }
}
