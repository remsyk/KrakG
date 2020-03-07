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
import com.google.android.material.textview.MaterialTextView
import kotlinx.android.synthetic.main.cardview_bot.view.*
import kotlinx.android.synthetic.main.cardview_condition.view.*
import kotlinx.android.synthetic.main.viewgroup_cardview_bot_bottom.view.*

class ConditionAdapter(private val data: List<String>, private val context: Context): RecyclerView.Adapter<ConditionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_condition,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {
            title.text = "Buy"
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: MaterialTextView = view.textview_title_request

    }
}

