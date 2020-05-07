package com.example.krakg.ui.fragments.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.krakg.R
import kotlinx.android.synthetic.main.viewgroup_progressbar.view.*

class ProgressDialog : DialogFragment() {

    var getValue: ((value: String) -> Unit)? = null
    var title ="Doing Stuff"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getString("title")?.let {
             title = it
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val rootView = LayoutInflater.from(context).inflate(R.layout.viewgroup_progressbar, null, false)
       rootView.textView_title_progress.text = title
        return AlertDialog.Builder(requireContext())
            .setView(rootView)
            .create()
    }

    companion object {
        private val newInstance = ProgressDialog()
        private const val TAG = "ConditionMakerDialog"

        fun show(fragmentManager: FragmentManager): ProgressDialog {
            val dialog = newInstance
            dialog.show(fragmentManager, TAG)
            return dialog
        }
    }
}