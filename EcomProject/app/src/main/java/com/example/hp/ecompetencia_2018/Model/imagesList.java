package com.example.hp.ecompetencia_2018.Model;

import com.example.hp.ecompetencia_2018.R;

import java.util.ArrayList;

/**
 * Created by HP on 3/24/2018.
 */

public class imagesList {

    public static ArrayList<model> getlist(){
        ArrayList<model> imagesList = new ArrayList<>();
        imagesList.add(new model(R.drawable.gamebattle));
        imagesList.add(new model(R.drawable.speedpro));
        imagesList.add(new model(R.drawable.database));
        imagesList.add(new model(R.drawable.desktop));



        imagesList.add(new model(R.drawable.mobileapp));
        imagesList.add(new model(R.drawable.webdev));
        imagesList.add(new model(R.drawable.graphic));
        imagesList.add(new model(R.drawable.sketch));

        imagesList.add(new model(R.drawable.technicalquiz));
        imagesList.add(new model(R.drawable.autocad));
        imagesList.add(new model(R.drawable.creativewriting));
        imagesList.add(new model(R.drawable.linefollrobot));



        imagesList.add(new model(R.drawable.projectexhi));
        imagesList.add(new model(R.drawable.network));
        imagesList.add(new model(R.drawable.circuit));
        imagesList.add(new model(R.drawable.research));












return imagesList;
    }
}
