package com.example.practicalistview01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.practicalistview01.adaptadores.AdaptadorUsuario;
import com.example.practicalistview01.interfaces.IUsuario;
import com.example.practicalistview01.modelos.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListViewUsuarioActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_usuario);

        ListView lstView = (ListView)findViewById(R.id.lstUsuarios);
        //lstView.setOnItemClickListener(new IUsuario(getApplicationContext()));
        lstView.setOnItemClickListener(this);

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://reqres.in/api/users",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.i("TEST_1", "si");
                            JSONObject jObect = new JSONObject(response);
                            JSONArray jArray = jObect.getJSONArray("data");

                            ArrayList<Usuario> usuarios = Usuario.JsonObjectBuild(jArray);

                            AdaptadorUsuario adaptadorUsuario = new AdaptadorUsuario(ListViewUsuarioActivity.this, usuarios);
                            ListView lstView = (ListView)findViewById(R.id.lstUsuarios);
                            lstView.setAdapter(adaptadorUsuario);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("TEST_2", "NO SIRVE");
                    }
                }) {
        };
        queue.add(stringRequest);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle b = new Bundle();
        b.putString("EMAIL_USUARIO", parent.getItemAtPosition(position).toString());

        Intent intent = new Intent(ListViewUsuarioActivity.this, DatosUsuariosActivity.class);
        intent.putExtras(b);

        startActivity(intent);
    }
}