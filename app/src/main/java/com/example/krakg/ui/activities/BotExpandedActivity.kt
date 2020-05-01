package com.example.krakg.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.krakg.R
import com.example.krakg.log
import com.example.krakg.models.ConditionModel
import com.example.krakg.ui.fragments.BotExpandedFragment
import com.example.krakg.view_models.ConditionMakerViewModel


class BotExpandedActivity: AppCompatActivity() {

    private var loadFragment = "botName"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.framelayout_generic)
        loadFragment = intent.getStringExtra("botName")!!

        supportActionBar!!.title = loadFragment
        supportActionBar!!.setDisplayShowTitleEnabled(true)

        supportFragmentManager.beginTransaction().replace(R.id.framelayout_generic_layout,
            BotExpandedFragment().apply {
                arguments = Bundle().apply {
                    putString("theString", "weeee")
                }
            }
        ).addToBackStack("BotExpandedFragment").commit()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater  = menuInflater
        inflater.inflate(R.menu.actionbar_menu_bot,menu)

        if (menu != null) {
            menuTest = menu
            setActionBarAddCondition(false)
        }
        return true
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount ==1){
            finish()
        }else {
            supportFragmentManager.popBackStack()
        }
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

            R.id.indicator_list_info ->{
                "pause bot".log()

            }

            R.id.add_condition->{
                ConditionMakerViewModel.addConditions(ConditionModel("Sell","if","daily","avg","40%","greater than","monthly","avg","$300.00"))
            }
        }
        return true
    }

    companion object {
        lateinit var menuTest: Menu

        fun setActionBarAddCondition(visibility: Boolean) {
            menuTest.findItem(R.id.add_condition).isVisible = visibility
            menuTest.findItem(R.id.indicator_list_info).isVisible = visibility

        }
    }
}