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

public class Main {
    /**
     * temp : 286.67
     * temp_min : 281.556
     * temp_max : 286.67
     * pressure : 972.73
     * sea_level : 1046.46
     * grnd_level : 972.73
     * humidity : 75
     * temp_kf : 5.11
     */

    @SerializedName("temp")
    private double temp;
    @SerializedName("temp_min")
    private double tempMin;
    @SerializedName("temp_max")
    private double tempMax;
    @SerializedName("pressure")
    private double pressure;
    @SerializedName("sea_level")
    private double seaLevel;
    @SerializedName("grnd_level")
    private double grndLevel;
    @SerializedName("humidity")
    private int humidity;
    @SerializedName("temp_kf")
    private double tempKf;

    public static Main objectFromData(String str) {

        return new Gson().fromJson(str, Main.class);
    }

    public static Main objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Main.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static java.util.List<Main> arrayMainFromData(String str) {

        Type listType = new TypeToken<ArrayList<Main>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Main> arrayMainFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Main>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public double getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(double grndLevel) {
        this.grndLevel = grndLevel;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTempKf() {
        return tempKf;
    }

    public void setTempKf(double tempKf) {
        this.tempKf = tempKf;
    }
}
