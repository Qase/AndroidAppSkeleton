package com.qase.android.appskeleton.permission

interface IPermissionManagerListener {

    fun onPermissionGranted(permission: String)

    fun onPermissionDenied(permission: String)

}
