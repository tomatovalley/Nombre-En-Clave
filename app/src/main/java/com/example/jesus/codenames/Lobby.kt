package com.example.jesus.codenames

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.beust.klaxon.Klaxon
import com.example.jesus.codenames.Retrofit.IMyService
import com.example.jesus.codenames.Retrofit.RetrofitClient
import com.example.jesus.codenames.fragments.Salas
import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_lobby.*
import java.io.StringReader

lateinit var iMyService : IMyService
internal var compositeDisposable= CompositeDisposable()
class Lobby : AppCompatActivity() {
    val URL_SOCKET = "http://192.168.0.6:8080"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby)
        //por mientras
        btnsalir.setOnClickListener{
            obtenerdatos()
        }
        //RecyclerView

      /*  val salas = ArrayList<Salas>()
        salas.add(Salas("PAnchon sala"))
        salas.add(Salas("Jesus sala"))
        salas.add(Salas("KAKAS sala"))
        salas.add(Salas("IVAN sala"))
        salas.add(Salas("PAnchon sala"))
        salas.add(Salas("Jesus sala"))
        salas.add(Salas("KAKAS sala"))
        salas.add(Salas("IVAN sala"))*/



        btncrearsala.setOnClickListener {
            mostrardialogo()
        }
        val retrofit = RetrofitClient.getInstance()
        iMyService = retrofit.create(IMyService::class.java)


        //nomas




    }
    fun connectar() {
        val socket = IO.socket(URL_SOCKET)
        socket.connect()
            .on(Socket.EVENT_CONNECT, { Log.d("uwu","se ha conectado") })
            .on(Socket.EVENT_DISCONNECT, { Log.d("uwu","no se pudo conectar")})
    }
    fun mostrardialogo(){
        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.modal_crearsala,null)
        val saltatxt = dialogView.findViewById<EditText>(R.id.salatxt)
        dialog.setView(dialogView)
        dialog.setCancelable(true)
        dialog.setPositiveButton("crear",{ dialogInterface: DialogInterface, i: Int -> })
        val customDialog = dialog.create()
        customDialog.show()
        customDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            val sala = saltatxt.text.toString()
                if (TextUtils.isEmpty(sala)){
                    Toast.makeText(this,"complete el campo", Toast.LENGTH_LONG).show()
                }else {
                  compositeDisposable.add(iMyService.CreateSala(sala).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe{result ->
                            Toast.makeText(this,""+result,Toast.LENGTH_LONG).show()
                            customDialog.dismiss()

                        })

                }
            }
            val retrofit = RetrofitClient.getInstance()
            iMyService = retrofit.create(IMyService::class.java)
        }
    fun obtenerdatos(){
        compositeDisposable.add(iMyService.obtenersala("uwu").subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{result ->
                Toast.makeText(this,""+result,Toast.LENGTH_LONG).show()
                    val Klaxon = Klaxon()
                    val parsed = Klaxon.parseJsonObject(StringReader(result))
                    val dataArray = parsed.array<Salas>("result")
                    val salas = dataArray?.let { Klaxon.parseFromJsonArray<Salas>(it) }
             /*   val salasarray = arrayOfNulls<String>(salas!!.size)
                val recyclerView:RecyclerView=findViewById(R.id.recycler_view)
                recyclerView.layoutManager=LinearLayoutManager(this,LinearLayout.VERTICAL,false)
                val adapter = AdapterSalas(salasarray)
                recyclerView.adapter=adapter
                connectar()*/
                println(salas)
            })
    }
    }


