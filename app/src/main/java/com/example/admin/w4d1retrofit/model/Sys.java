package com.example.admin.w4d1retrofit.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.*;
import java.util.List;

/**
 * Created by Luis Aguirre on 9/6/2017.
 */

class Sys {
    /**
     * pod : d
     */

    @SerializedName("pod")
    private String pod;

    public static Sys objectFromData(String str) {

        return new Gson().fromJson(str, Sys.class);
    }

    public static Sys objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Sys.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static java.util.List<Sys> arraySysFromData(String str) {

        Type listType = new TypeToken<ArrayList<Sys>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Sys> arraySysFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Sys>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }
}
