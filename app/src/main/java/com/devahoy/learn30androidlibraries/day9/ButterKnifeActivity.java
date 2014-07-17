package com.devahoy.learn30androidlibraries.day9;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.devahoy.learn30androidlibraries.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnClick;

public class ButterKnifeActivity extends ActionBarActivity {

    @InjectView(R.id.greeting)
    TextView mGreeting;

    @InjectView(R.id.name)
    TextView mName;

    @InjectView(R.id.button_click)
    Button mButtonClick;

    @InjectViews({R.id.greeting, R.id.name})
    List<TextView> mTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.day9_activity_butter_knife);

        // Normal
        TextView greeting = (TextView) findViewById(R.id.greeting);
        TextView name = (TextView) findViewById(R.id.name);
        Button buttonClick = (Button) findViewById(R.id.button_click);

        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sayHello();
            }
        });


        // Butter Knife
        ButterKnife.inject(this);

        mGreeting.setText("Hello World");
        mName.setText("John Doe");

        // Multiple Inject
/*        mTextViews.get(0).setText("Hello");
        mTextViews.get(1).setText("Jane Doe");*/

        // findById
/*        TextView textView = ButterKnife.findById(this, R.id.greeting);
        Button button = ButterKnife.findById(this, R.id.button_click);*/
    }

    @OnClick(R.id.button_click)
    public void sayHello() {
        Toast.makeText(this, mGreeting.getText().toString() + " I'm " +
                mName.getText().toString(), Toast.LENGTH_LONG).show();
    }
}
