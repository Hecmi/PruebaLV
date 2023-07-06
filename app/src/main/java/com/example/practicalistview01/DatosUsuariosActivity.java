package com.example.practicalistview01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DatosUsuariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuarios);

        Bundle b = new Bundle();
        b = this.getIntent().getExtras();

        TextView txtNombres = (TextView)findViewById(R.id.txtNombres);
        TextView txtEmail = (TextView)findViewById(R.id.txtEmail);

        txtEmail.setText(b.getString("EMAIL_USUARIO"));
    }
}