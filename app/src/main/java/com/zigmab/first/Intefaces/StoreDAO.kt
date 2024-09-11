package com.zigmab.first.Intefaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.zigmab.first.Entidades.StoreEntity

@Dao
interface StoreDAO {

    @Query("SELECT * FROM StoreEntity ")
    fun GetAllStores():MutableList<StoreEntity>

    @Insert
    fun AddStore(store: StoreEntity)

    @Update
    fun UpdateStore(store: StoreEntity)

    @Delete
    fun Delete(store: StoreEntity)

    @Query(" SELECT * FROM StoreEntity WHERE id = :id")
    fun getStoreById( id : Long):StoreEntity

}