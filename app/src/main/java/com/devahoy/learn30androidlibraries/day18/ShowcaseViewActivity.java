package com.devahoy.learn30androidlibraries.day18;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.devahoy.learn30androidlibraries.R;
import com.github.amlcurran.showcaseview.ShowcaseView;

public class ShowcaseViewActivity extends ActionBarActivity {

    private TextView mStep1, mStep2, mStep3;
    private ShowcaseView mShowcaseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day18_activity_showcaseview);
    }
}
