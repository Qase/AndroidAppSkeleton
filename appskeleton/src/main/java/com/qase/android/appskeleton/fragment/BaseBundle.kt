package com.qase.android.appskeleton.fragment

import java.io.Serializable

open class BaseBundle : Serializable {

    override fun toString(): String {
        val builder = StringBuilder()
        try {
            val fieldList = this.javaClass.declaredFields
            for (f in fieldList) {
                f.isAccessible = true
                builder.append(f.name)
                builder.append(" (")
                builder.append(f.type)
                builder.append("): ")
                builder.append(f.get(this))
                builder.append("\n")
            }
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

        return builder.toString()
    }

}
