package com.example.krakg.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.R
import com.example.krakg.adapters.BotExpandedCardAdapter
import kotlinx.android.synthetic.main.fragment_bot_expanded.*
import androidx.lifecycle.Observer
import com.example.krakg.view_models.BotsViewModel
import kotlin.properties.Delegates


class BotExpandedFragment: Fragment() {

    private var botPosition by Delegates.notNull<Int>()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getInt("botPosition")?.let {
            botPosition = it
        }
    }


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
        val adapter = BotExpandedCardAdapter( requireActivity())
        recyclerView_bots_expanded.adapter = adapter

        BotsViewModel.getBots().observe(requireActivity(), Observer {
            adapter.updateData(it[botPosition])
        })


    }
}