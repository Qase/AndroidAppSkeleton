package com.qase.android.appskeletondemo.main.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qase.android.appskeleton.fragment.BaseBundle
import com.qase.android.appskeleton.fragment.BaseFragment
import com.qase.android.appskeletondemo.App
import com.qase.android.appskeletondemo.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_view3.*

class TestFragment3 : BaseFragment<BaseBundle>() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        mActualFragment = this.javaClass.simpleName
    }

    private lateinit var fragment1: TestSubfragment
    private lateinit var fragment2: TestSubfragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragment1 = App.instance.fragmentManager.changeFragment(TestSubfragment::class.java, TestSubfragment::class.java.simpleName + "_1", null, R.id.fragment_container_test, childFragmentManager)
        fragment2 = App.instance.fragmentManager.changeFragment(TestSubfragment::class.java, TestSubfragment::class.java.simpleName + "_2", null, R.id.fragment_container_test2, childFragmentManager)

        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_view3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val disposable1 = fragment1.fragmentStateSubject.subscribe {
            state1.text = it.value
        }
        compositeDisposable.add(disposable1)
        val disposable2 = fragment2.fragmentLifecycleSubject.subscribe {
            state2.text = it.value
        }
        compositeDisposable.add(disposable2)
    }

    override fun onDestroyView() {
        compositeDisposable.clear()
        super.onDestroyView()
    }

    override fun onBackPressed(): Boolean {
        return false
    }
}
