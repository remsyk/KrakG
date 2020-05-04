package com.example.krakg.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.krakg.R
import com.example.krakg.log
import com.example.krakg.models.ConditionModel
import com.example.krakg.models.IndicatorGuideModel
import com.example.krakg.models.TradeItemModel
import com.example.krakg.view_models.ConditionMakerViewModel
import com.example.krakg.ui.fragments.dialogs.*
import com.example.krakg.view_models.IndicatorGuideViewModel
import kotlinx.android.synthetic.main.cardview_condition_viewer.view.*
import kotlinx.android.synthetic.main.viewgroup_inidactor_list_item.view.*
import kotlinx.android.synthetic.main.viewgroup_trade_item.view.*

class InidcatorGuideListAdapter(private val context: FragmentActivity) : RecyclerView.Adapter<InidcatorGuideListAdapter.ViewHolder>() {

    private lateinit var indicatorList: List<IndicatorGuideModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.viewgroup_inidactor_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = indicatorList.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {
            title.text = indicatorList[position].title
            detail.text = indicatorList[position].detail
        }
    }

    fun updateData(data: MutableList<IndicatorGuideModel>) {
        indicatorList = data
        notifyDataSetChanged()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.textview_title_inidcator
        val detail = view.textview_detail_inidcator
    }
}

