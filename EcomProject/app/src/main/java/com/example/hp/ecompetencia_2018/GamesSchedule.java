package com.example.hp.ecompetencia_2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class GamesSchedule extends AppCompatActivity {

    ImageButton imgcs,imgnfs,imgfifa,imgchess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_schedule);

   imgcs = (ImageButton)findViewById(R.id.imageBtn1);
        imgnfs = (ImageButton)findViewById(R.id.imageBtn3);
        imgfifa = (ImageButton)findViewById(R.id.imageBtn2);
        imgchess = (ImageButton)findViewById(R.id.imageBtn4);


   imgcs.setOnClickListener(new View.OnClickListener() {

       @Override
       public void onClick(View view) {
           Toast.makeText(getApplicationContext(),"Show Schedule Table for CS",Toast.LENGTH_SHORT).show();
       }
   });

        imgfifa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Show Schedule Table for Fifa",Toast.LENGTH_SHORT).show();
            }
        });

        imgnfs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Show Schedule Table for NFS",Toast.LENGTH_SHORT).show();
            }
        });

        imgchess.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Show Schedule Table for Chess",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
