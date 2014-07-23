package com.devahoy.learn30androidlibraries.day15;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.devahoy.learn30androidlibraries.R;
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;

public class FadingActionBarActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FadingActionBarHelper helper = new FadingActionBarHelper();
        helper.actionBarBackground(R.drawable.day15_actionbar_bg);
        helper.headerLayout(R.layout.day15_header);
        helper.contentLayout(R.layout.day15_activity_scrollview);

        setContentView(helper.createView(this));
        helper.initActionBar(this);
    }
}
