package com.example.krakg.ui.activities

import android.os.Bundle
import android.view.*
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
import com.example.krakg.ui.fragments.dialogs.IndicatorGuideDialog
import com.example.krakg.ui.fragments.dialogs.ProgressDialog
import com.example.krakg.view_models.BotsViewModel


//TODO figure out how to send out updates for apps not in app store
//TODO set up error handling

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        startService(UpdateService.newIntent(this))

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar!!.setCustomView(R.layout.viewgroup_actionbar_bots)

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
        val inflater: MenuInflater  = menuInflater
        inflater.inflate(R.menu.actionbar_menu_add_bot,menu)
        mainMenu = menu!!
        return true
    }



    override fun onOptionsItemSelected(item:MenuItem): Boolean {
        when(item.itemId){
            R.id.add_condition->{
                val progressBar = ProgressDialog.show(supportFragmentManager)
                BotsViewModel.getApiBotName {
                    Toast.makeText(this, "Bot Added", Toast.LENGTH_SHORT).show()
                    BotsViewModel.addBot(BotModel(it, 1.3, "BTC>USD", "51.54", "1.3","111","222","333","444",true,"666","777"))
                    progressBar.dismiss()
                }
            }
        }
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("currentFragment", navController.currentDestination!!.id)
    }

companion object{
    lateinit var mainMenu:Menu

    fun setMainMenuVisibility(icon: Int){
        if(::mainMenu.isInitialized) {
            when(icon){

                R.drawable.ic_add_24px->{
                    mainMenu.findItem(R.id.add_condition).isEnabled = true
                    mainMenu.findItem(R.id.add_condition).setIcon(R.drawable.ic_add_24px)
                }

                R.drawable.ic_add_24px_transparent->{
                    mainMenu.findItem(R.id.add_condition).isEnabled = false
                    mainMenu.findItem(R.id.add_condition).setIcon(R.drawable.ic_add_24px_transparent)
                }
            }
        }
    }


}


}
