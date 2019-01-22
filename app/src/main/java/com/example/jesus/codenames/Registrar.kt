package com.example.jesus.codenames

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Registrar : AppCompatActivity() {
    lateinit var nDatabase : DatabaseReference
        val mAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        val btnr = findViewById<View>(R.id.registb) as Button

        nDatabase = FirebaseDatabase.getInstance().getReference("Names")

        btnr.setOnClickListener {
            this.register()
        }


    }

   private fun register(){
       val nameTxt = findViewById<View>(R.id.nombretxt) as EditText
       val emailTxt = findViewById<View>(R.id.correotxt2) as EditText
       val passTxt = findViewById<View>(R.id.contratxt2) as EditText
       var email = emailTxt.text.toString()
       var password = passTxt.text.toString()
       var name = nameTxt.text.toString()

        if (!name.isEmpty() && !password.isEmpty() && !email.isEmpty()){
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) { task ->
                        if (task.isSuccessful){
                            val user = mAuth.currentUser
                            val uid = user!!.uid
                            nDatabase.child(uid).child("Name").setValue(name)
                            Toast.makeText(this,"Ha sido registrado ",Toast.LENGTH_LONG).show()
                            startActivity(Intent(this, Menu::class.java))
                        }else{
                            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
                        }
                    }
        }else{
            Toast.makeText(this,"Complete los campos adecuadamente",Toast.LENGTH_LONG).show()
        }
   }
}
