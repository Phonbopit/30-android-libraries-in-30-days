package com.devahoy.learn30androidlibraries.day12;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.dd.CircularProgressButton;
import com.devahoy.learn30androidlibraries.R;

public class CircularActivity extends ActionBarActivity {

    CircularProgressButton mCircularButtonSimple;
    CircularProgressButton mCircularButtonComplete;
    CircularProgressButton mCircularButtonError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day12_activity_circular);

        mCircularButtonSimple = (CircularProgressButton)
                findViewById(R.id.circular_button_simple);
        mCircularButtonComplete = (CircularProgressButton)
                findViewById(R.id.circular_button_complete);
        mCircularButtonError = (CircularProgressButton)
                findViewById(R.id.circular_button_error);

        mCircularButtonSimple.setIndeterminateProgressMode(true);
        mCircularButtonSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCircularButtonSimple.getProgress() == 0) {
                    mCircularButtonSimple.setProgress(50);
                } else if (mCircularButtonSimple.getProgress() == 100) {
                    mCircularButtonSimple.setProgress(0);
                } else {
                    mCircularButtonSimple.setProgress(100);
                }
            }
        });

        mCircularButtonComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCircularButtonComplete.getProgress() == 0) {
                    simulateSuccessProgress(mCircularButtonComplete);
                } else {
                    mCircularButtonComplete.setProgress(0);
                }
            }
        });
        mCircularButtonError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCircularButtonError.getProgress() == 0) {
                    simulateErrorProgress(mCircularButtonError);
                } else {
                    mCircularButtonError.setProgress(0);
                }
            }
        });
    }

    private void simulateSuccessProgress(final CircularProgressButton button) {
        ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 100);
        widthAnimation.setDuration(1500);
        widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                button.setProgress(value);
            }
        });
        widthAnimation.start();
    }
    private void simulateErrorProgress(final CircularProgressButton button) {
        ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 99);
        widthAnimation.setDuration(1500);
        widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                button.setProgress(value);
                if (value == 99) {
                    button.setProgress(-1);
                }
            }
        });
        widthAnimation.start();
    }
}
