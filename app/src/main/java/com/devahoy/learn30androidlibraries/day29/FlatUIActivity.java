package com.devahoy.learn30androidlibraries.day29;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.cengalabs.flatui.FlatUI;
import com.cengalabs.flatui.views.FlatToggleButton;
import com.devahoy.learn30androidlibraries.R;

public class FlatUIActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FlatUI.initDefaultValues(this);
//        FlatUI.setDefaultTheme(FlatUI.SEA);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(FlatUI.getActionBarDrawable(this, FlatUI.GRASS, false));

        setContentView(R.layout.day29_activity_flatui);

        FlatToggleButton toggleButton = (FlatToggleButton) findViewById(R.id.toggle_button);
        toggleButton.getAttributes().setTheme(FlatUI.BLOSSOM, getResources());
    }
}
