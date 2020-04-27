package com.example.krakg.models

import com.example.krakg.models.BotModel
import io.realm.RealmObject
import io.realm.annotations.Index
import io.realm.annotations.PrimaryKey

open class SpreadRealmModel : RealmObject() {
    @PrimaryKey
    var pair: String ? = null
    @Index
    var time: Int? = null
    var bid: Int? = null
    var ask: Int? = null
    var lastId: Int? = null
}


