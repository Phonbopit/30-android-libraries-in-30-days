package com.devahoy.learn30androidlibraries.day28;

import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.survivingwithandroid.weather.lib.WeatherClient;
import com.survivingwithandroid.weather.lib.WeatherConfig;
import com.survivingwithandroid.weather.lib.client.volley.WeatherClientDefault;
import com.survivingwithandroid.weather.lib.exception.WeatherLibException;
import com.survivingwithandroid.weather.lib.model.CurrentWeather;
import com.survivingwithandroid.weather.lib.model.DayForecast;
import com.survivingwithandroid.weather.lib.model.Location;
import com.survivingwithandroid.weather.lib.model.Weather;
import com.survivingwithandroid.weather.lib.model.WeatherForecast;
import com.survivingwithandroid.weather.lib.provider.openweathermap.OpenweathermapProviderType;
import com.survivingwithandroid.weather.lib.request.WeatherRequest;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends ListActivity {

    private String TAG = WeatherActivity.class.getSimpleName();

    private WeatherClient mClient;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*        WeatherConfig config = new WeatherConfig();
//        config.ApiKey = "YOUR_API_KEY";*/

        try {
            mClient = new WeatherClient.ClientBuilder()
                    .attach(this)
                    .provider(new OpenweathermapProviderType())
                    .httpClient(WeatherClientDefault.class)
                    .config(new WeatherConfig())
                    .build();

        } catch (Exception e) {
            // Some error
            Log.i(TAG, e.getMessage());
        }

        // YAHOO : Bangkok = 1225448
        // OpenWeatherMap : Bangkok = 1609350
        final WeatherRequest request = new WeatherRequest("1609350");

        mClient.getForecastWeather(request, new WeatherClient.ForecastWeatherEventListener() {
            @Override
            public void onWeatherRetrieved(WeatherForecast weatherForecast) {
                List<String> dataset = new ArrayList<String>();
                List<DayForecast> forecases = weatherForecast.getForecast();
                for (DayForecast forecast : forecases) {
                    String result = forecast.weather.location.getCity() + " : Max: " +
                            Math.round(forecast.forecastTemp.max) + " Min: " +
                            Math.round(forecast.forecastTemp.min) + " Detail: " +
                            forecast.weather.currentCondition.getDescr();
                    dataset.add(result);
                }
                getListView().setBackgroundColor(Color.parseColor("#7e7e7e"));
                getListView().setDividerHeight(2);
                mAdapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, dataset);
                setListAdapter(mAdapter);


            }

            @Override
            public void onWeatherError(WeatherLibException e) {
                Log.e(TAG, e.getMessage());
            }

            @Override
            public void onConnectionError(Throwable throwable) {

            }
        });

        mClient.getCurrentCondition(request, new WeatherClient.WeatherEventListener() {
            @Override
            public void onWeatherRetrieved(CurrentWeather cWeather) {
                Weather weather = cWeather.weather;

                Location location = weather.location;
                Weather.Temperature temperature = weather.temperature;

                Log.i(TAG, "City : " + location.getCity() +
                        " Country : " + location.getCountry());
                Log.i(TAG, "Temp : " + temperature.getTemp());

            }

            @Override
            public void onWeatherError(WeatherLibException t) {

            }

            @Override
            public void onConnectionError(Throwable t) {

            }
        });

    }
}
