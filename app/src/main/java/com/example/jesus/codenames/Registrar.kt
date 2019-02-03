package com.example.jesus.codenames

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
import kotlinx.android.synthetic.main.activity_registrar.*

class Registrar : AppCompatActivity() {
    lateinit var iMyService : IMyService
    internal var compositeDisposable= CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        val btnr = findViewById<View>(R.id.registb) as Button



        btnr.setOnClickListener {
            this.register(nombretxt.text.toString(),correotxt2.text.toString(),contratxt2.text.toString())
        }

        val retrofit = RetrofitClient.getInstance()
        iMyService = retrofit.create(IMyService::class.java)
    }

   private fun register(name:String,email:String,password:String) {
       //checamos campos vacios
       if(TextUtils.isEmpty(email)){
           Toast.makeText(this@Registrar,"el correo electronico no puede estar vacio", Toast.LENGTH_LONG).show()
           return
       }
       if(TextUtils.isEmpty(password)){
           Toast.makeText(this@Registrar,"la contraseña no puede estar vacia", Toast.LENGTH_LONG).show()
           return
       }
       if(TextUtils.isEmpty(name)){
           Toast.makeText(this@Registrar,"el nombre no puede estar vacip", Toast.LENGTH_LONG).show()
           return
       }


       compositeDisposable.add(iMyService.registerUser(email,name,password)
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe { result ->
               Toast.makeText(this@Registrar,""+result, Toast.LENGTH_LONG).show()
           })

   }
}
