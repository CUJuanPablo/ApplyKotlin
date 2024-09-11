package com.zigmab.first.DB

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class StoreAplication : Application() {
    companion object{
        lateinit var database: StoreDatabase
    }

    override fun onCreate() {
        super.onCreate()

        //SE CREA LA MIGRACION Y LA SENTENCIA DENTRO DE PARA AGREGARLO AL BUILDER DE LA DBD
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                 db.execSQL( "ALTER TABLE StoreEntity ADD COLUMN photoURL TEXT NOT NULL DEFAULT '' " )
            }
        }

        //BUILDER DE LA APP
        database = Room.databaseBuilder(
            this,
            StoreDatabase::class.java,
            "StoreDatabase")
            .addMigrations( MIGRATION_1_2 )
        .build()
    }
}