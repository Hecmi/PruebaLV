package com.example.practicalistview01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.practicalistview01.WebService.Asynchtask;
import com.example.practicalistview01.WebService.WebService;
import com.example.practicalistview01.adaptadores.AdaptadorRevista;
import com.example.practicalistview01.modelos.Revista;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RevistaActivity extends AppCompatActivity implements Asynchtask, AdapterView.OnItemClickListener {
    ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revista);

        lstView = (ListView)findViewById(R.id.lvRevistas);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(
                "https://revistas.uteq.edu.ec/ws/journals.php",
                datos, RevistaActivity.this, RevistaActivity.this);
        ws.execute("GET");

        lstView.setOnItemClickListener(this);
    }

    @Override
    public void processFinish(String result) throws JSONException {
        //Log.i("ERROR:TEST1", result);
        JSONArray jArray = new JSONArray(result);
        //Log.i("ERROR:TEST2", jArray.getJSONObject(0).getString("journal_id"));
        ArrayList<Revista> aRevista = Revista.JsonObjectBuild(jArray);
        Log.i("ERROR:TESTn", jArray.getJSONObject(0).getString("journal_id"));
        AdaptadorRevista adaptadorRevista = new AdaptadorRevista(RevistaActivity.this, aRevista);
        lstView.setAdapter(adaptadorRevista);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle b = new Bundle();
        b.putString("ID_REVISTA", parent.getItemAtPosition(position).toString());

        Intent intent = new Intent(RevistaActivity.this, VolumenRevistaActivity.class);
        intent.putExtras(b);

        startActivity(intent);
    }
}