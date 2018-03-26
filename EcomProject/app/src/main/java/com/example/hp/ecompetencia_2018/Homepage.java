package com.example.hp.ecompetencia_2018;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp.ecompetencia_2018.Model.imagesList;
import com.example.hp.ecompetencia_2018.Model.model;
import com.example.hp.ecompetencia_2018.adapter.listAdapter;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {

   private ListView listView;
   boolean doubleBackToExitPressedOnce =false;
    private ArrayList<model> models;
    private listAdapter listAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
     //   getSupportActionBar().hide();
    listView = (ListView)findViewById(R.id.listview);
    models = imagesList.getlist();
    listAdapter1 = new listAdapter(Homepage.this,models);
    listView.setAdapter(listAdapter1);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            callPosition(position);

        }
    });
    }

    @Override
    public void onBackPressed() {
        // Put your own code here which you want to run on back button click.
        if(doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = false;
        dialog();
    }

    private void callPosition(int position) {
        switch (position){
            case 0:
//                Toast.makeText(getApplicationContext(),"this is test"+position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Homepage.this , GamesSchedule.class);
                startActivity(intent);
                break;
            case 1:
                Toast.makeText(getApplicationContext(),"this is test"+position,Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(),"this is test"+position,Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(),"this is test"+position,Toast.LENGTH_SHORT).show();
                break;

            case 4:
                Toast.makeText(getApplicationContext(),"this is test"+position,Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(getApplicationContext(),"this is test"+position,Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(getApplicationContext(),"this is test"+position,Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(getApplicationContext(),"this is test"+position,Toast.LENGTH_SHORT).show();
                break;
            case 8:
                Toast.makeText(getApplicationContext(),"this is test"+position,Toast.LENGTH_SHORT).show();
                break;
            case 9:
                Toast.makeText(getApplicationContext(),"this is test"+position,Toast.LENGTH_SHORT).show();
                break;

            case 10:
                Toast.makeText(getApplicationContext(),"this is test"+position,Toast.LENGTH_SHORT).show();
                break;
            case 11:
                Toast.makeText(getApplicationContext(),"this is test"+position,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void dialog(){
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setMessage("Do you really want to exit?");
        build.setCancelable(true);
        build.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                doubleBackToExitPressedOnce = false;
                return;
            }
        });

        build.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

            }
        });
        AlertDialog alert11 = build.create();
        alert11.show();
    }

}
