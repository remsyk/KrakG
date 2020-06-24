package com.example.krakg.realm

import com.example.krakg.models.BotModel
import com.example.krakg.models.BotRealmModel
import com.example.krakg.models.SpreadRealmModel
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.annotations.RealmModule


class DBManager  {

    val realmBotConfig = RealmConfiguration.Builder().name("botDb.realm")
        .schemaVersion(1)
        .deleteRealmIfMigrationNeeded() //TODO comment this out on release
        .modules(BotSchema())
        .build()

    val realmSpeadConfig = RealmConfiguration.Builder().name("spreadDb.realm")
        .schemaVersion(2)
        .modules(SpreadSchema())
        .build()

     fun addBot(bot_: BotModel, position: Int) {
         Realm.getInstance(realmBotConfig).use { r ->
            r.executeTransaction { realm ->
                realm.copyToRealmOrUpdate(BotRealmModel().apply{
                    botId = bot_.title.substring(0,4) + bot_.title.subSequence(bot_.title.length-3,bot_.title.length)
                    title = bot_.title
                    exchange = bot_.exchange
                    value = "0"
                    gross = bot_.gross
                    netChange = "0"
                    avg = "0"
                    totalTrades = "0"
                    paperTrading= true.toString()
                    conditionList ="0"

                })
            }
        }
    }

     fun delBot( botId: String?)  {
         Realm.getInstance(realmBotConfig).use() { r ->
            r.executeTransaction(Realm.Transaction { realm ->
                realm.where(BotRealmModel::class.java).equalTo("botId", botId).findAll()?.deleteAllFromRealm()
            })
        }
    }

    fun getBots(): MutableList<BotModel> {
        val botList = mutableListOf<BotModel>()
        Realm.getInstance(realmBotConfig).where(BotRealmModel::class.java).findAll().let { realmObject->
            realmObject.forEach {
                botList += BotModel(it.title!!,it.exchange,it.value,it.gross!!,it.netChange!!,it.avg!!,it.totalTrades!!,it.paperTrading!!.toBoolean(),it.conditionList!!)
            }
        }
        return botList
    }
}

@RealmModule(classes = [BotRealmModel::class])
class BotSchema{}

@RealmModule(classes = [SpreadRealmModel::class])
class SpreadSchema{}




