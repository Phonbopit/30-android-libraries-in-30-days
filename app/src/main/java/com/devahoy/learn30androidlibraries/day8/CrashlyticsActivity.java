package com.devahoy.learn30androidlibraries.day8;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import com.devahoy.learn30androidlibraries.R;

public class CrashlyticsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day8_activity_crashlytics);

        Crashlytics.start(this);

        Crashlytics.log("Hello initial Crashlytics");

        Button button = null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // always NPE.
            }
        });
    }
}
