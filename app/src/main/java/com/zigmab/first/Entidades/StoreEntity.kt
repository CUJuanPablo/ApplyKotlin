package com.zigmab.first.Entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "StoreEntity" )

data class StoreEntity(
    @PrimaryKey(autoGenerate = true)
        var ID: Long = 0,
    var NAME: String= "" ,
    var PHONE: String= "" ,
    var WEB: String = "",
    var IS_FAVORITE: Boolean = false,
    var IMG: String= "",
    var photoURL: String= ""
)