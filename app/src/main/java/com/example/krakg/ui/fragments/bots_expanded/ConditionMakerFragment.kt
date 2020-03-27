package com.example.krakg.ui.fragments.bots_expanded

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.R
import com.example.krakg.adapters.ConditionAdapter
import com.example.krakg.models.ConditionModel
import com.example.krakg.ui.activities.BotExpandedActivity.Companion.setActionBarMenuOptions
import kotlinx.android.synthetic.main.fragment_bot_condition_maker.*

class ConditionMakerFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setActionBarMenuOptions(false)
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
        setActionBarMenuOptions(true)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView_conditions.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = ConditionAdapter( activity!!)
        recyclerView_conditions.adapter = adapter

        ConditionMakerViewModel.getConditions().observe(activity!!, Observer <MutableList<ConditionModel>> {
            adapter.updateData(it)
        })


    }
}