package com.example.krakg.realm

import android.app.Application
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration


//calls realm application from Android Manifest
class RealmApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //initializes realm database
        Realm.init(this)
        //sets up realm database with standard configurations
        Realm.setDefaultConfiguration(RealmConfiguration.Builder().build())
        Log.i("Realm", "Database Created")
    }
}