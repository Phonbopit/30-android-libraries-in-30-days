package com.devahoy.learn30androidlibraries.day21;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * AA stand for ActiveAndroid
 */
public class AAApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }
}
