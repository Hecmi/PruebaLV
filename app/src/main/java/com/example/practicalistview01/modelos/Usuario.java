package com.example.practicalistview01.modelos;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Usuario {
    String nombre;
    String apellido;
    String email;
    String url_avatar;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl_avatar() {
        return url_avatar;
    }

    public void setUrl_avatar(String url_avatar) {
        this.url_avatar = url_avatar;
    }

    public Usuario(JSONObject user_object) throws JSONException {
        nombre = user_object.getString("first_name");
        apellido = user_object.getString("last_name");
        email = user_object.getString("email");
        url_avatar = user_object.getString("avatar");
    }

    public static ArrayList<Usuario> JsonObjectBuild(JSONArray datos_usuario) throws JSONException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        for (int i = 0; i < datos_usuario.length(); i++){
            usuarios.add(new Usuario(datos_usuario.getJSONObject(i)));
        }

        return usuarios;
    }

    @NonNull
    @Override
    public String toString() {
        return email;
    }
}
