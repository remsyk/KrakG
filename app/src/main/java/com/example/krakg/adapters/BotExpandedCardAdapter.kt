package com.example.krakg.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.krakg.R
import com.example.krakg.log
import com.example.krakg.models.ExpandedBotCardModel
import com.example.krakg.ui.fragments.ConditionMakerFragment
import com.example.krakg.view_models.ExpandedBotViewModel
import kotlinx.android.synthetic.main.cardview_bot_expanded_item.view.*

class BotExpandedCardAdapter( private val context: Context): RecyclerView.Adapter<BotExpandedCardAdapter.ViewHolder>() {

    private lateinit var indicatorList: List<ExpandedBotCardModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.cardview_bot_expanded_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = indicatorList.size


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder) {
            title.text = indicatorList[position].title
            var bodyText = ""
            bodyText = if(indicatorList[position].prefix.isNullOrBlank()){
                if(indicatorList[position].suffix.isNullOrBlank()){
                    indicatorList[position].value.toString()
                }else{
                    indicatorList[position].value.toString() + indicatorList[position].suffix
                }
            }else{
                indicatorList[position].prefix + indicatorList[position].value
            }

            body.text = bodyText

            if(!indicatorList[position].hasasset) {
                asset.visibility = View.GONE
            }else{
                asset.setImageDrawable( (context as AppCompatActivity).resources.getDrawable(R.drawable.ic_android_black_24dp, context.getTheme()))
            }

            card.setOnClickListener {
                when(position){

                    7 -> {

                        val tempBool = !(indicatorList[position].value.toString().toBoolean())
                        tempBool.log()
                        val tempIndicator = indicatorList[position]
                        tempIndicator.value =  !tempBool
                        ExpandedBotViewModel.updateIndicator(position, tempIndicator)
                    }
                    8->{
                        (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                            .replace(R.id.framelayout_generic_layout,
                                ConditionMakerFragment()
                            )
                            .addToBackStack("Fragment")
                            .commit()
                    }
                }
            }
        }
    }

    fun updateData(data: MutableList<ExpandedBotCardModel>){
        indicatorList = data
        notifyDataSetChanged()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card: CardView = view.cardview_bot_expanded
        val title: TextView = view.textView_title_botexp
        val body: TextView = view.textView_body_botexp
        val asset: ImageView = view.imageview_asset
    }
}

