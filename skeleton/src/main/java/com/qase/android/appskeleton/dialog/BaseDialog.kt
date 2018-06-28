//package com.qase.android.appskeleton.dialog
//
//import android.annotation.SuppressLint
//import android.app.Dialog
//import android.graphics.Color
//import android.graphics.drawable.ColorDrawable
//import android.os.Bundle
//import android.support.v4.app.DialogFragment
//import android.support.v7.app.AlertDialog
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.qase.android.appskeleton.R
//
//abstract class BaseDialog : DialogFragment() {
//
//    companion object {
//        val ARG_TITLE = "title"
//        val ARG_BUTTON_SUBMIT = "button.submit"
//    }
//
//    private var _view: View? = null
//
//    @SuppressLint("InflateParams")
//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val view = activity.layoutInflater.inflate(
//            R.layout.fragment_dialog_general, null
//        )
//
//        view.title.text = arguments.getString(ARG_TITLE)
//        view.submit.text = arguments.getString(ARG_BUTTON_SUBMIT) ?: getString(R.string.confirm_button)
//        view.submit.setOnClickListener {
//            dismiss()
//        }
//        view.cancel.setOnClickListener {
//            dismiss()
//        }
//
//        _view = view
//        buildForm(view)
//
//        return AlertDialog.Builder(activity)
//            .setView(view)
//            .setCancelable(false)
//            .create()
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        return super.onCreateView(inflater, container, savedInstanceState)
//    }
//
//    /**
//     * Configure and build content view
//     */
//    abstract fun buildForm(view: View)
//}
