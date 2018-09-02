package com.hfad.vlad.pogodakakiphone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.vlad.pogodakakiphone.adapter.SecondFragAdapter;
import com.hfad.vlad.pogodakakiphone.models.FiveDaysWeatherResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SecondFragment extends Fragment {

    private static final String APPID = "f1ca516628a8d4eeb5801689d85ce55b"; //API Key
    private static final double lat = 55.79;
    private static final double lon = 49.12;

    private final String baseURL = "https://api.openweathermap.org/";

    private Retrofit retrofit;
    private Api api;


//    private List<FiveDaysWeatherResponse> forDateSecond;
//    private List<String> forTempSecond;


    private RecyclerView list_second;

    private List<FiveDaysWeatherResponse> listItems;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        list_second = view.findViewById(R.id.list_second);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        list_second.setLayoutManager(layoutManager);




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
                    SecondFragAdapter secondFragAdapter = new SecondFragAdapter(getActivity(), fiveDaysWeatherResponse.getList());


                    list_second.setAdapter(secondFragAdapter);


//                    double tempFiveDays = fiveDaysWeatherResponse.getList().get(0).getMain().getTemp();
//                    String tempFiveDayss = Double.toString(tempFiveDays);

                }


            }

            @Override
            public void onFailure(Call<FiveDaysWeatherResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return view;
    }

}
