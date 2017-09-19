package com.example.admin.w4d1retrofit.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Luis Aguirre on 9/6/2017.
 */

public class List {
    /**
     * dt : 1487246400
     * main : {"temp":286.67,"temp_min":281.556,"temp_max":286.67,"pressure":972.73,"sea_level":1046.46,"grnd_level":972.73,"humidity":75,"temp_kf":5.11}
     * weather : [{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}]
     * clouds : {"all":0}
     * wind : {"speed":1.81,"deg":247.501}
     * sys : {"pod":"d"}
     * dt_txt : 2017-02-16 12:00:00
     * rain : {"3h":0.32}
     * snow : {"3h":0.0775}
     */

    @SerializedName("dt")
    private int dt;
    @SerializedName("main")
    private Main main;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("sys")
    private Sys sys;
    @SerializedName("dt_txt")
    private String dtTxt;
    @SerializedName("rain")
    private Rain rain;
    @SerializedName("snow")
    private Snow snow;
    @SerializedName("weather")
    private java.util.List<Weather> weather = null;

    public static List objectFromData(String str) {

        return new Gson().fromJson(str, List.class);
    }

    public static List objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), List.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static java.util.List<List> arrayListFromData(String str) {

        Type listType = new TypeToken<ArrayList<List>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static java.util.List<List> arrayListFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<List>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }
}
