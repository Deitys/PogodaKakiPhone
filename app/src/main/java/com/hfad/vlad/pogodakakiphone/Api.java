package com.hfad.vlad.pogodakakiphone;

import com.hfad.vlad.pogodakakiphone.models.CityResponse;
import com.hfad.vlad.pogodakakiphone.models.FiveDaysWeatherResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("data/2.5/weather")
    Call<CurrentWeatherResponse> weatherNow(@Query("lat") double lat, @Query("lon") double lon, @Query("APPID") String APPID);

    @GET("https://api.openweathermap.org/data/2.5/forecast")
    Call<FiveDaysWeatherResponse> weatherFiveDays (@Query("lat") double lat, @Query("lon") double lon, @Query("APPID") String APPID);
}
