package com.zigmab.first

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.zigmab.first.databinding.ActivityServersBinding

class ServersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityServersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityServersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()


    }
    fun init() {

        findViewById<FloatingActionButton>(R.id.btnAdd).setOnClickListener {
            
        }

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

}