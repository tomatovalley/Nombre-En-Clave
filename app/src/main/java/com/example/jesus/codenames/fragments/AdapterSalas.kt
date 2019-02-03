package com.example.jesus.codenames.fragments

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.jesus.codenames.R

class AdapterSalas(var list: ArrayList<Salas>): RecyclerView.Adapter<AdapterSalas.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.content_item,parent,false)
        return ViewHolder(v)
    }



    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }


    class ViewHolder(view:View): RecyclerView.ViewHolder(view){

            fun bindItem(data:Salas){
                val titulo:TextView = itemView.findViewById(R.id.txttitle)
                titulo.text= data.titulo

                itemView.setOnClickListener(){
                    Toast.makeText(itemView.context,"Sala de ${data.titulo}",Toast.LENGTH_LONG).show()
                }
            }
        }
}