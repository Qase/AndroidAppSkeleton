package com.qase.android.appskeleton.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import com.qase.android.appskeleton.BaseApp
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject

abstract class BaseFragment<BundleType : BaseBundle> : Fragment(), IFragment<BundleType> {

    override var data: BundleType? = null
    protected var mActualFragment = "BaseFragment"
    protected var showLifecycleLog = true
    override var fragmentStateSubject: Subject<FragmentState> = BehaviorSubject.create()
    override var fragmentLifecycleSubject: Subject<FragmentLifecycleState> = BehaviorSubject.create()

    override fun onBackPressed(): Boolean = false

    /**
     * Save/Restore data
     */
    override fun onSaveInstanceState(outState: Bundle) {
        if (showLifecycleLog) Log.d(mActualFragment, "onSaveInstanceState")

        //Save the fragment's state here
        outState.putSerializable(BUNDLE_KEY, data)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        if (showLifecycleLog) Log.d(mActualFragment, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        if (showLifecycleLog) Log.d(mActualFragment, "onResume")
        super.onResume()

        BaseApp.instance.fragmentManager.evaluateConstraints(this.javaClass)
    }

    /**
     * Overrides (are here for optional monitoring of fragment lifecycle)
     */

    override fun onPause() {
        if (showLifecycleLog) Log.d(mActualFragment, "onPause")
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (showLifecycleLog) Log.d(mActualFragment, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        if (showLifecycleLog) Log.d(mActualFragment, "onDestroy")
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        if (showLifecycleLog) Log.d(mActualFragment, "onCreateOptionsMenu")
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (showLifecycleLog) Log.d(mActualFragment, "onCreateView")
        if (savedInstanceState != null) {
            //Restore the fragment's state here
            //if data is not null then it was set by FragmentManager (e.g. in changeFragment(..., extras, ...) method) and we do not want to overwrite it
            if (data == null) {
                data = savedInstanceState.getSerializable(BUNDLE_KEY) as BundleType?
            }
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (showLifecycleLog) Log.d(mActualFragment, "onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        fragmentLifecycleSubject.onNext(FragmentLifecycleState.VIEW_CREATED)
    }

    override fun onDestroyView() {
        if (showLifecycleLog) Log.d(mActualFragment, "onDestroyView")
        fragmentLifecycleSubject.onNext(FragmentLifecycleState.VIEW_DESTROYED)
        super.onDestroyView()
    }

    override fun onAttach(context: Context?) {
        if (showLifecycleLog) Log.d(mActualFragment, "onAttach")
        super.onAttach(context)
    }

    override fun onDetach() {
        if (showLifecycleLog) Log.d(mActualFragment, "onDetach")
        super.onDetach()
    }

    companion object {
        protected val BUNDLE_KEY = "fragment_data"
    }
}
