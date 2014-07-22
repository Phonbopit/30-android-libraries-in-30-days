package com.devahoy.learn30androidlibraries.day14;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.devahoy.learn30androidlibraries.R;
import com.viewpagerindicator.TitlePageIndicator;

public class ViewPagerIndicatorActivity extends ActionBarActivity {

    private TitlePageIndicator mTitlePageIndicator;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day14_activity_viewpager_indicator);
    }
}
