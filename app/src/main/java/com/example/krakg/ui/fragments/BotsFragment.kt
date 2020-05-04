package com.example.krakg.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.adapters.BotCardAdapter
import com.example.krakg.R
import com.example.krakg.models.BotModel
import com.example.krakg.ui.activities.MainActivity.Companion.setMainMenuVisibility
import com.example.krakg.view_models.BotsViewModel
import kotlinx.android.synthetic.main.fragment_bots.*

class BotsFragment : Fragment() {


    override fun onResume() {
           setMainMenuVisibility(R.drawable.ic_add_24px)
       super.onResume()
    }

    override fun onPause() {
        setMainMenuVisibility(R.drawable.ic_add_24px_transparent)
        super.onPause()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_bots, container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView_bots.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = BotCardAdapter(requireActivity())
        recyclerView_bots.adapter = adapter

        (activity as AppCompatActivity).supportActionBar!!.setCustomView(R.layout.viewgroup_actionbar_bots)

        BotsViewModel.getBots().observe(requireActivity(),Observer <MutableList<BotModel>> {
            adapter.updateData(it)
        })
    }
}