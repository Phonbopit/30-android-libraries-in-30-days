package com.devahoy.learn30androidlibraries.day21;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;

import java.util.ArrayList;
import java.util.List;

public class ActiveAndroidActivity extends ListActivity {

    private List<Book> mBooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initSampleData();
        mBooks = AAHelper.findBooks();

        StringBuilder builder = new StringBuilder();
        ArrayList<String> dataset = new ArrayList<String>();
        for (Book book : mBooks) {
            builder.setLength(0);
            builder.append("Name : " + book.title + "\n");
            builder.append("By   : " + book.author + "\n");
            builder.append("Publisher : " + book.publisher + "\n");
            builder.append("Release Date : " + book.releaseDate + "\n");
            dataset.add(builder.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dataset);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Book book = AAHelper.findBookById(mBooks.get(position).getId());
        Toast.makeText(this, "You choose " + book.title, Toast.LENGTH_SHORT).show();
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
