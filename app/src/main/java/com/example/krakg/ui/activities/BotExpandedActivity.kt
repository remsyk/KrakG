package com.example.krakg.ui.activities

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.krakg.R
import com.example.krakg.models.ExpandedBotCardModel
import com.example.krakg.ui.fragments.bots_expanded.BotExpandedFragment


class BotExpandedActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.framelayout_generic)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        supportFragmentManager.beginTransaction().replace(R.id.framelayout_generic_layout,
            BotExpandedFragment()
        ).addToBackStack("BotExpandedFragment").commit()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
      val inflater: MenuInflater  = menuInflater
        inflater.inflate(R.menu.actionbar_menu_bot,menu)
        return true
    }
}