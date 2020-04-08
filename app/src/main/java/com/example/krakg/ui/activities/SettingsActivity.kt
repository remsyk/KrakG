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
import com.example.krakg.ui.fragments.TransferFundsFragment
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
                    TransferFundsFragment()
                ).addToBackStack("TransferFundsFragment").commit()
                supportActionBar!!.title = "Notifications"

            }
            2-> {
                supportFragmentManager.beginTransaction().replace(R.id.framelayout_generic_layout,
                    TransferFundsFragment()
                ).addToBackStack("TransferFundsFragment").commit()
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
                    TransferFundsFragment()
                ).addToBackStack("TransferFundsFragment").commit()
                supportActionBar!!.title = "Control Panel"

            }
        }
    }
}