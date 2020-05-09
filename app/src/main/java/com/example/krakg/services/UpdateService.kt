package com.example.krakg.services

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.os.Handler
import com.example.krakg.view_models.DashboardViewModel

/**
 * A constructor is required, and must call the super [android.app.IntentService.IntentService]
 * constructor with a name for the worker thread.
 */

//TODO make the app run in the background while app is clsoed
class UpdateService : IntentService("TestService") {

    private val TAG = "TestService"
    val handler = Handler()
    private val runnableCode = object : Runnable {
        override fun run() {
            DashboardViewModel.getApiTicker("XXBTZUSD,XLTCZUSD,XLTCXXBT")
            handler.postDelayed(this, 30000)
        }
    }


    override fun onHandleIntent(intent: Intent?) {
        try {
            handler.post(runnableCode)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, UpdateService::class.java)
        }
    }
}

