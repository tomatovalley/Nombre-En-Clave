package com.example.jesus.codenames

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    var mAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtn = findViewById<View>(R.id.loginb) as Button
        val regBtn =  findViewById<View>(R.id.regisb) as Button
                loginBtn.setOnClickListener {
                    this.login()
                }
            regBtn.setOnClickListener{
                this.registrar()
            }
    }

    private fun login(){
        val emailTxt = findViewById<View>(R.id.correotxt) as EditText
        val passTxt = findViewById<View>(R.id.contratxt) as EditText
        var email = emailTxt.text.toString()
        var password = passTxt.text.toString()

            if(!email.isEmpty() && !password.isEmpty()){
                   mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this) { task ->
                       if(task.isSuccessful){
                           startActivity(Intent(this,Menu::class.java))

                           Toast.makeText(this,"Ha iniciado sesión",Toast.LENGTH_LONG).show()
                       }else{
                           Toast.makeText(this, "Error Al iniciar sesión",Toast.LENGTH_LONG).show()
                       }
                   }
            }else {
                Toast.makeText(this,"Complete los campos",Toast.LENGTH_LONG).show()
            }

    }
    private fun registrar(){
        this.startActivity(Intent(this,Registrar::class.java))
    }


}
