package com.example.krakg.adapters

import android.content.Context
import android.text.GetChars
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.krakg.R
import com.example.krakg.models.GetTickerModel
import com.google.android.material.textview.MaterialTextView
import kotlinx.android.synthetic.main.cardview_dashboard.view.*
import kotlinx.android.synthetic.main.viewgroup_api_dashboard_item.view.*
import kotlinx.android.synthetic.main.viewgroup_api_dashboard_item_title.view.*

class DashboardCardAdapter( private val context: Context): RecyclerView.Adapter<DashboardCardAdapter.ViewHolder>() {

    lateinit var data: MutableList<GetTickerModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_dashboard,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {

            coinTitle.text = "Coin"
            coinItem.text = "BTC"

            priceTitle.text =  "Price"
            priceItem.text = "$9000"

            avgTitle.text = "Average"
            avgItem.text = "200"

            logTitle.text = "Logrithmic"
            logItem.text = "400"

            monthlyTitle.text ="Monthly"
            monthlyItem.text = "7000"

        }
    }

    fun updateData(_data: MutableList<GetTickerModel>) {
            data = _data
            notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val fab: FloatingActionButton = view.fab_dashboard
        //val dashCard: CardView = view.cardview_dashboard

        val coinTitle: MaterialTextView = view.include_coin.textview_title
        val coinItem: MaterialTextView = view.include_coin.textView_item

        val priceTitle: MaterialTextView = view.include_price.textview_title
        val priceItem: MaterialTextView = view.include_price.textView_item

        val avgTitle: MaterialTextView = view.include_avg.textview_title
        val avgItem: MaterialTextView = view.include_avg.textView_item

        val logTitle: MaterialTextView = view.include_log.textview_title
        val logItem: MaterialTextView = view.include_log.textView_item

        val monthlyTitle: MaterialTextView = view.include_monthly.textview_title
        val monthlyItem: MaterialTextView = view.include_monthly.textView_item
    }
}

