package com.zigmab.first

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.zigmab.first.Adapters.UserAdapter
import com.zigmab.first.Entidades.User
import com.zigmab.first.databinding.ActivityServersBinding

class ServersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityServersBinding
    private lateinit var context: Context

    private lateinit var btnRed: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityServersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()


    }

    private fun init() {

        context = this

        ContentScrollingClass()


        ShowUsers()


            
    }
    private fun ShowUsers() {

        var userAdapter: UserAdapter
        var linearLayoutManager: RecyclerView.LayoutManager

        userAdapter = UserAdapter( GetUsers() )
        linearLayoutManager =LinearLayoutManager(context)

        GetUsers()


        binding.userscontent.recycler.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    private fun GetUsers(): MutableList<User> {
         val users = mutableListOf<User>()

        val me = User().apply {
            ID = 1
            Nombre = "Juan Pablo"
        }
        val you = User().apply {
            ID = 2
            Nombre = "Samantha"
        }

        users.add(me)
        users.add(you)

        return users
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        menuInflater.inflate(R.menu.menu_servers, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when( item.itemId){
            R.id.action_settings -> true
            else ->  super.onOptionsItemSelected(item)
        }
    }

    private fun ContentScrollingClass() {
        btnRed = binding.btnAdd

        btnRed.setOnClickListener{

        }

        binding.bottomAppBar.setNavigationOnClickListener {
            Snackbar.make(binding.root, "Click", Snackbar.LENGTH_SHORT)
                .setAnchorView(binding.btnAdd)
                .show()
        }

        binding.content.btnRed?.setOnClickListener {
            Snackbar.make(binding.root, "Red", Snackbar.LENGTH_SHORT)
                .setAnchorView(binding.btnAdd)
                .setAction("Descomprar") {
                    Toast.makeText(this, "Descomprado", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        binding.content.btnGroup!!.addOnButtonCheckedListener { _, checkedId, _ ->
            binding.content.root.setBackgroundColor(
                when( checkedId ){
                    R.id.btnBlue -> Color.BLUE
                    R.id.btnRed -> Color.RED
                    else -> Color.GREEN
                }
            )
        }


        binding.content.txtUrl!!.onFocusChangeListener = View.OnFocusChangeListener { _ , _ ->
            Glide
                .with( context )
                .load("https://www.educaciontrespuntocero.com/wp-content/uploads/2020/04/mejores-bancos-de-imagenes-gratis.jpg")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.content.imgCard!!)
        }

        binding.content.sw!!.setOnCheckedChangeListener { _, ischeck ->
            if( ischeck ){

            }
        }

        binding.content.slider!!.addOnChangeListener{slider,value,from->

        }
    }
}