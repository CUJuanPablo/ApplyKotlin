package com.zigmab.first.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zigmab.first.Entidades.StoreEntity
import com.zigmab.first.Intefaces.StoreDAO

//PATRON SINGLETON
//Aqui se cambia la version de la bd de la aplicacion
@Database(entities = arrayOf(StoreEntity::class), version = 2)
abstract class StoreDatabase : RoomDatabase() {

    abstract fun storeDao():StoreDAO
}