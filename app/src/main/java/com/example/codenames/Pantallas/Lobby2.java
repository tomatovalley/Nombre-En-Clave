package com.example.codenames.Pantallas;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.codenames.Clases.Room;
import com.example.codenames.R;
import com.example.codenames.fragments.create_room_dialog;
import com.example.codenames.utils.Constants;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;
import java.util.ArrayList;

import rx.subscriptions.CompositeSubscription;

public class Lobby2 extends AppCompatActivity {
    Button crear;
    Button unirse;
    private SharedPreferences mSharedPreferences;
    private CompositeSubscription mSubscriptions;
    private String mToken;
    private String mEmail;
    private Socket mSocket ;
    public   String nickname;
    {
        try {
            mSocket = IO.socket(Constants.Base_URL);
        } catch (URISyntaxException e) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby2);
        inicializar();
        mSocket.connect();
    }

    private void inicializar(){
        crear = (Button) findViewById(R.id.btoncrear);
        unirse = (Button) findViewById(R.id.btnunirse);
        crear.setOnClickListener(view->{
            mSocket.emit("hostCreateNewGame");
        });
        unirse.setOnClickListener(view->{
            create_room_dialog fragment = new create_room_dialog();
            fragment.show(getSupportFragmentManager(),create_room_dialog.TAG);
        });
    }
}
