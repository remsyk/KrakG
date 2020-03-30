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
class TestService : IntentService("TestService") {

    private val TAG = "TestService"
    val handler = Handler()
    val runnableCode = object : Runnable {
        override fun run() {
           /* DashboardViewModel.retrofitInterface.getServerTime()
            handler.postDelayed(this, 5000)*/
        }
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    override fun onHandleIntent(intent: Intent?) {
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 5 seconds.
        try {
            handler.post(runnableCode)
        } catch (e: InterruptedException) {
            // Restore interrupt status.mm
            Thread.currentThread().interrupt()
        }
    }



    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, TestService::class.java)
        }

    }
}

