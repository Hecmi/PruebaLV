package com.example.practicalistview01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.practicalistview01.WebService.Asynchtask;
import com.example.practicalistview01.WebService.WebService;
import com.example.practicalistview01.adaptadores.AdaptadorRevista;
import com.example.practicalistview01.adaptadores.AdaptadorVolumen;
import com.example.practicalistview01.modelos.Revista;
import com.example.practicalistview01.modelos.VolumenRevista;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VolumenRevistaActivity extends AppCompatActivity implements Asynchtask {

    ListView lvVolumenRevista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_revista);
        lvVolumenRevista = (ListView)findViewById(R.id.lvVolumen);
        Bundle b = this.getIntent().getExtras();

        String id = b.getString("ID_REVISTA");
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(
                "https://revistas.uteq.edu.ec/ws/issues.php?j_id="
                + id,
                datos, VolumenRevistaActivity.this, VolumenRevistaActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray jArray = new JSONArray(result);
        ArrayList<VolumenRevista> aVolumen= VolumenRevista.JsonObjectBuild(jArray);
        AdaptadorVolumen adaptadorVolumen = new AdaptadorVolumen(VolumenRevistaActivity.this, aVolumen);
        lvVolumenRevista.setAdapter(adaptadorVolumen);
    }
}