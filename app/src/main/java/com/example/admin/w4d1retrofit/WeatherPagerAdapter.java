package com.example.admin.w4d1retrofit;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

import com.example.admin.w4d1retrofit.fragments.BrokenCloudsFragment;
import com.example.admin.w4d1retrofit.fragments.ClearSkyFragment;
import com.example.admin.w4d1retrofit.fragments.FewCloudsFragment;
import com.example.admin.w4d1retrofit.fragments.MistFragment;
import com.example.admin.w4d1retrofit.fragments.NoDescriptionFragment;
import com.example.admin.w4d1retrofit.fragments.RainFragment;
import com.example.admin.w4d1retrofit.fragments.ScatteredCloudFragment;
import com.example.admin.w4d1retrofit.fragments.ShowerRainFragment;
import com.example.admin.w4d1retrofit.fragments.SnowFragment;
import com.example.admin.w4d1retrofit.fragments.ThunderstormFragment;
import com.example.admin.w4d1retrofit.model.List;
import com.example.admin.w4d1retrofit.model.Main;
import com.example.admin.w4d1retrofit.model.Weather;
import com.example.admin.w4d1retrofit.model.WeatherResponse;

/**
 * Created by Luis Aguirre on 9/6/2017.
 */

public class WeatherPagerAdapter extends FragmentPagerAdapter {

    LayoutInflater mInflater;
    java.util.List<List> data;// = mWeatherResponse.getList();
    private Context mContext;
    private View mView;
    private WeatherResponse mWeatherResponse;

    public WeatherPagerAdapter(FragmentManager fragmentManager, WeatherResponse weatherResponse) {
        super(fragmentManager);
        this.mWeatherResponse = weatherResponse;
        data = mWeatherResponse.getList();

    }

    @Override
    public int getCount() {
        return mWeatherResponse.getList().size();
    }

    @Override
    public Fragment getItem(int position) {
        String convertedDate = "";
        Fragment fragment = NoDescriptionFragment.newInstance("", "Page # 1");

        java.util.List<Weather> weather = data.get(position).getWeather();
        double temp = data.get(position).getMain().getTemp();

        if (weather.get(0).getDescription().equals("clear sky")) {
            fragment = ClearSkyFragment.newInstance(weather.get(0).getDescription(), String.valueOf(temp));
        }

        if (weather.get(0).getDescription().equals("few clouds")) {
            fragment = FewCloudsFragment.newInstance(weather.get(0).getDescription(), String.valueOf(temp));
        }

        if (weather.get(0).getDescription().equals("scattered clouds")) {
            fragment = ScatteredCloudFragment.newInstance(weather.get(0).getDescription(), String.valueOf(temp));
        }

        if (weather.get(0).getDescription().equals("broken clouds")) {
            fragment = BrokenCloudsFragment.newInstance(weather.get(0).getDescription(), String.valueOf(temp));
        }

        if (weather.get(0).getDescription().equals("shower rain")) {
            fragment = ShowerRainFragment.newInstance(weather.get(0).getDescription(), String.valueOf(temp));
        }

        if (weather.get(0).getDescription().equals("light rain")) {
            fragment = ShowerRainFragment.newInstance(weather.get(0).getDescription(), String.valueOf(temp));
        }

        if (weather.get(0).getDescription().equals("moderate rain")) {
            fragment = ShowerRainFragment.newInstance(weather.get(0).getDescription(), String.valueOf(temp));
        }

        if (weather.get(0).getDescription().equals("rain")) {
            fragment = RainFragment.newInstance(weather.get(0).getDescription(), String.valueOf(temp));
        }

        if (weather.get(0).getDescription().equals("thunderstorm")) {
            fragment = ThunderstormFragment.newInstance(weather.get(0).getDescription(), String.valueOf(temp));
        }

        if (weather.get(0).getDescription().equals("snow")) {
            fragment = SnowFragment.newInstance(weather.get(0).getDescription(), String.valueOf(temp));
        }

        if (weather.get(0).getDescription().equals("mist")) {
            fragment = MistFragment.newInstance(weather.get(0).getDescription(), String.valueOf(temp));

        }
    return fragment;
    }
}
