package com.devahoy.learn30androidlibraries.day17;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.devahoy.learn30androidlibraries.R;
import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;

import java.util.ArrayList;

public class SwipeListViewActivity extends ActionBarActivity {

    SwipeListView mSwipeListView;
    private ArrayList<Website> mWebsites;
    private WebsiteAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.day17_activity_swipe_listview);
        mSwipeListView = (SwipeListView) findViewById(R.id.list_view);

        initSampleData();


        mSwipeListView.setSwipeListViewListener(new BaseSwipeListViewListener() {
            @Override
            public void onDismiss(int[] reverseSortedPositions) {
                for (int position : reverseSortedPositions) {
                    Website website = mWebsites.get(position);

                    mWebsites.remove(position);
                    mWebsites.add(website);
                }

                mAdapter.notifyDataSetChanged();
            }


        });

    }

    private void initSampleData() {
        Website akexorcist = new Website("Sleeping For Less",
                "http://www.akexorcist.com/",
                R.drawable.akexorcist);

        Website androidthai = new Website("ทุกๆเรื่อง ที่เกี่ยวกับ android โดย มาสเตอร์ อึ่ง",
                "http://www.androidthai.in.th/",
                R.drawable.androidthai);

        Website android4health = new Website("android4health",
                "http://android4health.wordpress.com/",
                R.drawable.android4health);

        Website martoutine = new Website("Mart Tanathip | Simple routine of me",
                "http://www.martroutine.com",
                R.drawable.martroutine);

        Website nuuneoi = new Website("NuuNeoI : Personal Blog of a little full stack developer guy",
                "http://nuuneoi.com",
                R.drawable.nuuneoi);

        Website devahoy = new Website("Devahoy",
                "http://devahoy.com",
                R.drawable.devahoy);

        mWebsites = new ArrayList<Website>();
        mWebsites.add(akexorcist);
        mWebsites.add(androidthai);
        mWebsites.add(android4health);
        mWebsites.add(martoutine);
        mWebsites.add(nuuneoi);
        mWebsites.add(devahoy);

        mAdapter = new WebsiteAdapter(this, mWebsites);
        mSwipeListView.setAdapter(mAdapter);
    }
}
