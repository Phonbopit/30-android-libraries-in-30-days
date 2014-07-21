package com.devahoy.learn30androidlibraries.day13;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.devahoy.learn30androidlibraries.R;

public class ViewPagerActivity extends ActionBarActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        setContentView(R.layout.day13_activity_viewpager);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

        for (int i = 0; i < SimplePagerAdapter.NUM_PAGES; i++) {
            actionBar.addTab(actionBar.newTab()
                            .setText("Tab #" + i)
                            .setTabListener(tabListener));
        }

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                getActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private ActionBar.TabListener tabListener = new ActionBar.TabListener() {
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            mViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    };
}
