package com.example.jesus.codenames

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)




        btonplay.setOnClickListener {
            val intent = Intent(this, Play::class.java)
            startActivity(intent)
        }

    }
}



