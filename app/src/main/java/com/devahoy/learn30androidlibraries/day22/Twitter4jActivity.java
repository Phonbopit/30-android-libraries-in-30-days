package com.devahoy.learn30androidlibraries.day22;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.devahoy.learn30androidlibraries.R;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Twitter4jActivity extends ActionBarActivity {

    private static final String TAG = Twitter4jActivity.class.getSimpleName();

    private static final String API_KEY = "YOUR_API_KEY";
    private static final String API_SECRET = "YOUR_SECRET_KEY";
    private static final String ACCESS_TOKEN = "YOUR_ACCESS_TOKEN";
    private static final String ACCESS_TOKEN_SECRET = "YOUR_ACCESS_TOKEN_SECRET";

    private EditText mTweet;
    private Button mButtonTweet;
    private ListView mListView;
    private ArrayList<String> mTimelines = new ArrayList<String>();

    private TwitterFactory mFactory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day22_activity_twitter4j);

        mTweet = (EditText) findViewById(R.id.text_tweet);
        mButtonTweet = (Button) findViewById(R.id.button_tweet);
        mListView = (ListView) findViewById(R.id.list_view);

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(API_KEY)
                .setOAuthConsumerSecret(API_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
        mFactory = new TwitterFactory(cb.build());

        new AsyncTimeline().execute();

        mButtonTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTweet().execute();
            }
        });
    }

    private class AsyncTimeline extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {

            Twitter twitter = mFactory.getInstance();
            String result = null;
            try {
                List<twitter4j.Status> statuses = twitter.getHomeTimeline();
                for (twitter4j.Status status : statuses) {
                    mTimelines.add(status.getUser().getName() + " : " +
                            status.getText());
                }

            } catch (TwitterException e) {
                Log.d(TAG, e.toString());
                result = e.getErrorMessage();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s == null) {
                ArrayAdapter<String> adapter =
                        new ArrayAdapter<String>(Twitter4jActivity.this,
                                android.R.layout.simple_list_item_1, mTimelines);

                mListView.setAdapter(adapter);
            }
        }
    }
    private class AsyncTweet extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {

            String result = null;
            String tweet = " via @Devahoy";
            Twitter twitter = mFactory.getInstance();
            try {
                twitter.updateStatus(mTweet.getText().toString() + tweet);
            } catch (TwitterException e) {
                Log.d(TAG, e.toString());
                result = e.getErrorMessage();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result == null) {
                Toast.makeText(Twitter4jActivity.this, "Tweeted!", Toast.LENGTH_LONG).show();
                mTweet.setText("");
            }

        }
    }
}
