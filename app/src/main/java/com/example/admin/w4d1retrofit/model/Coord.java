package com.example.admin.w4d1retrofit.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis Aguirre on 9/6/2017.
 */

class Coord {
    /**
     * lat : 48.137
     * lon : 11.5752
     */

    @SerializedName("lat")
    private double lat;
    @SerializedName("lon")
    private double lon;

    public static Coord objectFromData(String str) {

        return new Gson().fromJson(str, Coord.class);
    }

    public static Coord objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Coord.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Coord> arrayCoordFromData(String str) {

        Type listType = new TypeToken<ArrayList<Coord>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Coord> arrayCoordFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Coord>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
