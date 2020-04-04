package com.example.krakg.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.krakg.R
import com.example.krakg.log
import com.example.krakg.models.ConditionModel
import com.example.krakg.models.TradeItemModel
import com.example.krakg.view_models.ConditionMakerViewModel
import com.example.krakg.ui.fragments.dialogs.*
import kotlinx.android.synthetic.main.cardview_condition_viewer.view.*
import kotlinx.android.synthetic.main.viewgroup_trade_item.view.*

class TradeListAdapter(private val context: FragmentActivity): RecyclerView.Adapter<TradeListAdapter.ViewHolder>() {

    private lateinit var tradeList: List<TradeItemModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.viewgroup_trade_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = tradeList.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {
            executed.text = tradeList[position].time

            if(tradeList[position].executed){
                executed.setTextColor(context.resources.getColor(R.color.black))
            }else {
                executed.setTextColor(context.resources.getColor(R.color.grayTransparent))
            }
            pair.text = tradeList[position].pair
            amount.text = tradeList[position].amount
        }
    }

    fun updateData(data: MutableList<TradeItemModel>){
        tradeList = data
        notifyDataSetChanged()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val executed = view.textview_executed
            val pair = view.textview_pair
            val amount = view.textview_amount
    }
}

