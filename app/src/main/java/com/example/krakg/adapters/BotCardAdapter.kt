package com.example.krakg.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.anychart.AnyChartView
import com.example.krakg.ui.fragments.LineChartActivity
import com.example.krakg.R
import com.example.krakg.models.BotModel
import com.example.krakg.ui.activities.BotExpandedActivity
import com.example.krakg.ui.fragments.dialogs.BotRemoveDialog
import com.example.krakg.view_models.BotsViewModel
import kotlinx.android.synthetic.main.cardview_bot.view.*
import kotlinx.android.synthetic.main.viewgroup_cardview_bot_bottom.view.*

class BotCardAdapter(
    private val context: FragmentActivity
) : RecyclerView.Adapter<BotCardAdapter.ViewHolder>() {

    lateinit var botsList: MutableList<BotModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_bot,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = botsList.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        with(viewHolder) {
            title.text = botsList[position].title
            value.text = botsList[position].value
            gross.text = botsList[position].gross
            exchange.text = botsList[position].exchange

            val chartModel = LineChartActivity(chart)
            chartModel.onCreate()

            botCard.setOnClickListener {
                context.startActivity(Intent(context, BotExpandedActivity::class.java))
            }
            botCard.setOnLongClickListener {
                BotRemoveDialog.show(context.supportFragmentManager).getValue={
                    if(it){
                        BotsViewModel.removeBot(position)
                    }
                }
                true
            }
        }
    }

    fun updateData(data: MutableList<BotModel>) {
        botsList = data
        notifyDataSetChanged()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val chart: AnyChartView = view.chart
        val botCard: CardView = view.cardview_bot
        val value: TextView = view.include_viewgroup_bottom_bot.textView_bot_value
        val gross: TextView = view.include_viewgroup_bottom_bot.textview_bot_gross
        val title: TextView = view.textView_bot_title
        val exchange: TextView= view.include_viewgroup_bottom_bot.textView_bot_exchange
    }
}


