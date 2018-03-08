package com.qase.android.appskeletondemo.main.testviewmodel

import android.arch.lifecycle.MutableLiveData
import com.qase.android.appskeleton.fragment.BaseBundle
import com.qase.android.appskeleton.fragment.BaseViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class TestvmViewModel : BaseViewModel<BaseBundle>() {

    val testLiveData: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }

    private var disposable: Disposable? = null

    fun onGetDataClicked() {
        if (disposable!=null) {
            disposable?.dispose()
            disposable = null
        }
        else {
            disposable = Observable
                .interval(1000, TimeUnit.MILLISECONDS)
                .subscribe({
                    testLiveData.postValue(it.toInt())
                })
        }
    }

}
