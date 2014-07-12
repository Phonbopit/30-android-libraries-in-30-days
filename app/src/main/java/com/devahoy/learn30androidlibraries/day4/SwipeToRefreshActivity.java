package com.devahoy.learn30androidlibraries.day4;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.devahoy.learn30androidlibraries.R;

import java.util.ArrayList;
import java.util.Random;

public class SwipeToRefreshActivity extends ActionBarActivity {

    private SwipeRefreshLayout mSwipeRefresh;
    private ListView mListView;
    private ArrayAdapter<String> mSimpleAdapter;

    private ArrayList<String> mData = new ArrayList<String>();
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day4_activity_swipe_to_refresh);

        mSwipeRefresh = (SwipeRefreshLayout)
                findViewById(R.id.swipe_refresh_layout);
        mListView = (ListView) findViewById(R.id.list_view);

        initSampleData();

        mSimpleAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, mData);

        mListView.setAdapter(mSimpleAdapter);

        mSwipeRefresh.setColorSchemeColors(Color.parseColor("#4183D7"),
                Color.parseColor("#F62459"),
                Color.parseColor("#03C9A9"),
                Color.parseColor("#F4D03F"));

        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {

                        mSimpleAdapter.clear();

                        initSampleData();

                        mSimpleAdapter.notifyDataSetChanged();

                        mSwipeRefresh.setRefreshing(false);
                    }
                }, 5000);
            }
        });
    }

    private void initSampleData() {
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(lorems.length);
            mData.add(lorems[index]);
        }
    }
    private String[] lorems = new String[] {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
            "Vivamus fringilla adipiscing neque, a lacinia metus pretium et",
            "Donec quam justo, vehicula ut mauris vel, luctus cursus libero",
            "Pellentesque ac fermentum augue, id congue tortor.",
            "Proin mattis ac nibh vitae volutpat. Pellentesque commodo eros quis enim tempus",
            "Fusce sagittis orci sit amet magna tempus, ut dignissim urna malesuada",
            "Quisque sit amet libero volutpat velit euismod sollicitudin.",
            "Interdum et malesuada fames ac ante ipsum primis in faucibus",
            "Cras sagittis rutrum ipsum, eget elementum arcu bibendum vitae",
            "Sed laoreet dignissim purus, ac vehicula eros lobortis id. Curabitur i",
            "egestas non arcu. Quisque placerat vulputate magna",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
            "Praesent lacinia pellentesque sapien",
    };
}
