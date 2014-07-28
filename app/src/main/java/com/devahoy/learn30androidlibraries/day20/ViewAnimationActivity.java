package com.devahoy.learn30androidlibraries.day20;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.devahoy.learn30androidlibraries.R;

import java.util.Random;

public class ViewAnimationActivity extends ActionBarActivity {

    private Button mButton;
    Random mRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day20_activity_view_animation);
        mButton = (Button) findViewById(R.id.button_animate);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomAnimation();
            }
        });
    }

    private void randomAnimation() {
        int gen = mRandom.nextInt(5);
        switch (gen) {
            case 0:
                YoYo.with(Techniques.Flash).duration(1000).playOn(mButton);
                break;
            case 1:
                YoYo.with(Techniques.Shake).duration(1000).playOn(mButton);
                break;
            case 2:
                YoYo.with(Techniques.FadeInUp).duration(1000).playOn(mButton);
                break;
            case 3:
                YoYo.with(Techniques.RotateIn).duration(1000).playOn(mButton);
                break;
            case 4:
                YoYo.with(Techniques.Wave).duration(1000).playOn(mButton);
                break;
            default:
                YoYo.with(Techniques.Tada).duration(1000).playOn(mButton);
                break;
        }
    }
}
