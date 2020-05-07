package com.example.krakg.ui.fragments.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.R
import com.example.krakg.adapters.InidcatorGuideListAdapter
import com.example.krakg.log
import com.example.krakg.models.IndicatorGuideModel
import com.example.krakg.view_models.IndicatorGuideViewModel
import kotlinx.android.synthetic.main.fragment_inidactor_list.view.*


class IndicatorGuideDialog : DialogFragment() {

    var getValue: ((value: String) -> Unit)? = null
    lateinit var recyclerViewHolder: RecyclerView

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val rootView = LayoutInflater.from(context).inflate(R.layout.fragment_inidactor_list, null, false)

        recyclerViewHolder = rootView.recyclerView_indicators
        recyclerViewHolder.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = InidcatorGuideListAdapter(requireActivity())
        recyclerViewHolder.adapter = adapter

        rootView.cardview_inidicator_text.edit_text_search_indicators.doAfterTextChanged {
           adapter.updateData( IndicatorGuideViewModel.filter(it.toString()))
        }

        IndicatorGuideViewModel.getIndicators().observe(requireActivity(), Observer<MutableList<IndicatorGuideModel>> {
            adapter.updateData(it)
        })

        return AlertDialog.Builder(requireContext())
            .setTitle("Indicator Guide")
            .setView(rootView)
            .create()
    }


    companion object {
        private val newInstance = IndicatorGuideDialog()
        private const val TAG = "IndicatorGuideDialog"

        fun show(fragmentManager: FragmentManager): IndicatorGuideDialog {
            val dialog = newInstance
            dialog.show(fragmentManager, TAG)
            return dialog
        }
    }
}