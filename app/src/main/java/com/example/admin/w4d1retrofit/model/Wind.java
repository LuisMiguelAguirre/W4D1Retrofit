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

class Wind {
    /**
     * speed : 1.81
     * deg : 247.501
     */

    @SerializedName("speed")
    private double speed;
    @SerializedName("deg")
    private double deg;

    public static Wind objectFromData(String str) {

        return new Gson().fromJson(str, Wind.class);
    }

    public static Wind objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Wind.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static java.util.List<Wind> arrayWindFromData(String str) {

        Type listType = new TypeToken<ArrayList<Wind>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Wind> arrayWindFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Wind>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }
}
