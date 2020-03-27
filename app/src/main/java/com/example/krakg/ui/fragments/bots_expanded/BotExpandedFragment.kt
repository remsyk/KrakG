package com.example.krakg.ui.fragments.bots_expanded

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.R
import com.example.krakg.adapters.BotExpandedCardAdapter
import com.example.krakg.models.ConditionModel
import com.example.krakg.models.ExpandedBotCardModel
import kotlinx.android.synthetic.main.fragment_bot_expanded.*
import androidx.lifecycle.Observer


class BotExpandedFragment: Fragment() {

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
        val adapter = BotExpandedCardAdapter( activity!!)
        recyclerView_bots_expanded.adapter = adapter

        ExpandedBotViewModel.getInidcators().observe(activity!!, Observer <MutableList<ExpandedBotCardModel>> {
            adapter.updateData(it)
        })


    }
}