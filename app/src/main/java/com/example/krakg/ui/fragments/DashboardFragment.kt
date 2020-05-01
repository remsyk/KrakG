package com.example.krakg.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.krakg.R
import com.example.krakg.adapters.DashboardCardAdapter
import com.example.krakg.view_models.DashboardViewModel
import androidx.lifecycle.Observer
import com.example.krakg.ui.activities.MainActivity
import com.example.krakg.ui.activities.MainActivity.Companion.setMainMenuVisibility
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView_dashboard.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = DashboardCardAdapter(activity!!)
        recyclerView_dashboard.adapter = adapter

        DashboardViewModel.getTicker().observe(activity!!, Observer {
            adapter.updateData(it)
        })

    }

}