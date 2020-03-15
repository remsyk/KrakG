package com.example.krakg.ui.fragments.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.krakg.R
import com.example.krakg.log

class ConditionIndicatorDialog: DialogFragment() {

    var getValue : ((value:Int) -> Unit)? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return AlertDialog.Builder(context!!)
            .setTitle("Select Item")
            .setSingleChoiceItems(resources.getStringArray(R.array.indicators), 0){ dialog, which ->
                getValue?.let { it(2) }
                dialog.dismiss()
            }
            .create()
    }

    companion object{
        private val newInstance =
            ConditionIndicatorDialog()
        private const val TAG = "ConditionMakerDialog"

        fun show(fragmentManager: FragmentManager): ConditionIndicatorDialog {
            val dialog =
                newInstance
            dialog.show(fragmentManager,
                TAG
            )
            return dialog
        }
    }
}