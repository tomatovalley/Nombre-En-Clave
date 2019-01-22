package com.example.jesus.codenames

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Menu : AppCompatActivity() {
        var mAuth = FirebaseAuth.getInstance()
        lateinit var nDatabase : DatabaseReference
        var user = FirebaseAuth.getInstance().currentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val disptxt = findViewById<TextView>(R.id.nombretxt)
        var uid = user!!.uid
        nDatabase = FirebaseDatabase.getInstance().getReference("Names")

       nDatabase.child(uid).child("Name").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(snapshot: DataSnapshot) {
                disptxt.text = "Bienvenido " + snapshot.value.toString()
            }
        })
    }


}
