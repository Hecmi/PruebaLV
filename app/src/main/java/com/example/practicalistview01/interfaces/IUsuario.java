package com.example.practicalistview01.interfaces;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practicalistview01.ListViewUsuarioActivity;
import com.example.practicalistview01.MainActivity;
import com.example.practicalistview01.modelos.Usuario;

public class IUsuario implements AdapterView.OnItemClickListener {
    Context context_app;

    public IUsuario(Context context){
        context_app = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("CLICK_EN",  parent.getItemAtPosition(position).toString());
        Toast.makeText(context_app, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT);


    }
}
