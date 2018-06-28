package com.qase.android.appskeletondemo.main.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qase.android.appskeleton.fragment.BaseFragment
import com.qase.android.appskeletondemo.R
import kotlinx.android.synthetic.main.fragment_subview.*

class TestSubfragment : BaseFragment<TestFragmentBundle>() {

    init {
        mActualFragment = this.javaClass.simpleName
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_subview, container, false);

        val view = inflater.inflate(R.layout.fragment_subview, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bSetStateSub.setOnClickListener(bSetStateSubOnClickListener())

    }

    private fun bSetStateSubOnClickListener(): View.OnClickListener? {
        return View.OnClickListener {
            if (data == null) {
                data = TestFragmentBundle()
                data?.testVar = 0
            } else {
                data!!.testVar += +1
            }

            textStatusSub!!.text = "TestVar = " + data?.testVar
        }
    }

    override fun onResume() {

        if (data != null) {
            textStatusSub!!.text = "TestVar = " + data?.testVar
        }

        super.onResume()
    }

    override fun onBackPressed(): Boolean {
        return false
    }
}
