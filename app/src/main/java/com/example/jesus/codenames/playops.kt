package com.example.jesus.codenames

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_playops.*

class playops : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playops)
        asignarcolor()


    }

   private fun asignarcolor(){
       val objetoIntent: Intent= intent
       val tablita = objetoIntent.getIntegerArrayListExtra("tabla")
     //   tablita = uwu.getIntegerArrayList("tabla")
        for (lugar in 0..24){
            var coloreferente = tablita[lugar]
            when (lugar) {
                0 ->
                    when (coloreferente) {
                        0 -> Picasso.get().load(R.drawable.cartaroja).into(img1b)
                        1 -> Picasso.get().load(R.drawable.cartaazul).into(img1b)
                        2 -> Picasso.get().load(R.drawable.cartablanca).into(img1b)
                        3 -> Picasso.get().load(R.drawable.cartanegra).into(img1b)

                    }
                1 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img2b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img2b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img2b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img2b)
                }
                2 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img3b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img3b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img3b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img3b)
                }
                3 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img4b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img4b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img4b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img4b)
                }
                4 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img5b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img5b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img5b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img5b)
                }
                5 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img6b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img6b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img6b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img6b)
                }
                6 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img7b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img7b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img7b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img7b)
                }
                7 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img8b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img8b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img8b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img8b)
                }
                8 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img9b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img9b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img9b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img9b)
                }
                9 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img10b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img10b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img10b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img10b)
                }
                10 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img11b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img11b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img11b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img11b)
                }
                11 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img12b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img12b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img12b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img12b)
                }
                12 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img13b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img13b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img13b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img13b)
                }
                13 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img14b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img14b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img14b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img14b)
                }
                14 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img15b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img15b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img15b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img15b)
                }
                15 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img16b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img16b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img16b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img16b)
                }
                16 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img17b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img17b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img17b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img17b)
                }
                17 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img18b)
                    1 -> Picasso.get().load(R.drawable.cartablanca).into(img18b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img18b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img18b)
                }
                18 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img19b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img19b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img19b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img19b)
                }
                19 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img20b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img20b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img20b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img20b)
                }
                20 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img21b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img21b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img21b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img21b)
                }
                21 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img22b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img22b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img22b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img22b)
                }
                22 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img23b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img23b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img23b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img23b)
                }
                23 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img24b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img24b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img24b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img24b)
                }
                24 -> when (coloreferente) {
                    0 -> Picasso.get().load(R.drawable.cartaroja).into(img25b)
                    1 -> Picasso.get().load(R.drawable.cartaazul).into(img25b)
                    2 -> Picasso.get().load(R.drawable.cartablanca).into(img25b)
                    3 -> Picasso.get().load(R.drawable.cartanegra).into(img25b)
                }

            }

        }
    }


}
