package com.devahoy.learn30androidlibraries.day2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.devahoy.learn30androidlibraries.R;

import uk.co.chrisjenx.paralloid.views.ParallaxScrollView;

/**
 * Created by phonbopit on 7/10/14.
 */
public class ParallaxBackgroundActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day2_parallax_background);
        ParallaxScrollView scrollView = (ParallaxScrollView) findViewById(R.id.scroll_view);
        scrollView.parallaxViewBackgroundBy(scrollView, getResources().getDrawable(R.drawable.day2_example_image), .2f);
    }
}
