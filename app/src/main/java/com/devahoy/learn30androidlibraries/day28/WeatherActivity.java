package com.devahoy.learn30androidlibraries.day28;

import android.app.ListActivity;
import android.os.Bundle;

import com.survivingwithandroid.weather.lib.WeatherClient;
import com.survivingwithandroid.weather.lib.WeatherConfig;
import com.survivingwithandroid.weather.lib.client.okhttp.WeatherDefaultClient;
import com.survivingwithandroid.weather.lib.exception.WeatherLibException;
import com.survivingwithandroid.weather.lib.model.CurrentWeather;
import com.survivingwithandroid.weather.lib.model.Location;
import com.survivingwithandroid.weather.lib.model.Weather;
import com.survivingwithandroid.weather.lib.provider.openweathermap.OpenweathermapProviderType;
import com.survivingwithandroid.weather.lib.request.WeatherRequest;

public class WeatherActivity extends ListActivity {

    private String TAG = WeatherActivity.class.getSimpleName();

    private WeatherClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WeatherClient.ClientBuilder builder = new WeatherClient.ClientBuilder();

        WeatherConfig config = new WeatherConfig();
        config.ApiKey = "YOUR_API_KEY";

        try {
            mClient = builder.attach(this)
                    .provider(new OpenweathermapProviderType())
                    .httpClient(WeatherDefaultClient.class)
                    .config(config)
                    .build();
        } catch (Exception e) {
            // Some error
        }

        final WeatherRequest request = new WeatherRequest("Bangkok");

        mClient.getCurrentCondition(request, new WeatherClient.WeatherEventListener() {
            @Override
            public void onWeatherRetrieved(CurrentWeather currentWeather) {
                Weather weather = currentWeather.weather;

                Location location = weather.location;
                Weather.Temperature temperature = weather.temperature;
                Weather.Condition condition = weather.currentCondition;
                // Do what you want..

            }

            @Override
            public void onWeatherError(WeatherLibException e) {

            }

            @Override
            public void onConnectionError(Throwable throwable) {

            }
        });

    }
}
