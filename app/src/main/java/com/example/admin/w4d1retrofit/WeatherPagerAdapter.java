package com.example.admin.w4d1retrofit;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.TimeUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.admin.w4d1retrofit.model.List;
import com.example.admin.w4d1retrofit.model.WeatherResponse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

import static android.R.attr.data;

/**
 * Created by Luis Aguirre on 9/6/2017.
 */

public class WeatherPagerAdapter extends FragmentPagerAdapter {

    public int[] images = {
            R.drawable.cloudy2,
            R.drawable.sunny,
            R.drawable.light_rain,
            R.drawable.shower3,
            R.drawable.fog};

    LayoutInflater mInflater;
    private Context mContext;
    private View mView;
    private WeatherResponse mWeatherResponse;

    public WeatherPagerAdapter(FragmentManager fragmentManager, WeatherResponse weatherResponse) {
        super(fragmentManager);
        this.mWeatherResponse = weatherResponse;
    }

    @Override
    public int getCount() {
        return 5;
    }

/*    @Override
    public boolean isViewFromObject(View view, Object object) {
        this.mView = view;
        return (view == (LinearLayout) object);
    }*/

    @Override
    public Fragment getItem(int position) {
        java.util.List<List> data = mWeatherResponse.getList();
        for (List date:data) {
            //Log.d("DtTxt", "run: " + date.getDtTxt().substring(0,10));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = format.format(Calendar.getInstance().getTime());

            if (currentDate == date.getDtTxt().substring(0,10)){
                Log.d("TAG", "getItem: " + "igualessss");
                break;
            }
        }


        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return SunnyFragment.newInstance("", "Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return FogFragment.newInstance("", "Page # 2");
            case 2: // Fragment # 0 - This will show FirstFragment different title
                return CloudyFragment.newInstance("", "Page # 2");
            case 3: // Fragment # 0 - This will show FirstFragment different title
                return ShowerFragment.newInstance("", "Page # 2");
            case 4: // Fragment # 0 - This will show FirstFragment different title
                return StormFragment.newInstance("", "Page # 2");


            default:
                return null;
        }
    }




    /*@Override
    public Object instantiateItem(ViewGroup container, int position) {


        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = mInflater.inflate(R.layout.activity_weather, container, false);


        container.addView(view);

        return view;

    }
*/
    /*@Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }*/
}
