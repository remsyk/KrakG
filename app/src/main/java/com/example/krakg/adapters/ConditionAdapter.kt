package com.example.krakg.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.krakg.R
import com.example.krakg.ui.fragments.bots_expanded.ConditionMakerDialog
import kotlinx.android.synthetic.main.cardview_condition_viewer.view.*
import kotlinx.android.synthetic.main.viewgroup_dialog_condition_editor.view.*

class ConditionAdapter(private val data: List<String>, private val context: FragmentActivity): RecyclerView.Adapter<ConditionAdapter.ViewHolder>() {

    private val buySellList = listOf("Title One", "Title Two", "Title Three", "Title Four")

    val dialog: ConditionMakerDialog = ConditionMakerDialog()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_condition_viewer,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {

            buySell.setOnClickListener {
                dialog.show(context.supportFragmentManager,"wer")
            }


        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val buySell = view.chip_buy_sell
        val _if = view.chip_if
        val interval1 = view.chip_interval1
        val indicator1 = view.chip_indicator
        val change = view.chip_change
        val operator = view.chip_operator
        val interval2 = view.chip_interval2
        val indicator2 = view.chip_indicator2
    }
}

