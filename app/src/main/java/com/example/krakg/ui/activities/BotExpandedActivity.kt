package com.example.krakg.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.R
import com.example.krakg.adapters.BotCardAdapter
import com.example.krakg.adapters.BotExpandedCardAdapter
import kotlinx.android.synthetic.main.activity_bot_expanded.*
import kotlinx.android.synthetic.main.fragment_bots.*


class BotExpandedActivity: AppCompatActivity() {
    private val myList = listOf("Title One", "Title Two", "Title Three", "Title Four")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bot_expanded)

        recyclerView_bots_expanded.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val adapter = BotExpandedCardAdapter(myList, this)
        recyclerView_bots_expanded.adapter = adapter


    }
}