package com.example.krakg.ui.fragments.bots_expanded

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.R
import com.example.krakg.adapters.BotExpandedCardAdapter
import com.example.krakg.models.ExpandedBotCardModel
import com.example.krakg.ui.activities.BotExpandedActivity
import kotlinx.android.synthetic.main.fragment_bot_expanded.*

class BotExpandedFragment: Fragment() {
    private val myList = listOf(
        ExpandedBotCardModel("Net Change", 2.3, null, "%", false, null),
        ExpandedBotCardModel("Gross", 800.2, "$",null, true, null),
        ExpandedBotCardModel("Value", 4000.5, "$",null, false, null),
        ExpandedBotCardModel("Avg", 82.1, null, "%", true, null),
        ExpandedBotCardModel("Trades/Hr", 40.7, null, null, false, null),
        ExpandedBotCardModel("Total Trades", 10.9, null, null, true, null),
        ExpandedBotCardModel("Time Up", 100.23, null, "sec", false, null)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_bot_expanded, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView_bots_expanded.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val adapter = BotExpandedCardAdapter(myList, activity!!)
        recyclerView_bots_expanded.adapter = adapter
    }
}