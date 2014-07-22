package com.devahoy.learn30androidlibraries.day14;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.devahoy.learn30androidlibraries.R;
import com.devahoy.learn30androidlibraries.day13.SimplePagerAdapter;
import com.viewpagerindicator.TitlePageIndicator;

public class ViewPagerIndicatorActivity extends ActionBarActivity {

    private TitlePageIndicator mTitlePageIndicator;
//    private LinePageIndicator mLinePageIndicator;
//    private CirclePageIndicator mCirclePageIndicator;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day14_activity_viewpager_titlepage);
//        setContentView(R.layout.day14_activity_viewpager_line);
//        setContentView(R.layout.day14_activity_viewpager_circle);

        mViewPager = (ViewPager) findViewById(R.id.pager);

        mTitlePageIndicator = (TitlePageIndicator) findViewById(R.id.titles);
//        mLinePageIndicator = (LinePageIndicator) findViewById(R.id.indicator);
//        mCirclePageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);

        SimplePagerAdapter adapter =
                new SimplePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

        mTitlePageIndicator.setViewPager(mViewPager);
//        mLinePageIndicator.setViewPager(mViewPager);
//        mCirclePageIndicator.setViewPager(mViewPager);
    }

}
