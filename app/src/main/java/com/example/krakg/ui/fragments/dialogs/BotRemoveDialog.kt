package com.example.krakg.ui.fragments.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.krakg.R
import com.example.krakg.log

class BotRemoveDialog : DialogFragment() {

    var getValue: ((value: Boolean) -> Unit)? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return AlertDialog.Builder(requireContext())
            .setTitle("Are you sure you want to delete this bot?")
            .setPositiveButton("YES") { dialog,  which ->
                "positive button".log()
                getValue?.let{it(true)}
                delete = true
            }
            .setNegativeButton("No") { dialog, which ->
                "negative button".log()
                getValue?.let{it(false)}
            }

            .create()
    }

    companion object {
        private val newInstance = BotRemoveDialog()
        private const val TAG = "BotRemoveDialog"
         private var delete=  false

        fun show(fragmentManager: FragmentManager): BotRemoveDialog {
            val dialog = newInstance
            dialog.show(fragmentManager, TAG)
            return dialog
        }
    }
}