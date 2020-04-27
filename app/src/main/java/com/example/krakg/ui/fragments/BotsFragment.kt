package com.example.krakg.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.adapters.BotCardAdapter
import com.example.krakg.R
import com.example.krakg.models.BotModel
import com.example.krakg.ui.activities.MainActivity
import com.example.krakg.ui.fragments.dialogs.ProgressDialog
import com.example.krakg.view_models.BotsViewModel
import kotlinx.android.synthetic.main.fragment_bots.*
import kotlinx.android.synthetic.main.viewgroup_actionbar_bots.*

class BotsFragment : Fragment() {

    override fun onResume() {
        super.onResume()
        //(activity as AppCompatActivity).supportActionBar!!.setCustomView(R.layout.viewgroup_actionbar_bots)
        //(activity as MainActivity).resetAddBotOnClick()

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_bots, container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView_bots.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = BotCardAdapter(activity!!)
        recyclerView_bots.adapter = adapter

        BotsViewModel.getBots().observe(activity!!,Observer <MutableList<BotModel>> {
            adapter.updateData(it)
        })
    }
}