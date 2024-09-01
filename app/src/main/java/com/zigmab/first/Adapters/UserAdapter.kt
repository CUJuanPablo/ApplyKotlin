package com.zigmab.first.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zigmab.first.Entidades.User
import com.zigmab.first.Intefaces.OnClickListener
import com.zigmab.first.R
import com.zigmab.first.databinding.ItemUserBinding

class UserAdapter (     private val users: MutableList<User>, private val listener: OnClickListener ) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemUserBinding.bind( view )

        fun setListener(user:User){
            binding.root.setOnClickListener { listener.OnClick( user )  }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users.get(position)

        with( holder ){
            setListener( user )
            binding.Id.text = user.ID.toString()
            binding.Name.text = user.Nombre
        }
    }

    override fun getItemCount(): Int = users.size

    fun remove( position : Int) {
        users.removeAt( position )
        notifyItemRemoved( position )
    }
}