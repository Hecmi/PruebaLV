package com.example.practicalistview01.modelos;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VolumenRevista {
    String volumen;
    String number;
    String cover;

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public VolumenRevista(JSONObject volumen_object) throws JSONException {
        volumen = volumen_object.getString("volume");
        number = volumen_object.getString("number");
        cover = volumen_object.getString("cover");
    }

    public static ArrayList<VolumenRevista> JsonObjectBuild(JSONArray datos_volumen) throws JSONException {
        ArrayList<VolumenRevista> volumen = new ArrayList<VolumenRevista>();
        for (int i = 0; i < datos_volumen.length(); i++){
            JSONObject jObject = datos_volumen.getJSONObject(i);
            volumen.add(new VolumenRevista(jObject));
        }

        return volumen;
    }
}
