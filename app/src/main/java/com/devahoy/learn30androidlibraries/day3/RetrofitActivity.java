package com.devahoy.learn30androidlibraries.day3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.devahoy.learn30androidlibraries.R;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RetrofitActivity extends ActionBarActivity {

    private static final String TAG = RetrofitActivity.class.getSimpleName();

    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.day3_activity_retrofit);
        mGridView = (GridView) findViewById(R.id.gridview);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.dribbble.com")
                .build();

        SimpleRetrofit retrofit = restAdapter.create(SimpleRetrofit.class);

        retrofit.getShotsByPopular(new Callback<ShotList>() {
            @Override
            public void success(ShotList shots, Response response) {
                mGridView.setAdapter(new GridAdapter(RetrofitActivity.this, shots));
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(),
                        error.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });


/*        retrofit.getShotByIdWithCallback(21603, new Callback<Shot>() {
            @Override
            public void success(Shot shot, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });*/


        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(RetrofitActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

//        new HttpAsyncTask().execute();
    }

    public class HttpAsyncTask extends AsyncTask<Void, Void, Shot> {
        @Override
        protected Shot doInBackground(Void... params) {

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://api.dribbble.com")
                    .build();

            SimpleRetrofit retrofit = restAdapter.create(SimpleRetrofit.class);
//            Shot shot = retrofit.getShot();

            Shot shot = retrofit.getShotById(30000);

            return shot;
        }

        @Override
        protected void onPostExecute(Shot shot) {

            Toast.makeText(getApplicationContext(),
                    "Name : " + shot.getTitle() + " URL : " + shot.getUrl(),
                    Toast.LENGTH_LONG).show();
            super.onPostExecute(shot);
        }
    }
}
