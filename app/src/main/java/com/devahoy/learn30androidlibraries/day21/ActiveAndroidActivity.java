package com.devahoy.learn30androidlibraries.day21;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ListView;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.devahoy.learn30androidlibraries.R;

import java.util.List;

public class ActiveAndroidActivity extends ActionBarActivity {

    private ListView mListView;
    private AAAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day21_activity_active_android);

        mListView = (ListView) findViewById(R.id.list_view);

        List<Book> books = AAHelper.findBooks();

        mAdapter = new AAAdapter(this, books);
        mListView.setAdapter(mAdapter);

        mListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initSampleData() {
        new Delete().from(Book.class).execute();

        ActiveAndroid.beginTransaction();

        try {
            Book book1 = new Book("Android Cookbook",
                    "Ian F. Darwin",
                    "O'Reilly Media" ,
                    "April 2012");
            book1.save();

            Book book2 = new Book("Android Recipes, 3rd Edition",
                    "Dave Smith , Jeff Friesen",
                    "Apress",
                    "February 2014");
            book2.save();

            Book book3 = new Book("Expert Android",
                    "Satya Komatineni, Dave MacLean",
                    "Apress",
                    "July 2013");
            book3.save();

            Book book4 = new Book("50 Android Hacks",
                    "Carlos Sessa",
                    "Manning Publications",
                    "May 2013");
            book4.save();

            Book book5 = new Book("Learn Java for Android Development, 3rd Edition",
                    "Jeff Friesen",
                    "Apress",
                    "March 2014");
            book5.save();

            Book book6 = new Book("Learning Android, 2nd Edition",
                    "Marko Gargenta, Masumi Nakamura",
                    "O'Reilly Media, Inc.",
                    "January 2014");
            book6.save();
        } finally {
            ActiveAndroid.setTransactionSuccessful();
        }

        ActiveAndroid.endTransaction();
    }
}
