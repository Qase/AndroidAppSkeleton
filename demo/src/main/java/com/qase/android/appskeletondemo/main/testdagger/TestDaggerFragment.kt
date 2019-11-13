package com.qase.android.appskeletondemo.main.testdagger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.qase.android.appskeleton.fragment.BaseBundle
import com.qase.android.appskeleton.fragment.BaseViewModelFragment
import com.qase.android.appskeletondemo.R
import kotlinx.android.synthetic.main.fragment_view_model.*

class TestDaggerFragment : BaseViewModelFragment<BaseBundle, TestDaggerViewModel>(TestDaggerViewModel::class.java) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_dagger, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.testLiveData.observe(viewLifecycleOwner, Observer {
            textData.text = it?.toString()
        })
    }

}
