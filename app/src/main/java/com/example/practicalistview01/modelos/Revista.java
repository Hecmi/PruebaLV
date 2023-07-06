package com.example.practicalistview01.modelos;

import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {
    String journal_id;
    String portada;
    String abreviation;
    String description;
    String journalThumbnail;
    String name;

    public Revista(JSONObject revista_object) throws JSONException {
        journal_id = revista_object.getString("journal_id");
        portada = revista_object.getString("portada");
        abreviation = revista_object.getString("abbreviation");
        description = revista_object.getString("description");
        journalThumbnail = revista_object.getString("journalThumbnail");
        name = revista_object.getString("name");
    }


    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJournalThumbnail() {
        return journalThumbnail;
    }

    public void setJournalThumbnail(String journalThumbnail) {
        this.journalThumbnail = journalThumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<Revista> JsonObjectBuild(JSONArray datos_revista) throws JSONException {
        ArrayList<Revista> revistas = new ArrayList<Revista>();

        for (int i = 0; i < datos_revista.length(); i++){
            JSONObject jObject = datos_revista.getJSONObject(i);
            Log.i("TEST_3",jObject.toString());
            revistas.add(new Revista(jObject));
        }

        return revistas;
    }

    @NonNull
    @Override
    public String toString() {
        return journal_id;
    }
}
