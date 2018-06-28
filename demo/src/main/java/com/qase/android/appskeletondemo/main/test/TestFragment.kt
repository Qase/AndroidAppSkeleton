package com.qase.android.appskeletondemo.main.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qase.android.appskeleton.fragment.BaseFragment
import com.qase.android.appskeletondemo.R
import kotlinx.android.synthetic.main.fragment_view1.*

class TestFragment : BaseFragment<TestFragmentBundle>() {

    init {
        mActualFragment = this.javaClass.simpleName
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_view1, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bSetState.setOnClickListener(bSetStateOnClickListener())
    }

    fun bSetStateOnClickListener(): View.OnClickListener {
        return View.OnClickListener {
            if (data == null) {
                data = TestFragmentBundle()
                data?.testVar = 0
            } else {
                data!!.testVar += +1
            }

            textStatus!!.text = "TestVar = " + data?.testVar
        }
    }

    override fun onResume() {
        if (data != null) {
            textStatus!!.text = "TestVar = " + data?.testVar
        }

        super.onResume()
    }

    override fun onBackPressed(): Boolean {
        return false
    }
}
