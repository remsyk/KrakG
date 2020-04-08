package com.example.krakg.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.krakg.R
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_settings.picker_interval
import kotlinx.android.synthetic.main.fragment_settings.view.*
import kotlinx.android.synthetic.main.fragment_settings_2.*
import kotlinx.android.synthetic.main.viewgroup_setting_item_textviews.view.*
import kotlinx.android.synthetic.main.viewgroup_settings_item.view.*


class TransferFundsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.setCustomView(R.layout.viewgroup_actionbar_settings)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.setCustomView(R.layout.viewgroup_actionbar_settings)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_transfer_funds, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* val autoCompAdapter: ArrayAdapter<String> = ArrayAdapter<String>(context, R.layout.viewgroup_interval_autocomplete_item, resources.getStringArray(R.array.transfer_interval))
           filled_exposed_dropdown.setAdapter(autoCompAdapter)*/

    }
}