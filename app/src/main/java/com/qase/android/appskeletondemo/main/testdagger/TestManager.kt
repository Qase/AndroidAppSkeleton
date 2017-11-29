package com.qase.android.appskeletondemo.main.testdagger

import android.arch.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.lang.Thread.sleep
import java.util.Random

/**
 * Created by tomas on 29.11.2017.
 */
class TestManager {
    fun getData(): MutableLiveData<Int> {
        val livedata = MutableLiveData<Int>()
        val r = Random()
        val start = r.nextInt(20)
        Observable
            .range(start, 10)
            .map { it * 2 }
            .doOnNext { sleep(500) }
            .subscribeOn(Schedulers.io())
            .subscribe({
                livedata.postValue(it.toInt())
            })
        return livedata
    }
}