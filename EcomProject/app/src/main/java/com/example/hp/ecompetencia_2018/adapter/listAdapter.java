package com.example.hp.ecompetencia_2018.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.hp.ecompetencia_2018.Model.model;
import com.example.hp.ecompetencia_2018.R;

import java.util.ArrayList;

/**
 * Created by HP on 3/24/2018.
 */

public class listAdapter extends BaseAdapter {

  private Context context;
  private ArrayList<model>  Model;


    public listAdapter(Context context, ArrayList<model> model) {
        this.context = context;
        Model = model;
    }

    @Override
    public int getCount() {
        return Model.size();
    }

    @Override
    public Object getItem(int position) {
        return Model.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {

        if(convertview == null){
            convertview = View.inflate(context, R.layout.listitems , null);
        }

        ImageView  images= (ImageView) convertview.findViewById(R.id.img_btn);
        model Model1 = Model.get(position);

        images.setImageResource(Model1.getImageno());

        return convertview;
    }
}
