package com.example.jesus.codenames

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.jesus.codenames.Retrofit.IMyService
import com.example.jesus.codenames.Retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
   lateinit var iMyService : IMyService
    internal var compositeDisposable= CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginBtn = findViewById<View>(R.id.loginb) as Button
        val regBtn =  findViewById<View>(R.id.regisb) as Button
                loginBtn.setOnClickListener {
                    loginUser(correotxt.text.toString(),contratxt.text.toString())
                }
            regBtn.setOnClickListener{
                this.registrar()
            }

        //Init API
        val retrofit = RetrofitClient.getInstance()
        iMyService = retrofit.create(IMyService::class.java)


    }

    private fun loginUser(email: String, password: String) {

        //checamos campos vacios
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this@Login,"el correo electronico no puede estar vacio",Toast.LENGTH_LONG).show()
            return
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this@Login,"la contraseña no puede estar vacia",Toast.LENGTH_LONG).show()
            return
        }
        compositeDisposable.add(iMyService.loginUser(email,password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                Toast.makeText(this@Login,""+result,Toast.LENGTH_LONG).show()
            })
    }

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }

    private fun registrar(){
      val intento = Intent(this,Registrar::class.java)
        startActivity(intento)

    }





}
