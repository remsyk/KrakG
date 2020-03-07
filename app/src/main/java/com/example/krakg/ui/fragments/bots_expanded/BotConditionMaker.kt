package com.example.krakg.ui.fragments.bots_expanded

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.R
import com.example.krakg.adapters.ConditionAdapter
import kotlinx.android.synthetic.main.fragment_bot_condition_maker.*

class BotConditionMaker:Fragment() {
    private val myList = listOf("Title One", "Title Two", "Title Three", "Title Four")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_bot_condition_maker, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView_conditions.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = ConditionAdapter(myList, activity!!)
        recyclerView_conditions.adapter = adapter
    }
}