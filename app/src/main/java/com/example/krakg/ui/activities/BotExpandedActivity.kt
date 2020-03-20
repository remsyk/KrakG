package com.example.krakg.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.krakg.R
import com.example.krakg.log
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

        if (menu != null) {
            menuTest = menu
            setActionBarMenuOptions(true)
        }
        return true
    }

    override fun onOptionsItemSelected(item:MenuItem): Boolean {
        when(item.itemId){

            android.R.id.home ->{
                if(supportFragmentManager.backStackEntryCount ==1){
                    finish()
                }else {
                    supportFragmentManager.popBackStack()
                }
            }

            R.id.pause_bot ->{
                "pause bot".log()
            }

            R.id.add_condition->{
                "add condition".log()
            }
        }
        return true
    }

    companion object {
        lateinit var menuTest: Menu

        fun setActionBarMenuOptions(visibility: Boolean) {
            menuTest.findItem(R.id.pause_bot).isVisible = visibility
            menuTest.findItem(R.id.add_condition).isVisible = !visibility
        }
    }
}