package com.example.jesus.codenames

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_play.*
import kotlinx.android.synthetic.main.activity_playops.*

class playops : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playops)
        asignarnombres()

        img25b.setOnClickListener{

        }
        img1b.setOnClickListener{

        }
        img2b.setOnClickListener{

        }
        img3b.setOnClickListener{

        }
        img4b.setOnClickListener{

        }
        img5b.setOnClickListener{

        }
        img6b.setOnClickListener{

        }
        img7b.setOnClickListener{

        }
        img8b.setOnClickListener{

        }
        img9b.setOnClickListener{

        }
        img10b.setOnClickListener{

        }
        img11b.setOnClickListener{

        }
        img12b.setOnClickListener{

        }
        img13b.setOnClickListener{

        }
        img14b.setOnClickListener{

        }
        img15b.setOnClickListener{

        }
        img16b.setOnClickListener{

        }
        img17b.setOnClickListener{

        }
        img18b.setOnClickListener{

        }
        img19b.setOnClickListener{

        }
        img20b.setOnClickListener{

        }
        img21b.setOnClickListener{

        }
        img22b.setOnClickListener{

        }
        img23b.setOnClickListener{

        }
        img24b.setOnClickListener{

        }

    }


    fun asignarnombres() {

        val objetoIntent: Intent= intent
        val tablita = objetoIntent.getIntegerArrayListExtra("tabla")
        val wordz = objetoIntent.getStringArrayExtra("wordz")

        val textView = findViewById(R.id.txt1b) as TextView
        val textView2 = findViewById(R.id.txt2b) as TextView

        val textView3: TextView = findViewById(R.id.txt3b) as TextView

        val textView4: TextView = findViewById(R.id.txt4b) as TextView

        val textView5: TextView = findViewById(R.id.txt5b) as TextView

        val textView6: TextView = findViewById(R.id.txt6b) as TextView

        val textView7: TextView = findViewById(R.id.txt7b) as TextView

        val textView8: TextView = findViewById(R.id.txt8b) as TextView

        val textView9: TextView = findViewById(R.id.txt9b) as TextView

        val textView10: TextView = findViewById(R.id.txt10b) as TextView

        val textView11: TextView = findViewById(R.id.txt11b) as TextView

        val textView12: TextView = findViewById(R.id.txt12b) as TextView

        val textView13: TextView = findViewById(R.id.txt13b) as TextView

        val textView14: TextView = findViewById(R.id.txt14b) as TextView

        val textView15: TextView = findViewById(R.id.txt15b) as TextView

        val textView16: TextView = findViewById(R.id.txt16b) as TextView

        val textView17: TextView = findViewById(R.id.txt17b) as TextView

        val textView18: TextView = findViewById(R.id.txt18b) as TextView

        val textView19: TextView = findViewById(R.id.txt19b) as TextView

        val textView20: TextView = findViewById(R.id.txt20b) as TextView

        val textView21: TextView = findViewById(R.id.txt21b) as TextView

        val textView22: TextView = findViewById(R.id.txt22b) as TextView

        val textView23 = findViewById(R.id.txt23b) as TextView

        val textView24 = findViewById(R.id.txt24b) as TextView

        val textView25 = findViewById(R.id.txt25b) as TextView
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



}
