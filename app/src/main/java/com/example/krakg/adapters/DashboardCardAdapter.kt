package com.example.krakg.adapters

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.krakg.R
import com.example.krakg.models.GetTickerModel
import com.google.android.material.textview.MaterialTextView
import kotlinx.android.synthetic.main.cardview_dashboard.view.*
import kotlinx.android.synthetic.main.viewgroup_api_dashboard_item.view.*

class DashboardCardAdapter( private val context: Context): RecyclerView.Adapter<DashboardCardAdapter.ViewHolder>() {

    lateinit var data: MutableList<GetTickerModel.Result.Pair>
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
            coinItem.setTypeface(null, Typeface.BOLD)
            when(position){
                0-> coinItem.text = "BTC/USD"
                1-> coinItem.text = "LTC/USD"
                2-> coinItem.text = "LTC/BTC"
            }

            askTitle.text =  "Price"
            askItem.text = data[position].ask!![0]

            bidTitle.text = "Bid"
            bidItem.text = data[position].bid!![0]

            lastTitle.text = "Last"
            lastItem.text = data[position].last!![0]

            highTitle.text = "High"
            highItem.text = data[position].high!![0]

            lowTitle.text = "Low"
            lowItem.text = data[position].low!![0]

            openTitle.text = "Open"
            openItem.text = data[position].open

            volumeWeightedTitle.text = "Volume Weighted"
            volumeWeightedItem.text = data[position].volumeWeighted!![0]

            numTradesTitle.text = "Num. Trades"
            numTradesItem.text = data[position].numTrades!![0].toString()

            volumeTitle.text = "Volume"
            volumeItem.text = data[position].volume!![0]
        }
    }

    fun updateData(_data: MutableList<GetTickerModel.Result.Pair>) {
            data = _data
            notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val coinTitle: MaterialTextView = view.include_coin.textview_title
        val coinItem: MaterialTextView = view.include_coin.textView_item

        val askTitle: MaterialTextView = view.include_ask.textview_title
        val askItem: MaterialTextView = view.include_ask.textView_item

        val bidTitle: MaterialTextView = view.include_bid.textview_title
        val bidItem: MaterialTextView = view.include_bid.textView_item

        val lastTitle: MaterialTextView = view.include_last.textview_title
        val lastItem: MaterialTextView = view.include_last.textView_item

        val highTitle: MaterialTextView = view.include_high.textview_title
        val highItem: MaterialTextView = view.include_high.textView_item

        val lowTitle: MaterialTextView = view.include_low.textview_title
        val lowItem: MaterialTextView = view.include_low.textView_item

        val openTitle: MaterialTextView = view.include_open.textview_title
        val openItem: MaterialTextView = view.include_open.textView_item

        val volumeWeightedTitle: MaterialTextView = view.include_volumeWeighted.textview_title
        val volumeWeightedItem: MaterialTextView = view.include_volumeWeighted.textView_item

        val numTradesTitle: MaterialTextView = view.include_numTrades.textview_title
        val numTradesItem: MaterialTextView = view.include_numTrades.textView_item

        val volumeTitle: MaterialTextView = view.include_volume.textview_title
        val volumeItem: MaterialTextView = view.include_volume.textView_item
    }
}

