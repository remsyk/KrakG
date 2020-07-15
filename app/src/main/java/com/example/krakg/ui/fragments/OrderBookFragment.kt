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
import com.example.krakg.ui.activities.MainActivity.Companion.setMainMenuVisibility
import com.example.krakg.ui.activities.MainActivity.Companion.setMainMenuVisibility2
import com.example.krakg.view_models.TradeListViewModel
import kotlinx.android.synthetic.main.fragment_bot_condition_maker.*
import kotlinx.android.synthetic.main.fragment_order_book.*


//TODO sync the order book with those in the database
class OrderBookFragment : Fragment() {


    override fun onResume() {
        setMainMenuVisibility2(add = false, search = true)
        super.onResume()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_order_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView_trades.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = TradeListAdapter( requireActivity())
        recyclerView_trades.adapter = adapter

        TradeListViewModel.getFilteredList().observe(requireActivity(), Observer <MutableList<TradeItemModel>> {
            adapter.updateData(it)
        })

        TradeListViewModel.getTrades().observe(requireActivity(), Observer  {
            adapter.updateData(it)
        })
    }
}