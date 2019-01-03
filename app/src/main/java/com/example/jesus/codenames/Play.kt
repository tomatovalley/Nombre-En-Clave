package com.example.jesus.codenames

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_play.*
import kotlin.random.Random


class Play : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        asignar()
        asignarnombres()


    }

    override fun onStart() {
        super.onStart()




    }

    override fun onResume() {
        super.onResume()
    }
    fun asignar() {

        val tablero = generar_tablero()
        var lugar = 0



        for (i in 0..4) {
            for (j in 0..4) {
                var coloreferente = tablero[i][j]
                when (lugar) {
                    0 ->
                        when (coloreferente) {
                            0 -> Picasso.get().load(R.drawable.cartaroja).into(img1)
                            1 -> Picasso.get().load(R.drawable.cartaazul).into(img1)
                            2 -> Picasso.get().load(R.drawable.cartablanca).into(img1)
                            3 -> Picasso.get().load(R.drawable.cartanegra).into(img1)

                        }
                    1 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img2)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img2)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img2)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img2)
                    }
                    2 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img3)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img3)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img3)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img3)
                    }
                    3 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img4)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img4)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img4)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img4)
                    }
                    4 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img5)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img5)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img5)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img5)
                    }
                    5 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img6)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img6)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img6)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img6)
                    }
                    6 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img7)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img7)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img7)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img7)
                    }
                    7 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img8)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img8)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img8)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img8)
                    }
                    8 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img9)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img9)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img9)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img9)
                    }
                    9 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img10)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img10)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img10)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img10)
                    }
                    10 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img11)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img11)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img11)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img11)
                    }
                    11 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img12)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img12)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img12)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img12)
                    }
                    12 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img13)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img13)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img13)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img13)
                    }
                    13 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img14)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img14)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img14)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img14)
                    }
                    14 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img15)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img15)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img15)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img15)
                    }
                    15 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img16)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img16)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img16)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img16)
                    }
                    16 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img17)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img17)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img17)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img17)
                    }
                    17 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img18)
                        1 -> Picasso.get().load(R.drawable.cartablanca).into(img18)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img18)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img18)
                    }
                    18 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img19)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img19)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img19)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img19)
                    }
                    19 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img20)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img20)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img20)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img20)
                    }
                    20 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img21)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img21)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img21)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img21)
                    }
                    21 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img22)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img22)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img22)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img22)
                    }
                    22 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img23)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img23)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img23)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img23)
                    }
                    23 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img24)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img24)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img24)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img24)
                    }
                    24 -> when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img25)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img25)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img25)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img25)
                    }

                }
                lugar++
            }
        }
    }
    fun asignarnombres() {
        val res = resources
        val wordz = res.getStringArray(R.array.codes)
        wordz.shuffle()

        val textView = findViewById(R.id.txt1) as TextView

        val textView2: TextView = findViewById(R.id.txt2) as TextView

        val textView3: TextView = findViewById(R.id.txt3) as TextView

        val textView4: TextView = findViewById(R.id.txt4) as TextView

        val textView5: TextView = findViewById(R.id.txt5) as TextView

        val textView6: TextView = findViewById(R.id.txt6) as TextView

        val textView7: TextView = findViewById(R.id.txt7) as TextView

        val textView8: TextView = findViewById(R.id.txt8) as TextView

        val textView9: TextView = findViewById(R.id.txt9) as TextView

        val textView10: TextView = findViewById(R.id.txt10) as TextView

        val textView11: TextView = findViewById(R.id.txt11) as TextView

        val textView12: TextView = findViewById(R.id.txt12) as TextView

        val textView13: TextView = findViewById(R.id.txt13) as TextView

        val textView14: TextView = findViewById(R.id.txt14) as TextView

        val textView15: TextView = findViewById(R.id.txt15) as TextView

        val textView16: TextView = findViewById(R.id.txt16) as TextView

        val textView17: TextView = findViewById(R.id.txt17) as TextView

        val textView18: TextView = findViewById(R.id.txt18) as TextView

        val textView19: TextView = findViewById(R.id.txt19) as TextView

        val textView20: TextView = findViewById(R.id.txt20) as TextView

        val textView21: TextView = findViewById(R.id.txt21) as TextView

        val textView22: TextView = findViewById(R.id.txt22) as TextView

        val textView23: TextView = findViewById(R.id.txt23) as TextView

        val textView24: TextView = findViewById(R.id.txt24) as TextView

        val textView25: TextView = findViewById(R.id.txt25) as TextView
        var indice = 0
        textView.text = wordz[0]
        indice++
         textView2.text = wordz[indice]
         indice++
         textView3.text = wordz[indice]
         indice++
         textView4.text = wordz[indice]
         indice++
         textView5.text = wordz[indice]
         indice++
         textView6.text = wordz[indice]
         indice++
         textView7.text = wordz[indice]
         indice++
         textView8.text = wordz[indice]
         indice++
         textView9.text = wordz[indice]
         indice++
         textView10.text = wordz[indice]
         indice++
         textView11.text = wordz[indice]
         indice++
         textView12.text = wordz[indice]
         indice++
         textView13.text = wordz[indice]
         indice++
         textView14.text = wordz[indice]
         indice++
         textView15.text = wordz[indice]
         indice++
         textView16.text = wordz[indice]
         indice++
         textView17.text = wordz[indice]
         indice++
         textView18.text = wordz[indice]
         indice++
         textView19.text = wordz[indice]
         indice++
         textView20.text = wordz[indice]
         indice++
         textView21.text = wordz[indice]
         indice++
         textView22.text = wordz[indice]
         indice++
         textView23.text = wordz[indice]
         indice++
         textView24.text = wordz[indice]
         indice++
         textView25.text = wordz[indice]


    }

    fun <T> Array<T>.shuffle(): Array<T>{
        val rng = Random(Random.nextInt(0,10000))
        for(index in 0.. this.size -1){
            val randomIndex = rng.nextInt(this.size-1)
            //intercambio las posiciones
            val temp = this[index]
            this[index] = this[randomIndex]
            this[randomIndex] = temp
        }
        return this
    }


}



