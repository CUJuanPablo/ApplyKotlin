  package com.zigmab.first

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zigmab.first.Entidades.User
import kotlin.math.abs

  class MainActivity : AppCompatActivity() {



      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Init()



    }

    fun Init(){
      var person = User()

      person.apply {
        Nombre = "Sergio"
        ID = 4
      }

      println( person )

      val userMap = mutableMapOf<Int, User>()

      userMap.put(person.ID , person)
      userMap.put(person.ID , person)

      userMap.remove( person.ID )

      val ishere: Boolean = userMap.containsValue( person )
      if(ishere){
        println( userMap )
      }


    }



}