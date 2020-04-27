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
    var graph: Double? = null
    var exchange: String? = null
    var gross: String? = null
    var value: String? = null
    var prefix: String? = null
    var suffix: String? = null
    var hasasset: Boolean? = null
    var asset: String? = null

}


