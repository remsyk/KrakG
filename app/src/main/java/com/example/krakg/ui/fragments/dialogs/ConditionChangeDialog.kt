package com.example.krakg.ui.fragments.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.krakg.R
import kotlinx.android.synthetic.main.viewgroup_dialog_condition_change.view.*

class ConditionChangeDialog: DialogFragment() {

    var getValue : ((value:String) -> Unit)? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

         val rootView = LayoutInflater.from(context).inflate(R.layout.viewgroup_dialog_condition_change, null, false)

        with(rootView) {
            picker_change_type.minValue = 0
            picker_change_type.maxValue = 3
            picker_change_type.displayedValues = resources.getStringArray(R.array.change_types)
        }

        return AlertDialog.Builder(requireContext())
            .setTitle("Select Item")
            .setNegativeButton("Set") {dialog, _->
                getValue?.let { it(rootView.editText_change_value.text.toString()) }
                dialog.dismiss()
            }
            .setView(rootView)
            .create()
    }

    companion object{
        private val newInstance =
            ConditionChangeDialog()
        private const val TAG = "ConditionMakerDialog"

        fun show(fragmentManager: FragmentManager): ConditionChangeDialog {
            val dialog =
                newInstance
            dialog.show(fragmentManager,
                TAG
            )
            return dialog
        }
    }
}