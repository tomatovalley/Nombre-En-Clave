package com.example.jesus.codenames

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {
        var mAuth = FirebaseAuth.getInstance()
        lateinit var nDatabase : DatabaseReference
        var user = FirebaseAuth.getInstance().currentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        var uid = user!!.uid
        nDatabase = FirebaseDatabase.getInstance().getReference("Names")

        nDatabase.child(uid).child("Name").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(String::class.java).toString()
                Log.d("nombre",value)
                Toast.makeText(this@Menu,"Welcome $value",Toast.LENGTH_LONG).show()

            }
            override fun onCancelled(p0: DatabaseError) {
                Log.d("valiovrga","si")
            }
        })

        btonplay.setOnClickListener{
           val intent = Intent(this, Play::class.java)
            startActivity(intent)
        }

    }


}
