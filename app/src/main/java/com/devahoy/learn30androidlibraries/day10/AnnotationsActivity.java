package com.devahoy.learn30androidlibraries.day10;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.devahoy.learn30androidlibraries.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.day10_activity_annotations)
public class AnnotationsActivity extends ActionBarActivity {

    @ViewById(R.id.greeting)
    TextView greeting;

    @ViewById
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Click(R.id.button_click)
    void onClick() {
        Toast.makeText(this, "Hello " ,Toast.LENGTH_LONG).show();
    }

    @AfterViews
    void setGreeting() {
        greeting.setText("Hello I'm John Doe");
    }
}