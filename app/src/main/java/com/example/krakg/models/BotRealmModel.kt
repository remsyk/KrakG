package com.example.krakg.models

import com.example.krakg.models.BotModel
import io.realm.RealmObject
import io.realm.annotations.Index
import io.realm.annotations.PrimaryKey

open class BotRealmModel : RealmObject() {
    @PrimaryKey
    var botId: String ? = null
    @Index
    var title: String? = null
    var exchange: String? = null
    var value: String? = null
    var gross: String? = null
    var netChange: String? = null
    var avg: String? = null
    var totalTrades: String? = null
    var paperTrading: String? = null
    var conditionList: String? = null
}


