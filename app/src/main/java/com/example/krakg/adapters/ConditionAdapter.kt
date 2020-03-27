package com.example.krakg.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.krakg.R
import com.example.krakg.log
import com.example.krakg.models.ConditionModel
import com.example.krakg.ui.fragments.bots_expanded.ConditionMakerViewModel
import com.example.krakg.ui.fragments.dialogs.*
import kotlinx.android.synthetic.main.cardview_condition_viewer.view.*

class ConditionAdapter( private val context: FragmentActivity): RecyclerView.Adapter<ConditionAdapter.ViewHolder>() {

    private lateinit var conditionsList: List<ConditionModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_condition_viewer,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = conditionsList.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {

            buySell.text = conditionsList[position].buySell
            interval1.text = conditionsList[position].interval1
            indicator1.text = conditionsList[position].indicator1
            change.text = conditionsList[position].change
            operator.text = conditionsList[position].operator
            interval2.text = conditionsList[position].interval2
            indicator2.text = conditionsList[position].indicator2

            cardViewCondition.setOnLongClickListener {
                ConditionMakerViewModel.removeCondition(position)
                true
            }

            buySell.setOnClickListener {
                ConditionBuySellDialog.show(context.supportFragmentManager).getValue = { value ->
                    conditionsList[position].buySell= context.resources.getStringArray(R.array.buy_sell)[value]
                    value.log()
                }
            }

            interval1.setOnClickListener {
                ConditionIntervalDialog.show(context.supportFragmentManager).getValue = { value ->
                    conditionsList[position].interval1= context.resources.getStringArray(R.array.intervals)[value]
                    value.log()
                }
            }

            indicator1.setOnClickListener {
                ConditionIndicatorDialog.show(context.supportFragmentManager).getValue = { value ->
                    conditionsList[position].indicator1= context.resources.getStringArray(R.array.indicators)[value]

                    value.log()
                }
            }

            change.setOnClickListener {
                ConditionChangeDialog.show(context.supportFragmentManager).getValue = { value ->
                    conditionsList[position].change= value
                    value.log()
                }
            }

            operator.setOnClickListener {
                ConditionOperatorDialog.show(context.supportFragmentManager).getValue = { value ->
                    conditionsList[position].operator= context.resources.getStringArray(R.array.operator)[value]

                    value.log()
                }
            }

            interval2.setOnClickListener {
                ConditionIntervalDialog.show(context.supportFragmentManager).getValue = { value ->
                    conditionsList[position].interval2= context.resources.getStringArray(R.array.intervals)[value]
                    value.log()
                }
            }

            indicator2.setOnClickListener {
                ConditionIndicatorDialog.show(context.supportFragmentManager).getValue = { value ->
                    conditionsList[position].indicator2= context.resources.getStringArray(R.array.indicators)[value]
                    value.log()
                }
            }

            amount.setOnClickListener {
               ConditionAmountDialog.show(context.supportFragmentManager).getValue = { value ->
                       conditionsList[position].change = value
                       value.log()
                   }
            }
        }
    }

    fun updateData(data: MutableList<ConditionModel>){
        conditionsList = data
        notifyDataSetChanged()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val cardViewCondition = view.cardview_condition
            val buySell = view.chip_buy_sell
            val _if = view.chip_if
            val interval1 = view.chip_interval1
            val indicator1 = view.chip_indicator
            val change = view.chip_change
            val operator = view.chip_operator
            val interval2 = view.chip_interval2
            val indicator2 = view.chip_indicator2
            val _for = view.chip_for
            val amount = view.chip_amount
    }
}

