//package com.qase.android.appskeleton.dialog
//
//import android.app.AlertDialog
//import android.app.Dialog
//import android.os.Bundle
//import android.support.v4.app.DialogFragment
//import android.view.View
//import android.widget.TextView
//import com.qase.android.appskeleton.R
//import cz.intens.msd.R
//
///**
// * Created by lubos on 20.11.16.
// */
//
//class TextDialogFragment : DialogFragment() {
//
//    private var mText = ""
//    private var mListener: OnTextDialogListener? = null
//
//    fun setText(text: String) {
//        mText = text
//    }
//
//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val builder = AlertDialog.Builder(activity)
//        val inflater = activity.layoutInflater
//        val layout = inflater.inflate(R.layout.dialog_text, null)
//
//        val text = layout.findViewById<View>(R.id.text) as TextView
//        text.text = mText
//        builder.setView(layout)
//                .setPositiveButton(R.string.ok) { dialog, id ->
//                    mListener?.onClickOK()
//                    if (getDialog() != null)
//                        this@TextDialogFragment.dialog.cancel()
//                }
//                .setNegativeButton(R.string.cancel) { dialog, id ->
//                    if (getDialog() != null)
//                        this@TextDialogFragment.dialog.cancel()
//                }
//        return builder.create()
//    }
//
//    override fun onPause() {
//        super.onPause()
//        dismiss()
//    }
//
//    fun setListener(listener: OnTextDialogListener) {
//        mListener = listener
//    }
//
//    // Container Activity must implement this interface
//    interface OnTextDialogListener {
//        fun onClickOK()
//    }
//}
