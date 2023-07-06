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

import java.util.ArrayList;

import com.example.practicalistview01.modelos.Usuario;

public class AdaptadorUsuario extends ArrayAdapter<Usuario> {

    public AdaptadorUsuario(Context context, ArrayList<Usuario> datos) {
        super(context, R.layout.item_usuario_layout, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater =LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_usuario_layout, null);

        TextView lblNombre  = (TextView)item.findViewById(R.id.lblNombreRevista);
        TextView lblEmail  = (TextView)item.findViewById(R.id.lblNumber);
        TextView lblWeb  = (TextView)item.findViewById(R.id.lblweb);

        lblNombre.setText(getItem(position).getNombre() + " " + getItem(position).getApellido());
        lblEmail.setText(getItem(position).getEmail());
        lblWeb.setText(getItem(position).getUrl_avatar());

        ImageView imgView =(ImageView)item.findViewById(R.id.imgVolumen);

        Glide.with(this.getContext()).load(getItem(position).getUrl_avatar()).into(imgView);

        return item;
    }
}
