package com.example.krakg.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.krakg.R
import com.example.krakg.log
import com.example.krakg.ui.fragments.dialogs.*
import kotlinx.android.synthetic.main.cardview_condition_viewer.view.*

class ConditionAdapter(private val data: List<String>, private val context: FragmentActivity): RecyclerView.Adapter<ConditionAdapter.ViewHolder>() {

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
                ConditionBuySellDialog.show(context.supportFragmentManager).getValue = { value ->
                    value.log()
                }
            }

            interval1.setOnClickListener {
                ConditionIntervalDialog.show(context.supportFragmentManager).getValue = { value ->
                    value.log()
                }
            }

            indicator1.setOnClickListener {
                ConditionIndicatorDialog.show(context.supportFragmentManager).getValue = { value ->
                    value.log()
                }
            }

            change.setOnClickListener {
                ConditionChangeDialog.show(context.supportFragmentManager).getValue = { value ->
                    value.log()
                }
            }

            operator.setOnClickListener {
                ConditionOperatorDialog.show(context.supportFragmentManager).getValue = { value ->
                    value.log()
                }
            }

            interval2.setOnClickListener {
                ConditionIntervalDialog.show(context.supportFragmentManager).getValue = { value ->
                    value.log()
                }
            }

            indicator2.setOnClickListener {
                ConditionIndicatorDialog.show(context.supportFragmentManager).getValue = { value ->
                    value.log()
                }
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

