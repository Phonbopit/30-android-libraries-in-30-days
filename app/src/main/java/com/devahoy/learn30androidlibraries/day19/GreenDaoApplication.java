package com.devahoy.learn30androidlibraries.day19;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.devahoy.learn30androidlibraries.DaoMaster;
import com.devahoy.learn30androidlibraries.DaoSession;

public class GreenDaoApplication extends Application {

    DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
    }

    private void setupDatabase() {
        DaoMaster.DevOpenHelper helper =
                new DaoMaster.DevOpenHelper(this, "MyGreenDao.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
