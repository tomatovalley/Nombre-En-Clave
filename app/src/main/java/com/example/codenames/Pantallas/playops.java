package com.example.codenames.Pantallas;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.example.codenames.R;
import com.example.codenames.utils.Constants;
import com.example.codenames.utils.Variantes;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONArray;
import org.json.JSONException;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class playops extends AppCompatActivity {
    TextView num;
    TextView pista;
    TextView puntazul;
    TextView puntRojo;
    ImageView img0;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView img9;
    ImageView img10;
    ImageView img11;
    ImageView img12;
    ImageView img13;
    ImageView img14;
    ImageView img15;
    ImageView img16;
    ImageView img17;
    ImageView img18;
    ImageView img19;
    ImageView img20;
    ImageView img21;
    ImageView img22;
    ImageView img23;
    ImageView img24;
    TextView txt0;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;
    TextView txt7;
    TextView txt8;
    TextView txt9;
    TextView txt10;
    TextView txt11;
    TextView txt12;
    TextView txt13;
    TextView txt14;
    TextView txt15;
    TextView txt16;
    TextView txt17;
    TextView txt18;
    TextView txt19;
    TextView txt20;
    TextView txt21;
    TextView txt22;
    TextView txt23;
    TextView txt24;
    private Socket mSocket ;
    {
        try {
            mSocket = IO.socket(Constants.Base_URL);
        } catch (URISyntaxException e) {
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playops);
        initviews();
        initButtons();
        inhabilitar();
        mSocket.on("newTablero",tab);
        mSocket.on("empieza",empieza);
        mSocket.on("newpalabras",words);
        mSocket.on("nuevoturno",nuevoturno);
        mSocket.on("nuevoturno2",nuevoturno2);
        //respuesta
        mSocket.on("respuesta",respuesta);
        mSocket.on("gameover",gameover);
        mSocket.on("actpuntg",actpuntg);
        mSocket.on("actpuntp",actpuntp);
        mSocket.on("fin",fin);



    }
    private void verifyturn(){
        if(Variantes.pos == Variantes.turno){
            habilitar();
        }else{
            inhabilitar();
        }
    }

    private void habilitar(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                img0.setEnabled(true);
                img1.setEnabled(true);
                img2.setEnabled(true);
                img3.setEnabled(true);
                img4.setEnabled(true);
                img5.setEnabled(true);
                img6.setEnabled(true);
                img7.setEnabled(true);
                img8.setEnabled(true);
                img9.setEnabled(true);
                img10.setEnabled(true);
                img11.setEnabled(true);
                img12.setEnabled(true);
                img13.setEnabled(true);
                img14.setEnabled(true);
                img15.setEnabled(true);
                img16.setEnabled(true);
                img17.setEnabled(true);
                img18.setEnabled(true);
                img19.setEnabled(true);
                img20.setEnabled(true);
                img21.setEnabled(true);
                img22.setEnabled(true);
                img23.setEnabled(true);
                img24.setEnabled(true);
            }
        });



    }
    private void inhabilitar(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                img0.setEnabled(false);
                img1.setEnabled(false);
                img2.setEnabled(false);
                img3.setEnabled(false);
                img4.setEnabled(false);
                img5.setEnabled(false);
                img6.setEnabled(false);
                img7.setEnabled(false);
                img8.setEnabled(false);
                img9.setEnabled(false);
                img10.setEnabled(false);
                img11.setEnabled(false);
                img12.setEnabled(false);
                img13.setEnabled(false);
                img14.setEnabled(false);
                img15.setEnabled(false);
                img16.setEnabled(false);
                img17.setEnabled(false);
                img18.setEnabled(false);
                img19.setEnabled(false);
                img20.setEnabled(false);
                img21.setEnabled(false);
                img22.setEnabled(false);
                img23.setEnabled(false);
                img24.setEnabled(false);
            }
        });


    }

    private void initviews(){
        puntazul = findViewById(R.id.tmb);
        puntRojo = findViewById(R.id.tmr);
        txt0 = findViewById(R.id.txt1b);
        txt1 = findViewById(R.id.txt2b);
        txt2 = findViewById(R.id.txt3b);
        txt3 = findViewById(R.id.txt4b);
        txt4 = findViewById(R.id.txt5b);
        txt5 = findViewById(R.id.txt6b);
        txt6 = findViewById(R.id.txt7b);
        txt7 = findViewById(R.id.txt8b);
        txt8 = findViewById(R.id.txt9b);
        txt9 = findViewById(R.id.txt10b);
        txt10 = findViewById(R.id.txt11b);
        txt11 = findViewById(R.id.txt12b);
        txt12 = findViewById(R.id.txt13b);
        txt13 = findViewById(R.id.txt14b);
        txt14 = findViewById(R.id.txt15b);
        txt15 = findViewById(R.id.txt16b);
        txt16 = findViewById(R.id.txt17b);
        txt17 = findViewById(R.id.txt18b);
        txt18 = findViewById(R.id.txt19b);
        txt19 = findViewById(R.id.txt20b);
        txt20 = findViewById(R.id.txt21b);
        txt21 = findViewById(R.id.txt22b);
        txt22 = findViewById(R.id.txt23b);
        txt23 = findViewById(R.id.txt24b);
        txt24 = findViewById(R.id.txt25b);
        img0 = findViewById(R.id.img1b);
        img1 = findViewById(R.id.img2b);
        img2 = findViewById(R.id.img3b);
        img3 = findViewById(R.id.img4b);
        img4 = findViewById(R.id.img5b);
        img5 = findViewById(R.id.img6b);
        img6 = findViewById(R.id.img7b);
        img7 = findViewById(R.id.img8b);
        img8 = findViewById(R.id.img9b);
        img9 = findViewById(R.id.img10b);
        img10 = findViewById(R.id.img11b);
        img11 = findViewById(R.id.img12b);
        img12 = findViewById(R.id.img13b);
        img13 = findViewById(R.id.img14b);
        img14 = findViewById(R.id.img15b);
        img15 = findViewById(R.id.img16b);
        img16 = findViewById(R.id.img17b);
        img17 = findViewById(R.id.img18b);
        img18 = findViewById(R.id.img19b);
        img19 = findViewById(R.id.img20b);
        img20 = findViewById(R.id.img21b);
        img21 = findViewById(R.id.img22b);
        img22 = findViewById(R.id.img23b);
        img23 = findViewById(R.id.img24b);
        img24 = findViewById(R.id.img25b);

    }

    private void initButtons(){
        int team;
        if(Variantes.team.contains("red")){
            team = 0;
        }else{
            team = 1;
        }
        img0.setOnClickListener(view ->{
            movimiento(team,0);

        });
        img1.setOnClickListener(view ->{
            movimiento(team,1);
        });
        img2.setOnClickListener(view ->{
            movimiento(team,2);
        });
        img3.setOnClickListener(view ->{
            movimiento(team,3);
        });
        img4.setOnClickListener(view ->{
            movimiento(team,4);
        });
        img5.setOnClickListener(view ->{
            movimiento(team,5);
        });
        img6.setOnClickListener(view ->{
            movimiento(team,6);
        });
        img7.setOnClickListener(view ->{
            movimiento(team,7);
        });
        img8.setOnClickListener(view ->{
            movimiento(team,8);
        });
        img9.setOnClickListener(view ->{
            movimiento(team,9);
        });
        img10.setOnClickListener(view ->{
            movimiento(team,10);
        });
        img11.setOnClickListener(view ->{
            movimiento(team,11);
        });
        img12.setOnClickListener(view ->{
            movimiento(team,12);
        });
        img13.setOnClickListener(view ->{
            movimiento(team,13);
        });
        img14.setOnClickListener(view ->{
            movimiento(team,14);
        });
        img15.setOnClickListener(view ->{
            movimiento(team,15);
        });
        img16.setOnClickListener(view ->{
            movimiento(team,16);
        });
        img17.setOnClickListener(view ->{
            movimiento(team,17);
        });
        img18.setOnClickListener(view ->{
            movimiento(team,18);
        });
        img19.setOnClickListener(view ->{
            movimiento(team,19);
        });
        img20.setOnClickListener(view ->{
            movimiento(team,20);
        });
        img21.setOnClickListener(view ->{
            movimiento(team,21);
        });
        img22.setOnClickListener(view ->{
            movimiento(team,22);
        });
        img23.setOnClickListener(view ->{
            movimiento(team,23);
        });
        img24.setOnClickListener(view ->{
            movimiento(team,24);
        });












    }

    private void movimiento(Integer team ,Integer img){
        if( Variantes.posibilidades != 0) {
            if (Variantes.tablero.get(img) == team) {
                mSocket.emit("atinada", img, Variantes.gameid);
                mSocket.emit("actpuntg",team,Variantes.gameid);
                Variantes.posibilidades--;
                if(Variantes.posibilidades == 0){
                    mSocket.emit("sigequipo",Variantes.pos,Variantes.gameid);
                }
            } else {
                if (Variantes.tablero.get(img) == 2) {
                    mSocket.emit("semiatinada", img, Variantes.gameid);
                    mSocket.emit("sigequipo",Variantes.pos,Variantes.gameid);
                } else {
                    if (Variantes.tablero.get(img) == 3) {
                        mSocket.emit("gameover", img, Variantes.gameid,team);
                    } else {
                        mSocket.emit("noatinada", img, Variantes.gameid);
                        mSocket.emit("actpuntp",team,Variantes.gameid);
                        mSocket.emit("sigequipo",Variantes.pos,Variantes.gameid);

                    }
                }
            }
        }else{
            mSocket.emit("sigequipo",Variantes.pos,Variantes.gameid);
        }
    }

    private Emitter.Listener words = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            {
                runOnUiThread(() -> {
                    JSONArray data = (JSONArray) args[0];
                    ArrayList<String> ar = new ArrayList<String>();
                    for(int i = 0;i < data.length();i++){
                        try {
                            Log.e("palabras",data.getString(i));
                            switch (i){
                                case 0:
                                    txt0.setText(data.getString(i));
                                    break;
                                case 1:
                                    txt1.setText(data.getString(i));
                                    break;
                                case 2:
                                    txt2.setText(data.getString(i));
                                    break;
                                case 3:
                                    txt3.setText(data.getString(i));
                                    break;
                                case 4:
                                    txt4.setText(data.getString(i));
                                    break;
                                case 5:
                                    txt5.setText(data.getString(i));
                                    break;
                                case 6:
                                    txt6.setText(data.getString(i));
                                    break;
                                case 7:
                                    txt7.setText(data.getString(i));
                                    break;
                                case 8:
                                    txt8.setText(data.getString(i));
                                    break;
                                case 9:
                                    txt9.setText(data.getString(i));
                                    break;
                                case 10:
                                    txt10.setText(data.getString(i));
                                    break;
                                case 11:
                                    txt11.setText(data.getString(i));
                                    break;
                                case 12:
                                    txt12.setText(data.getString(i));
                                    break;
                                case 13:
                                    txt13.setText(data.getString(i));
                                    break;
                                case 14:
                                    txt14.setText(data.getString(i));
                                    break;
                                case 15:
                                    txt15.setText(data.getString(i));
                                    break;
                                case 16:
                                    txt16.setText(data.getString(i));
                                    break;
                                case 17:
                                    txt17.setText(data.getString(i));
                                    break;
                                case 18:
                                    txt18.setText(data.getString(i));
                                    break;
                                case 19:
                                    txt19.setText(data.getString(i));
                                    break;
                                case 20:
                                    txt20.setText(data.getString(i));
                                    break;
                                case 21:
                                    txt21.setText(data.getString(i));
                                    break;
                                case 22:
                                    txt22.setText(data.getString(i));
                                    break;
                                case 23:
                                    txt23.setText(data.getString(i));
                                    break;
                                case 24:
                                    txt24.setText(data.getString(i));
                                    break;
                                default:
                                    break;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }

    };

    private Emitter.Listener empieza = args -> {
        JSONArray data = (JSONArray) args[0];
        try {
            Variantes.turno = data.getInt(0);
            Variantes.empezo = data.getInt(0);
            verifyturn();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    };

    private Emitter.Listener nuevoturno = args -> {
        pista = findViewById(R.id.pista1);
        num = findViewById(R.id.numero1);
        JSONArray data = (JSONArray) args[0];

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        pista.setText(data.getString(0));
                        Variantes.posibilidades = data.getInt(1);
                        num.setText(data.getString(1));
                        Variantes.turno = data.getInt(2);
                        Log.e("nuevoturno", Variantes.posibilidades.toString());
                        Log.e("nuevoturno", Variantes.turno.toString());
                        verifyturn();
                    }catch (JSONException e){

                    }
                }
            });



    };

    private Emitter.Listener tab = args -> {
        JSONArray data = (JSONArray) args[0];
        ArrayList<Integer>ar = new ArrayList<Integer>();
        for(int i = 0;i < data.length();i++) {
            try {
                ar.add(i,data.getInt(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Variantes.tablero = ar;
        Log.e("tablero","el tablero se lee");
        for(int i = 0; i < Variantes.tablero.size()-1 ;i++ ){
            Log.e("tablero", Variantes.tablero.get(i).toString());
        }
    };

    private Emitter.Listener nuevoturno2 = args -> {
      Integer data = (Integer) args[0];
      Variantes.turno = data;
      verifyturn();

    };

    private Emitter.Listener respuesta = args -> {
        Integer data = (Integer) args[0];
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (data){
                    case 0:switch (Variantes.tablero.get(data)){
                        case 0: img0.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img0.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img0.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img0.setImageResource(R.drawable.cartanegra);
                    }
                        break;
                    case 1:switch (Variantes.tablero.get(data)){
                        case 0: img1.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img1.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img1.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img1.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 2:switch (Variantes.tablero.get(data)){
                        case 0: img2.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img2.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img2.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img2.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 3:switch (Variantes.tablero.get(data)){
                        case 0: img3.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img3.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img3.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img3.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 4:switch (Variantes.tablero.get(data)){
                        case 0: img4.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img4.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img4.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img4.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 5:switch (Variantes.tablero.get(data)){
                        case 0: img5.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img5.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img5.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img5.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 6:switch (Variantes.tablero.get(data)){
                        case 0: img6.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img6.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img6.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img6.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 7:switch (Variantes.tablero.get(data)){
                        case 0: img7.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img7.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img7.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img7.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 8:switch (Variantes.tablero.get(data)){
                        case 0: img8.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img8.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img8.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img8.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 9:switch (Variantes.tablero.get(data)){
                        case 0: img9.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img9.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img9.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img9.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 10:switch (Variantes.tablero.get(data)){
                        case 0: img10.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img10.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img10.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img10.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 11:switch (Variantes.tablero.get(data)){
                        case 0: img11.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img11.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img11.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img11.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 12:switch (Variantes.tablero.get(data)){
                        case 0: img12.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img12.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img12.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img12.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 13:switch (Variantes.tablero.get(data)){
                        case 0: img13.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img13.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img13.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img13.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 14:switch (Variantes.tablero.get(data)){
                        case 0: img14.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img14.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img14.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img14.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 15:switch (Variantes.tablero.get(data)){
                        case 0: img15.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img15.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img15.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img15.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 16:switch (Variantes.tablero.get(data)){
                        case 0: img16.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img16.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img16.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img16.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 17:switch (Variantes.tablero.get(data)){
                        case 0: img17.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img17.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img17.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img17.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 18:switch (Variantes.tablero.get(data)){
                        case 0: img18.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img18.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img18.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img18.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 19:switch (Variantes.tablero.get(data)){
                        case 0: img19.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img19.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img19.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img19.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 20:switch (Variantes.tablero.get(data)){
                        case 0: img20.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img20.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img20.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img20.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 21:switch (Variantes.tablero.get(data)){
                        case 0: img21.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img21.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img21.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img21.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 22:switch (Variantes.tablero.get(data)){
                        case 0: img22.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img22.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img22.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img22.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 23:switch (Variantes.tablero.get(data)){
                        case 0: img23.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img23.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img23.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img23.setImageResource(R.drawable.cartanegra);
                    }break;
                    case 24:switch (Variantes.tablero.get(data)){
                        case 0: img24.setImageResource(R.drawable.cartaroja);
                            break;
                        case 1: img24.setImageResource(R.drawable.cartaazul);
                            break;
                        case 2: img24.setImageResource(R.drawable.cartablanca);
                            break;
                        case 3: img24.setImageResource(R.drawable.cartanegra);
                    }break;
                    default:break;


                }
            }
        });

    };

    private Emitter.Listener gameover = args -> {
        finish();
    };

    private Emitter.Listener actpuntp = args ->{
        Log.e("puntuaciones","llego hasta las puntuaciones");
        Integer data = (Integer)args[0];
        Log.e("puntuaciones",data.toString());
        if(data == 0){
            Variantes.puntuacionB++;
        }else{
            Variantes.puntuacionR++;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                puntRojo.setText("Equipo rojo : "+ Variantes.puntuacionR);
                puntazul.setText("Equipo azul : "+ Variantes.puntuacionB);
            }
        });

    };

    private Emitter.Listener actpuntg = args -> {
        Log.e("puntuaciones","llego hasta las puntuaciones");
        Integer data = (Integer)args[0];
        Log.e("puntuaciones",data.toString());
        if(data == 0){
            Variantes.puntuacionR++;
            if(Variantes.empezo == 1){
                if(Variantes.puntuacionR == 9){
                    mSocket.emit("ganador","Equipo Rojo",Variantes.gameid);
                }
            }else{
                if(Variantes.puntuacionR == 8){
                    mSocket.emit("ganador","Equipo Rojo",Variantes.gameid);
                }
            }
        }else{
            Variantes.puntuacionB++;
            if(Variantes.empezo == 2){
                if(Variantes.puntuacionB == 9){
                    mSocket.emit("ganador","Equipo Azul",Variantes.gameid);
                }
            }else{
                if(Variantes.puntuacionB == 8 ){
                    mSocket.emit("ganador", "Equipo Azul",Variantes.gameid);
                }
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                puntRojo.setText("Equipo rojo : "+ Variantes.puntuacionR);
                puntazul.setText("Equipo azul : "+ Variantes.puntuacionB);
            }
        });


    };

    Emitter.Listener fin = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            String Data = (String) args[0];
            Toast.makeText(playops.this, "ha ganado el equipo "+ Data ,Toast.LENGTH_LONG);
            finish();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSocket.disconnect();
    }
}

