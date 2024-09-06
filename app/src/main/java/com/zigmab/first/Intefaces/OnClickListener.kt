package com.zigmab.first.Intefaces

import com.zigmab.first.Entidades.StoreEntity
import com.zigmab.first.Entidades.User

interface OnClickListener {

    fun OnClick(user : User)

    fun OnClickTienda(store : StoreEntity)

    fun OnFavoriteStore( store: StoreEntity)

    fun OnDeleteStore( store: StoreEntity )

}