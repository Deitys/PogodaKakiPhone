package com.hfad.vlad.pogodakakiphone;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.vlad.pogodakakiphone.EventBus.TempEvent;
import com.hfad.vlad.pogodakakiphone.descriptions.WeatherDescription;
import com.hfad.vlad.pogodakakiphone.models.FiveDaysWeatherResponse;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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


    private List<FiveDaysWeatherResponse> forDateSecond;
    private List<String> forTempSecond;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        TempEvent tempEvent = new TempEvent();


        FirstFragment firstFragment = new FirstFragment();
        SecondFragment secondFragment = new SecondFragment();
        ThreeFragment threeFragment = new ThreeFragment();
        TempEvent event = new TempEvent();


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_fragment, firstFragment).commit();
        fragmentManager.beginTransaction().replace(R.id.second_fragment, secondFragment).commit();
        fragmentManager.beginTransaction().replace(R.id.three_fragment, threeFragment).commit();




        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        api.weatherNow(lat, lon, APPID).enqueue(new Callback<CurrentWeatherResponse>() {
            @Override
            public void onResponse(Call<CurrentWeatherResponse> call, Response<CurrentWeatherResponse> response) {
                CurrentWeatherResponse currentWeatherResponse = response.body();
                if (currentWeatherResponse != null) {
                    List<WeatherDescription> weatherDescriptionList = currentWeatherResponse.getWeather();
                    TextView descriptionFirst = findViewById(R.id.descriptionFirst);
                    String descriptionFirstUpperCase = weatherDescriptionList.get(0).getDescription();
                    String descriptionFirstUpper = descriptionFirstUpperCase.substring(0, 1)
                            .toUpperCase() + descriptionFirstUpperCase.substring(1);

                    switch (descriptionFirstUpper) {
                        case "Light rain": descriptionFirstUpper = "Небольшой дождь";
                            break;
                        case "Broken clouds": descriptionFirstUpper = "Преимущественно солнечно";
                            break;
                        case "Clear sky": descriptionFirstUpper = "Чистое небо";
                        break;
                    }

                    descriptionFirst.setText(descriptionFirstUpper);



                    TextView cityFirst = findViewById(R.id.cityFirst);
                    String nameCity = currentWeatherResponse.getName();
                    if(nameCity.equals("Kazan"))
                        nameCity = "Казань";
                    cityFirst.setText(nameCity);

                    TextView tempFirst = findViewById(R.id.tempFirst);
                    String temp = Double.toString(Math.round(currentWeatherResponse.getMain().getTemp() - 273));
                    String gradus = "\u00B0";
                    String tempF = temp.substring(0, temp.length() - 2);
                    tempFirst.setText(" "+ tempF + gradus);

                    TextView textDay = findViewById(R.id.textDay);
                    Date date = new Date(currentWeatherResponse.getDt()*1000L);
                    SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
                    String dateF = formatter.format(date);

                    switch (dateF) {
                        case "Monday": dateF = "Понедельник";
                        break;
                        case "Tuesday": dateF = "Вторник";
                        break;
                        case "Wednesday": dateF = "Среда";
                        break;
                        case "Thursday": dateF = "Четверг";
                        break;
                        case "Friday": dateF = "Пятница";
                        break;
                        case "Saturday": dateF = "Суббота";
                        break;
                        case "Sunday": dateF = "Воскресенье";
                        break;

                    }


                    dateF = dateF.substring(0, 1).toUpperCase() + dateF.substring(1);

                    textDay.setText(dateF);


                    ImageView backgroundImage = findViewById(R.id.background_image);
                    String mainForBack = currentWeatherResponse.getWeather().get(0).getMain();
                    switch (mainForBack) {
                        case "Clear": backgroundImage.setBackgroundResource(R.drawable.backgroundclear);
                        break;
                        case "Clouds": backgroundImage.setBackgroundResource(R.drawable.backgroundclouds);
                            break;
                        case "Rain": backgroundImage.setBackgroundResource(R.drawable.backgroundrain);
                            break;
                        case "Mist": backgroundImage.setBackgroundResource(R.drawable.backgroundmist);
                        break;
                        default: backgroundImage.setBackgroundResource(R.drawable.backgroundclear);
                            break;
                    }

                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });




    }

    @Subscribe
    public void onEvent(TempEvent event){
        TextView tempMaxSeg = findViewById(R.id.tempMaxSeg);
        TextView tempMinSeg = findViewById(R.id.tempMinSeg);
        TextView descriptionDay = findViewById(R.id.descriptionDay);

        ArrayList<Double> vseTempMax =  event.getMaxTempEvent();
        ArrayList<Double> vseTempMin = event.getMinTempEvent();
        String checkDay = event.getCheckDayEvent();
        String forDescriptionDay = event.getDescriptionDayEvent();
        ArrayList<String> allDay = event.getAllDayEvent();

        int countDay = 0;
        while (checkDay.equals(allDay.get(countDay))) {
            countDay++;
        }

        while (vseTempMax.size() > countDay) {
            vseTempMax.remove(vseTempMax.size()- 1);
        }
        while (vseTempMin.size() > countDay) {
            vseTempMin.remove(vseTempMin.size()-1);
        }

        double mTempMax;
        if (vseTempMax.size() > 1) {
            mTempMax = Collections.max(vseTempMax);
        } else {
            mTempMax = vseTempMax.get(0);
        }

        double mTempMin;
        if (vseTempMin.size() > 1) {
            mTempMin = Collections.min(vseTempMin);
        } else {
            mTempMin = vseTempMin.get(0);
        }


        String tempMaxSegF = Double.toString(Math.round(mTempMax - 273)).substring(0, 2);
        tempMaxSeg.setText(tempMaxSegF);


        String tempMinSegF = Double.toString(Math.round(mTempMin - 273)).substring(0, 2);
        tempMinSeg.setText(tempMinSegF);


        switch (forDescriptionDay) {
            case "light rain": forDescriptionDay = "небольшой дождь";
            break;
            case "broken clouds": forDescriptionDay = "преимущественно солнечно";
            break;
        }

        String gradus = "\u00B0";
        String tochka = ".";
        String descriptioner = "Сегодня: Сейчас " + forDescriptionDay
                + ". Максимальная температура воздуха " + tempMaxSegF + gradus
                + ". Сегодня ночью минимальная температура воздуха " + tempMinSegF + gradus + tochka;


        descriptionDay.setText(descriptioner);

    }
}
