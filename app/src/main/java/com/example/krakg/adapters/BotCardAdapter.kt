package com.example.krakg.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.anychart.AnyChartView
import com.example.krakg.ui.fragments.LineChartActivity
import com.example.krakg.R
import com.example.krakg.ui.activities.BotExpandedActivity
import kotlinx.android.synthetic.main.cardview_bot.view.*
import kotlinx.android.synthetic.main.viewgroup_cardview_bot_bottom.view.*

class BotCardAdapter(private val data: List<String>, private val context: Context): RecyclerView.Adapter<BotCardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_bot,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {
            title.text = data.get(position)
            coinImageView.setImageDrawable(context.getDrawable(R.drawable.ic_android_black_24dp))
            value.text ="$400"
            gross.text = "+4.32%"

            val chartModel = LineChartActivity(chart)
            chartModel.onCreate()

            botCard.setOnClickListener {
                context.startActivity(Intent(context, BotExpandedActivity::class.java))
            }
        }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val chart: AnyChartView = view.chart
        val botCard: CardView = view.cardview_bot
        val coinImageView: ImageView = view.include_viewgroup_bottom_bot.imageView_bot_coin
        val value: TextView = view.include_viewgroup_bottom_bot.textView_bot_value
        val gross: TextView = view.include_viewgroup_bottom_bot.textview_bot_gross
        val title: TextView = view.textView_bot_title
    }
}

