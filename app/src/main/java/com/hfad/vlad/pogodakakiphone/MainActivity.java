package com.hfad.vlad.pogodakakiphone;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hfad.vlad.pogodakakiphone.models.CityResponse;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String APPID = "f1ca516628a8d4eeb5801689d85ce55b"; //API Key
    private static final double lat = 55.79;
    private static final double lon = 49.12;

    private final String baseURL = "https://api.openweathermap.org/";

    private Retrofit retrofit;
    private Api api;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FirstFragment firstFragment = new FirstFragment();


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_fragment, firstFragment).commit();


        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        api.city(lat, lon, APPID).enqueue(new Callback<CurrentWeatherResponse>() {
            @Override
            public void onResponse(Call<CurrentWeatherResponse> call, Response<CurrentWeatherResponse> response) {
                CurrentWeatherResponse currentWeatherResponse = (CurrentWeatherResponse) response.body().getWeather();
                System.out.println(currentWeatherResponse);

            }

            @Override
            public void onFailure(Call<CurrentWeatherResponse> call, Throwable t) {

                t.printStackTrace();
            }
        });
}
}
