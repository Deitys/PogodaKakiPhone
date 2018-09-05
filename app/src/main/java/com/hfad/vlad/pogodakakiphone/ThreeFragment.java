package com.hfad.vlad.pogodakakiphone;


import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hfad.vlad.pogodakakiphone.EventBus.TempEvent;
import com.hfad.vlad.pogodakakiphone.adapter.ThreeFragAdapter;
import com.hfad.vlad.pogodakakiphone.models.FiveDaysWeatherResponse;

import org.greenrobot.eventbus.Subscribe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ThreeFragment extends Fragment {

    private static final String APPID = "f1ca516628a8d4eeb5801689d85ce55b"; //API Key
    private static double lat;
    private static double lon;

    private final String baseURL = "https://api.openweathermap.org/";

    private Retrofit retrofit;
    private Api api;

    private TextView descriptionDay;
    private TextView sunriseTime;
    private TextView sunsetTime;
    private TextView humidityText;
    private TextView davlenie;
    private TextView cloudsText;
    private RecyclerView list_three;
    private TextView windSpeedText;
    private List<FiveDaysWeatherResponse> listItemsThree;

    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        list_three = view.findViewById(R.id.list_three);
        sunriseTime = view.findViewById(R.id.sunrise_time);
        sunsetTime = view.findViewById(R.id.sunset_time);
        humidityText = view.findViewById(R.id.humidity_text);
        windSpeedText = view.findViewById(R.id.wind_speed_text);
        davlenie = view.findViewById(R.id.davlenie);
        cloudsText = view.findViewById(R.id.clouds_text);


        GPSTracker gpsTracker = new GPSTracker(getActivity().getApplicationContext());
        Location location = gpsTracker.getLocation();
        if (location != null) {
            lat = location.getLatitude();
            lon = location.getLongitude();
        } else  {
            lat = 55.79;
            lon = 49.12;
        }


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        list_three.setLayoutManager(layoutManager);



        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        api.weatherFiveDays(lat, lon, APPID).enqueue(new Callback<FiveDaysWeatherResponse>() {
            @Override
            public void onResponse(Call<FiveDaysWeatherResponse> call, Response<FiveDaysWeatherResponse> response) {
                FiveDaysWeatherResponse fiveDaysWeatherResponse = response.body();
                if (fiveDaysWeatherResponse != null) {
                    ThreeFragAdapter threeFragAdapter = new ThreeFragAdapter(getActivity(), fiveDaysWeatherResponse.getList());
                    list_three.setAdapter(threeFragAdapter);

                }
            }

            @Override
            public void onFailure(Call<FiveDaysWeatherResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

        api.weatherNow(lat, lon, APPID).enqueue(new Callback<CurrentWeatherResponse>() {
            @Override
            public void onResponse(Call<CurrentWeatherResponse> call, Response<CurrentWeatherResponse> response) {
                CurrentWeatherResponse currentWeatherResponse = response.body();
                if (currentWeatherResponse != null) {
                    Date dateSunrise = new Date(currentWeatherResponse.getSys().getSunrise()*1000L + 10800000);
                    Date dateSunset = new Date(currentWeatherResponse.getSys().getSunset()*1000L + 10800000);
                    SimpleDateFormat formatter = new SimpleDateFormat("HH.mm");
                    String formatterSunrise = "Восход солнца:    " + formatter.format(dateSunrise);
                    String formatterSunset = "Заход солнца:    " + formatter.format(dateSunset);
                    sunriseTime.setText(formatterSunrise);
                    sunsetTime.setText(formatterSunset);

                    String mHumidity = "Влажность:    " + Double.toString(currentWeatherResponse.getMain().getHumidity()) + "%";
                    humidityText.setText(mHumidity);

                    String mWindSpeed = "Ветер:    " + Double.toString(currentWeatherResponse.getWind().getSpeed()) + " м/с";
                    windSpeedText.setText(mWindSpeed);

                    Double forPres = currentWeatherResponse.getMain().getPressure() *0.75d;
                    String mDavlenie = "Давление:    " + Double.toString(Math.round(forPres))
                            .substring(0, 3) + " мм рт. ст.";

                    davlenie.setText(mDavlenie);

                    String mClouds = "Облачность:    " + Double.toString(currentWeatherResponse.getClouds().getAll()).substring(0, 1) + " %";
                    cloudsText.setText(mClouds);
                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherResponse> call, Throwable t) {

            }
        });


        return view;
    }

}
