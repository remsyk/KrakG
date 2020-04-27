package com.example.krakg.realm

import android.app.Application
import android.util.Log
import com.example.krakg.models.BotRealmModel
import com.example.krakg.models.SpreadRealmModel
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.annotations.RealmModule


//calls realm application from Android Manifest
class KrakG : Application() {
    override fun onCreate() {
        super.onCreate()
        //initializes realm database
        Realm.init(this)
    }
}

