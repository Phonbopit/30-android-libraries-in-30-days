package com.devahoy.learn30androidlibraries.day7;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.devahoy.learn30androidlibraries.R;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

public class AndroidAsyncActivity extends ActionBarActivity {

    private TextView mText;

    // Check correct url at
    // http://runnable.com/U7bnCsACcG8MGzEc/restful-api-with-node-js-express-4
    private final String URL =
            "http://web-60388f0d-d0d6-4b9a-bcf8-61d0507ea2b9.runnable.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Crashlytics.start(this);
        setContentView(R.layout.day7_activity_async);

        mText = (TextView) findViewById(R.id.text);

        final Gson gson = new Gson();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL  + "/api/players", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
//                    mText.setText(new String(responseBody));
                    StringBuilder result = new StringBuilder();

                    Players players = gson.fromJson(new String(responseBody),
                            Players.class);

                    for (Player player : players.getPlayers()) {
                        result.append("Name: " + player.getName() + "\n");
                        result.append("Age : " + player.getAge() + "\n");
                        result.append("Club : " + player.getClub() + "\n");
                        result.append("National : " + player.getNational() + "\n");
                        result.append("================\n");
                    }

                    mText.setText(result);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }


    

}
