package com.example.krakg.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.anychart.AnyChartView
import com.example.krakg.ui.fragments.LineChartActivity
import com.example.krakg.R
import com.example.krakg.models.BotModel
import com.example.krakg.ui.activities.BotExpandedActivity
import com.example.krakg.ui.fragments.bots.BotsViewModel
import kotlinx.android.synthetic.main.cardview_bot.view.*
import kotlinx.android.synthetic.main.viewgroup_cardview_bot_bottom.view.*

class BotCardAdapter(
    private val data: MutableList<BotModel>,
    private val context: FragmentActivity
) : RecyclerView.Adapter<BotCardAdapter.ViewHolder>() {

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

            title.text = data.get(position).title
            // coinImageView.setImageDrawable(context.getDrawable(R.drawable.ic_iconmonstr_bitcoin_3))
            value.text = data.get(position).value
            gross.text = data.get(position).gross

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
        //val coinImageView: ImageView = view.include_viewgroup_bottom_bot.imageView_bot_coin
        val value: TextView = view.include_viewgroup_bottom_bot.textView_bot_value
        val gross: TextView = view.include_viewgroup_bottom_bot.textview_bot_gross
        val title: TextView = view.textView_bot_title
    }
}


