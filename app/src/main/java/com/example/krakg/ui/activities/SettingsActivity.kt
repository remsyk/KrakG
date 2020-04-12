package com.example.krakg.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.krakg.R
import com.example.krakg.log
import com.example.krakg.models.ConditionModel
import com.example.krakg.ui.fragments.*
import com.example.krakg.view_models.ConditionMakerViewModel


class SettingsActivity: AppCompatActivity() {

    private var loadFragment = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.framelayout_generic)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
        loadFragment = intent.getIntExtra("loadFragment",0)

        when(loadFragment){
            1-> {
                supportFragmentManager.beginTransaction().replace(R.id.framelayout_generic_layout,
                    NotificationsFragment()
                ).addToBackStack("NotificationsFragment").commit()
                supportActionBar!!.title = "Notifications"

            }
            2-> {
                supportFragmentManager.beginTransaction().replace(R.id.framelayout_generic_layout,
                    InportExportFragment()
                ).addToBackStack("InportExportFragment").commit()
                supportActionBar!!.title = "Imports/Exports"
            }
            3-> {
                supportFragmentManager.beginTransaction().replace(R.id.framelayout_generic_layout,
                    TransferFundsFragment()
                ).addToBackStack("TransferFundsFragment").commit()
                supportActionBar!!.title = "Transfer Funds"

            }
            4-> {
                supportFragmentManager.beginTransaction().replace(R.id.framelayout_generic_layout,
                    ControlPanelFragment()
                ).addToBackStack("ControlPanelFragment").commit()
                supportActionBar!!.title = "Control Panel"

            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount ==1){
            finish()
        }else {
            supportFragmentManager.popBackStack()
        }
    }

}