package com.example.krakg.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.R
import com.example.krakg.adapters.BotCardAdapter
import com.example.krakg.adapters.BotExpandedCardAdapter
import com.example.krakg.models.ExpandedBotCardModel
import kotlinx.android.synthetic.main.activity_bot_expanded.*
import kotlinx.android.synthetic.main.fragment_bots.*


class BotExpandedActivity: AppCompatActivity() {
    private val myList = listOf(
        ExpandedBotCardModel("Net Change", 2.3, null, "%", false, null),
        ExpandedBotCardModel("Gross", 800.2, "$",null, true, null),
        ExpandedBotCardModel("Value", 4000.5, "$",null, false, null),
        ExpandedBotCardModel("Avg", 82.1, null, "%", true, null),
        ExpandedBotCardModel("Trades/Hr", 40.7, null, null, false, null),
        ExpandedBotCardModel("Total Trades", 10.9, null, null, true, null),
        ExpandedBotCardModel("Time Up", 100.23, null, "sec", false, null))




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bot_expanded)

        recyclerView_bots_expanded.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val adapter = BotExpandedCardAdapter(myList, this)
        recyclerView_bots_expanded.adapter = adapter


    }
}