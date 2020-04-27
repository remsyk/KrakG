package com.example.krakg.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.krakg.R
import com.example.krakg.models.BotModel
import com.example.krakg.services.UpdateService
import com.example.krakg.ui.fragments.dialogs.ProgressDialog
import com.example.krakg.view_models.BotsViewModel
import com.example.krakg.view_models.DashboardViewModel
import kotlinx.android.synthetic.main.viewgroup_actionbar_bots.*


//TODO figure out how to send out updates for apps not in app store

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        startService(UpdateService.newIntent(this))

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar!!.setCustomView(R.layout.viewgroup_actionbar_bots_2)


        navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_bots,
                R.id.navigation_dashboard,
                R.id.navigation_settings
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val finalHose = NavHostFragment.create(R.navigation.mobile_navigation)

        if (savedInstanceState != null) {
            navController.navigate(savedInstanceState.getInt("currentFragment"))
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            resetAddBotOnClick()

        return super.onCreateOptionsMenu(menu)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("currentFragment", navController.currentDestination!!.id)
    }



    fun resetAddBotOnClick(){
        design_menu_item_add.setOnClickListener {
            val progressBar = ProgressDialog.show(supportFragmentManager)
            BotsViewModel.getApiBotName {
                Toast.makeText(this, "Bot Added", Toast.LENGTH_SHORT).show()
                BotsViewModel.addBot(BotModel(it, 1.3, "BTC>USD", "$51.54", "+1.3%", null))
                progressBar.dismiss()
            }
        }
    }


}
