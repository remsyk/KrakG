package com.example.krakg.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.R
import com.example.krakg.adapters.TradeListAdapter
import com.example.krakg.models.TradeItemModel
import com.example.krakg.ui.activities.BotExpandedActivity.Companion.setActionBarAddCondition
import com.example.krakg.view_models.TradeListViewModel
import kotlinx.android.synthetic.main.fragment_bot_condition_maker.*

class TradesListFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setActionBarAddCondition(false)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_bot_condition_maker, container, false)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        setActionBarAddCondition(false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView_conditions.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = TradeListAdapter( requireActivity())
        recyclerView_conditions.adapter = adapter


        TradeListViewModel.getTrades().observe(requireActivity(), Observer <MutableList<TradeItemModel>> {
            adapter.updateData(it)
        })

    }
}