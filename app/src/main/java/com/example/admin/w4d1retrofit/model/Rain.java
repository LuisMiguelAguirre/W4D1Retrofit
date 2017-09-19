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

class Rain {
    /**
     * 3h : 0.32
     */

    @SerializedName("3h")
    private double $3h;

    public static Rain objectFromData(String str) {

        return new Gson().fromJson(str, Rain.class);
    }

    public static Rain objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Rain.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static java.util.List<Rain> arrayRainFromData(String str) {

        Type listType = new TypeToken<ArrayList<Rain>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Rain> arrayRainFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Rain>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public double get$3h() {
        return $3h;
    }

    public void set$3h(double $3h) {
        this.$3h = $3h;
    }
}
