//package com.qase.android.appskeleton.dialog
//
//import android.os.Bundle
//import android.support.v4.app.Fragment
//import android.view.View
//import cz.intens.msd.main.forms.FormBuilder
//import cz.intens.msd.main.forms.TextFormElement
//import kotlinx.android.synthetic.main.fragment_dialog_general.view.*
//
//class InfoDialog : BaseDialog() {
//
//    companion object {
//        val ARG_MSG = "msg"
//
//        fun show(fragment: Fragment, tag: String, title: String, msg: String) {
//            InfoDialog().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_TITLE, title)
//                    putString(ARG_MSG, msg)
//                }
//            }.show(fragment.fragmentManager, tag)
//        }
//    }
//
//    override fun buildForm(view: View) {
//        useDefaultMargin()
//        view.cancel.visibility = View.GONE
//
//        val desc = TextFormElement("desc")
//        desc.text = arguments.getString(ARG_MSG)
//
//        val formBuilder = FormBuilder.create(activity, view.content)
//        formBuilder.add(desc)
//        formBuilder.build()
//    }
//}
