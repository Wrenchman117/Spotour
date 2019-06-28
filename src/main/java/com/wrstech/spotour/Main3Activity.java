package com.wrstech.spotour;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class Main3Activity extends AppCompatActivity {

    ImageView img;
    TextView txt;
    FloatingActionButton fab;
    TextToSpeech tts;

    String titletxt, infotxt, placetxt, typetxt;
    int pos_num;

    int[] pictures_historical_SJ = {R.drawable.old_san_juan, R.drawable.castillo_s_critobal, R.drawable.escambron};
    int[] pictures_historical_P = {R.drawable.guancha, R.drawable.museo, R.drawable.el_vigia};

    int[] pictures_restaurant_SJ = {R.drawable.chococortez, R.drawable.santaella, R.drawable.salonfondo};
    int[] pictures_restaurant_P = {R.drawable.casaschef, R.drawable.campioni, R.drawable.longhornponce};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        titletxt = getIntent().getStringExtra("title");
        infotxt = getIntent().getStringExtra("info");
        placetxt = getIntent().getStringExtra("place");
        typetxt = getIntent().getStringExtra("type");
        pos_num = getIntent().getIntExtra("position", 0);


        img = (ImageView)findViewById(R.id.image);
        txt = (TextView)findViewById(R.id.txtView);

        String message = titletxt + "\n\n" + infotxt;

        txt.setText(message);

        fab = (FloatingActionButton)findViewById(R.id.fbtn);
        fab.setImageResource(R.drawable.ic_action_play);

        getPicture(placetxt, typetxt, pos_num);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                tts.setLanguage(Locale.US);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tts.speak(infotxt, TextToSpeech.QUEUE_ADD, null);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

        tts.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        tts.stop();
    }

    protected void getPicture(String p, String t, int pos){

        if(placetxt.equals("Ponce")){
            if(typetxt.equals("Restaurants")){
                img.setImageResource(pictures_restaurant_P[pos]);
            }else{
                img.setImageResource(pictures_historical_P[pos]);
            }
        }else{
            if(typetxt.equals("Restaurants")){
                img.setImageResource(pictures_restaurant_SJ[pos]);
            }else{
                img.setImageResource(pictures_historical_SJ[pos]);
            }
        }



    }
}
