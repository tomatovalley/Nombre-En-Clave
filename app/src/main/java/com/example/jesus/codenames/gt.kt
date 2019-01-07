package com.example.jesus.codenames

class gt{

}

fun generartab():ArrayList<Int>{
    var altr = (Math.random() *2).toInt()
    var tabla = ArrayList<Int>()
    when(altr){
        0->  tabla = generarRojo()
        1->  tabla = generarAzul()
    }
    return tabla
}

private fun generarRojo():ArrayList<Int>{
    val tablita = ArrayList<Int>()
    tablita +=0
    tablita +=0
    tablita +=0
    tablita +=0
    tablita +=0
    tablita +=0
    tablita +=0
    tablita +=0
    tablita +=0
    tablita +=1
    tablita +=1
    tablita +=1
    tablita +=1
    tablita +=1
    tablita +=1
    tablita +=1
    tablita +=1
    tablita +=2
    tablita +=2
    tablita +=2
    tablita +=2
    tablita +=2
    tablita +=2
    tablita +=2
    tablita +=3




    return  tablita
}

private fun generarAzul():ArrayList<Int>{
    val tablita = ArrayList<Int>()
    tablita +=0
    tablita +=0
    tablita +=0
    tablita +=0
    tablita +=0
    tablita +=0
    tablita +=0
    tablita +=0
    tablita +=1
    tablita +=1
    tablita +=1
    tablita +=1
    tablita +=1
    tablita +=1
    tablita +=1
    tablita +=1
    tablita +=1
    tablita +=2
    tablita +=2
    tablita +=2
    tablita +=2
    tablita +=2
    tablita +=2
    tablita +=2
    tablita +=3
    return tablita
}