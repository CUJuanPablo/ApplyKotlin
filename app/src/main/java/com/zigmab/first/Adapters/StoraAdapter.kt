package com.zigmab.first.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zigmab.first.Entidades.StoreEntity
import com.zigmab.first.Intefaces.OnClickListener
import com.zigmab.first.R
import com.zigmab.first.databinding.ItemServerBinding

class StoraAdapter(
    private  var stores: MutableList<StoreEntity>,
    private var listener: OnClickListener
):RecyclerView.Adapter<StoraAdapter.ViewHolder>() {

    private lateinit var context: Context


    inner class ViewHolder( view: View):RecyclerView.ViewHolder(view){
        val binding = ItemServerBinding.bind( view )

        fun setListener( store : StoreEntity ){
            binding.root.setOnClickListener { listener.OnClickTienda( store )}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view = LayoutInflater.from( context ).inflate( R.layout.item_server , parent, false)
        return ViewHolder( view )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store = stores.get( position )

        with( holder ){
            binding.lblName.text = store.NAME
            setListener( store )
        }

    }

    override fun getItemCount(): Int = stores.size

    fun add(store: StoreEntity) {
        stores.add( store )
        notifyDataSetChanged()
    }

    fun setStores(stores: MutableList<StoreEntity>) {
        this.stores = stores
        notifyDataSetChanged()
    }
}