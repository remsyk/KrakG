package com.example.krakg.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.R
import com.example.krakg.adapters.DashboardCardAdapter
import com.example.krakg.log
import com.example.krakg.view_models.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*
import androidx.lifecycle.Observer
import com.example.krakg.services.TestService


class DashboardFragment : Fragment() {

    private val myList = listOf("Title One", "Title Two", "Title Three", "Title Four")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.setCustomView(R.layout.viewgroup_actionbar_dashboard)

        DashboardViewModel.getBotName {
            it.log()
        }

    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.setCustomView(R.layout.viewgroup_actionbar_dashboard)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView_dashboard.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = DashboardCardAdapter(myList, activity!!)
        recyclerView_dashboard.adapter = adapter

    }
}