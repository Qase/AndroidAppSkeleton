package com.qase.android.appskeleton.permission

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

class PermissionManager(context: Context, requiredPermissions: List<String>) {
    private val globalRequestCode = 100
    var permissionMap: HashMap<String, Int> = HashMap()
    var listeners: MutableSet<IPermissionManagerListener> = mutableSetOf()

    init {
        for (requiredPermission in requiredPermissions) {
            if (ContextCompat.checkSelfPermission(context, requiredPermission)
                    != PackageManager.PERMISSION_GRANTED) {
                permissionMap[requiredPermission] = PackageManager.PERMISSION_DENIED
            } else {
                permissionMap[requiredPermission] = PackageManager.PERMISSION_GRANTED
            }
        }
    }

    fun registerListener(listener: IPermissionManagerListener) {
        listeners.add(listener)
    }

    fun unRegisterListener(listener: IPermissionManagerListener) {
        listeners.remove(listener)
    }

    /**
     * Request all defined permissions
     */
    fun requestAllPermissions(activity: Activity) {
        val permissionRequestList = arrayListOf<String>()
        val keys = permissionMap.keys
        keys.forEach { permission ->
            // Here, thisActivity is the current activity
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                } else {
                    // No explanation needed, we can request the permission.
                    permissionRequestList.add(permission)
                }
            } else {
                // Permission has already been granted
                permissionMap[permission] = PackageManager.PERMISSION_GRANTED
            }
        }
        requestPermissions(activity, permissionRequestList.toTypedArray())
    }

    /**
     * Callback with permission results
     * @NOTE unfortunately this must be called directly from overriden method in Activity
     * @param requestCode Code used to pair with request
     * @param permissions Array of requested permissions
     * @param grantResults Array of results represented by integers
     */
    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == globalRequestCode) {
            permissions.forEachIndexed { index, permission ->
                val result = grantResults[index]
                permissionMap[permission] = result
                if (result == PackageManager.PERMISSION_GRANTED) {
                    for (listener in listeners) {
                        listener.onPermissionGranted(permission)
                    }
                } else {
                    for (listener in listeners) {
                        listener.onPermissionDenied(permission)
                    }
                }
            }
        }
    }

    /**
     * Initiate permission request
     * @param permission Array of permissions to request
     */
    fun requestPermissions(activity: Activity, permissions: Array<out String>) {
        if (permissions.count() > 0) {
            ActivityCompat.requestPermissions(activity, permissions, globalRequestCode)
        }
    }

    /**
     * Check single permission
     * @param permission String of permission
     * @return True if permission is granted
     */
    fun checkPermission(permission: String): Boolean {
        val desiredPermission = permissionMap.get(permission)
        return desiredPermission != null && desiredPermission == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Check multiple permissions
     * @param permissions Array of permission strings
     * @return True if all permissions are granted
     */
    fun checkPermissions(permissions: Array<out String>): Boolean {
        return permissions.all { checkPermission(it) }
    }
}