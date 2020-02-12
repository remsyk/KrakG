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
import com.example.krakg.models.ExpandedBotCardModel
import com.example.krakg.ui.activities.BotExpandedActivity
import kotlinx.android.synthetic.main.cardview_bot.view.*
import kotlinx.android.synthetic.main.cardview_bot_expanded_item.view.*
import kotlinx.android.synthetic.main.viewgroup_cardview_bot_bottom.view.*

class BotExpandedCardAdapter(private val data: List<ExpandedBotCardModel>, private val context: Context): RecyclerView.Adapter<BotExpandedCardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_bot_expanded_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {
            title.text = data[position].title
            var bodyText = ""
            bodyText = if(data[position].prefix.isNullOrBlank()){
                if(data[position].suffix.isNullOrBlank()){
                    data[position].value.toString()
                }else{
                    data[position].value.toString() + data[position].suffix
                }
            }else{
                data[position].prefix + data[position].value
            }

            body.text = bodyText

            if(!data[position].hasasset) {
                asset.visibility = View.GONE
            }

        }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.textView_title_botexp
        val body: TextView = view.textView_body_botexp
        val asset: ImageView = view.imageview_asset

    }
}

