package com.example.admin.w4d1retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.d("TAG", "onCreate: ");

        SunnyFragment sunnyFragment =  SunnyFragment.newInstance("firstArg", "secondArg");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_layout_fragment, sunnyFragment, "SUNNY_FRAGMENT_TAG")
                .commit();

    }
}
