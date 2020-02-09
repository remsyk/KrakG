package com.example.krakg

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.anychart.AnyChartView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cardview_bot.*
import kotlinx.android.synthetic.main.cardview_bot.view.*
import kotlinx.coroutines.*
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {

    private val myList = listOf("Title One", "Title Two", "Title Three", "Title Four")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_bots.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = BotCardAdapter(myList,this )
        recyclerView_bots.adapter = adapter

        DataManager.getServerTime()

    }
}


