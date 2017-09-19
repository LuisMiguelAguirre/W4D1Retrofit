package com.example.admin.w4d1retrofit;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
import com.example.admin.w4d1retrofit.model.WeatherResponse;

import java.io.IOException;

import me.relex.circleindicator.CircleIndicator;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity implements
        BrokenCloudsFragment.OnFragmentInteractionListener,
        ClearSkyFragment.OnFragmentInteractionListener,
        FewCloudsFragment.OnFragmentInteractionListener,
        MistFragment.OnFragmentInteractionListener,
        RainFragment.OnFragmentInteractionListener,
        ScatteredCloudFragment.OnFragmentInteractionListener,
        ShowerRainFragment.OnFragmentInteractionListener,
        SnowFragment.OnFragmentInteractionListener,
        ThunderstormFragment.OnFragmentInteractionListener,
        NoDescriptionFragment.OnFragmentInteractionListener

{

    WeatherPagerAdapter mAdapter;
    ViewPager mViewPager;
    CircleIndicator mCircleIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.view_pager_id);
        mCircleIndicator = (CircleIndicator) findViewById(R.id.circle_indicator_id);

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

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new WeatherPagerAdapter(getSupportFragmentManager(), weatherResponse);
                            mViewPager.setAdapter(mAdapter);
                            mCircleIndicator.setViewPager(mViewPager);
                        }
                    });


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
