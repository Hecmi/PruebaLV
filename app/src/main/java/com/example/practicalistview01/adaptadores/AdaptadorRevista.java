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
import com.example.practicalistview01.modelos.Revista;

import java.util.ArrayList;

public class AdaptadorRevista  extends ArrayAdapter<Revista>  {

    public AdaptadorRevista(Context context, ArrayList<Revista> datos) {
        super(context, R.layout.layout_item_revista, datos);

    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater =LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.layout_item_revista, null);

        TextView lblNombreRevista  = (TextView)item.findViewById(R.id.lblNombreRevista);
        TextView lblAbreviacion  = (TextView)item.findViewById(R.id.lblNumber);

        lblNombreRevista.setText(getItem(position).getName());
        lblAbreviacion.setText(getItem(position).getAbreviation());

        ImageView imgView =(ImageView)item.findViewById(R.id.imgVolumen);

        Glide.with(this.getContext()).load(getItem(position).getPortada()).into(imgView);

        return item;
    }

}
