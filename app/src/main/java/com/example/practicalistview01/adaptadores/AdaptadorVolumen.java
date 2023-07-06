package com.example.practicalistview01.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.practicalistview01.R;
import com.example.practicalistview01.modelos.VolumenRevista;

import java.util.ArrayList;

public class AdaptadorVolumen extends ArrayAdapter<VolumenRevista> {
    public AdaptadorVolumen(Context context, ArrayList<VolumenRevista> datos) {
        super(context, R.layout.layout_item_volumen_revista, datos);

    }


    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater =LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.layout_item_revista, null);

        TextView lblVolume  = (TextView)item.findViewById(R.id.lblVolumeDR);
        TextView lblNumber  = (TextView)item.findViewById(R.id.lblNumber);

        //lblVolume.setText(getItem(position).getVolumen());
        lblNumber.setText(getItem(position).getNumber());

        //ImageView imgView =(ImageView)item.findViewById(R.id.imgCover);

        //Glide.with(this.getContext()).load(getItem(position).getCover()).into(imgView);

        return item;
    }

}
