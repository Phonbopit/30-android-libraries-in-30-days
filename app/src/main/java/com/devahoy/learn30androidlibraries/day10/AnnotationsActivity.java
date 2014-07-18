package com.devahoy.learn30androidlibraries.day10;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.devahoy.learn30androidlibraries.R;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.day10_activity_annotations)
public class AnnotationsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
