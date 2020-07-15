package com.example.krakg.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.krakg.R
import com.example.krakg.models.BotModel
import com.example.krakg.ui.fragments.ConditionMakerFragment
import com.example.krakg.ui.fragments.TradesListFragment
import com.example.krakg.view_models.BotsViewModel
import kotlinx.android.synthetic.main.cardview_bot_expanded_item.view.*

class BotExpandedCardAdapter(private val context: Context) : RecyclerView.Adapter<BotExpandedCardAdapter.ViewHolder>() {

    private lateinit var metricList: BotModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_bot_expanded_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = 8


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {

            //TODO diaable paper trading listener

            when (position) {

                0 -> {//Net Change
                    title.text = "Net Change"
                    body.text = metricList.netChange.toString() + "%"
                }

                1 -> {//Gross
                    title.text = "Gross"
                    body.text =  "+" + metricList.gross.toString()+ "%"
                }

                2 -> {//Value
                    title.text = "Value"
                    body.text = "$" + metricList.value.toString()
                }

                3 -> {//Avg
                    title.text = "Avg"
                    body.text = metricList.avg.toString() + "%"
                }


                4 -> {//Total Trades
                    title.text = "Total Trades"
                    card.isEnabled = false //todo remove on implementation
                    body.text = metricList.totalTrades.toString()
                    card.setOnClickListener {
                        (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                            .replace(
                                R.id.framelayout_generic_layout,
                                TradesListFragment()
                            )
                            .addToBackStack("TradesListFragment")
                            .commit()
                    }
                }


                5 -> {//Paper Trading
                    card.isEnabled= false //todo remove on implementation
                    title.text = "Paper Trading"
                    body.text = metricList.paperTrading.toString()
                    card.setOnClickListener {
                        val tempBool = !(metricList.paperTrading)
                        BotsViewModel.updatePaperTrading(position, tempBool)
                    }
                }
                6 -> {//Condition List
                    title.text = "Condition List"
                    body.text = metricList.conditionList.toString()
                    card.setOnClickListener {
                        (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                            .replace(
                                R.id.framelayout_generic_layout,
                                ConditionMakerFragment()
                            )
                            .addToBackStack("Fragment")
                            .commit()
                    }
                }
                7 -> {//Exchange
                    title.text = "Exchange"
                    body.text = metricList.exchange.toString()
                }
            }
        }
    }

    fun updateData(data: BotModel) {
        metricList = data
        notifyDataSetChanged()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card: CardView = view.cardview_bot_expanded
        val title: TextView = view.textView_title_botexp
        val body: TextView = view.textView_body_botexp
    }
}

