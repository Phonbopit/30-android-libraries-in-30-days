package com.devahoy.learn30androidlibraries.day30;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by phonbopit on 8/7/14.
 */
public class FireBaseActivity extends ActionBarActivity {

    private static final String AHOY_CHAT_URL = "https://ahoychat.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firebase firebase = new Firebase(AHOY_CHAT_URL).child("chat");

        firebase.push().setValue("test");



        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
