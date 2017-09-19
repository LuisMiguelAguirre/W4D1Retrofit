package com.example.admin.w4d1retrofit;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.admin.w4d1retrofit.model.City;
import com.example.admin.w4d1retrofit.model.List;
import com.example.admin.w4d1retrofit.model.Weather;
import com.example.admin.w4d1retrofit.model.WeatherResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import me.relex.circleindicator.CircleIndicator;

import static android.R.attr.data;
import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity implements CloudyFragment.OnFragmentInteractionListener, SunnyFragment.OnFragmentInteractionListener, FogFragment.OnFragmentInteractionListener, ShowerFragment.OnFragmentInteractionListener, StormFragment.OnFragmentInteractionListener {

    WeatherPagerAdapter mAdapter;
    ViewPager mViewPager;
    CircleIndicator mCircleIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.view_pager_id);
        mCircleIndicator = (CircleIndicator) findViewById(R.id.circle_indicator_id);

        //mViewPager.setAdapter(mAdapter);
        //mCircleIndicator.setViewPager(mViewPager);
       /* SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = format.format(Calendar.getInstance().getTime());
        Log.d("TAG", "onCreate: " + currentDate);*/
        retrofitCall();

    }

    private void retrofitCall() {
        final retrofit2.Call<WeatherResponse> callRepos =
                RetrofitHelper.createCall("atlanta");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final WeatherResponse weatherResponse = (callRepos.execute().body());
                    //java.util.List<List> data = weatherResponse.getList();//.getWeather().get(0).getDescription();
                    //java.util.List<Weather> weather =  data.get(0).getWeather();
                    //weather.get(0).getDescription();

                    //java.util.Map<String, java.util.List<List>> dates = new java.util.HashMap<>();
                    //for (List date:data) {
                    //    Log.d("DtTxt", "run: " + date.getDtTxt().substring(0,10));
                    //}


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new WeatherPagerAdapter(getSupportFragmentManager(), weatherResponse);
                            mViewPager.setAdapter(mAdapter);
                            mCircleIndicator.setViewPager(mViewPager);
                        }
                    });


                  //  Log.d("TAG", "makingRestCalls: " + weather.get(0).getDescription());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
