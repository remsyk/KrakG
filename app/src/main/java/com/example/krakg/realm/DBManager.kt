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
                    botId = bot_.title.substring(0,4)
                    title = bot_.title
                    graph =bot_.graph
                    exchange = bot_.exchange
                    gross = bot_.gross

                     value = "$123"
                    prefix = "werwer"
                    suffix = "werwer"
                    hasasset = true
                    asset = "werwer"

                   /* value = bot_.value.toString()
                    prefix = bot_.expandedBot!!.prefix
                    suffix = bot_.expandedBot!!.suffix
                    hasasset = bot_.expandedBot!!.hasasset
                    asset = bot_.expandedBot!!.asset.toString()*/
                })
            }
        }
    }

     fun delBot( bot: BotRealmModel?)  {
         Realm.getInstance(realmBotConfig).use() { r ->
            r.executeTransaction(Realm.Transaction { realm ->
                realm.where(BotRealmModel::class.java).equalTo("seed", bot!!.botId).findAll()?.deleteAllFromRealm()
            })
        }
    }

    fun getBots(): MutableList<BotModel> {
        val botList = mutableListOf<BotModel>()

        Realm.getInstance(realmBotConfig).where(BotRealmModel::class.java).findAll().let { realmObject->
            realmObject.forEach {
                botList += BotModel(it.title!!,it.graph!!,it.exchange,it.value,it.gross!!,null)
            }
        }
        return botList
    }
}

@RealmModule(classes = [BotRealmModel::class])
class BotSchema{}

@RealmModule(classes = [SpreadRealmModel::class])
class SpreadSchema{}




