package com.zigmab.first.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zigmab.first.Entidades.StoreEntity
import com.zigmab.first.Intefaces.StoreDAO

@Database(entities = arrayOf(StoreEntity::class), version = 1)
abstract class StoreDatabase : RoomDatabase() {

    abstract fun storeDao():StoreDAO
}