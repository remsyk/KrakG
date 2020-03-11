package com.example.krakg.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.krakg.R
import kotlinx.android.synthetic.main.cardview_condition.view.*

class ConditionAdapter(private val data: List<String>, private val context: Context): RecyclerView.Adapter<ConditionAdapter.ViewHolder>() {

    private val buySellList = listOf("Title One", "Title Two", "Title Three", "Title Four")


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

        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }
}

