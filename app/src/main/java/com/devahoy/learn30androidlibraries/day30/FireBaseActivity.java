package com.devahoy.learn30androidlibraries.day30;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.devahoy.learn30androidlibraries.R;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FireBaseActivity extends ActionBarActivity {

    private static final String AHOY_CHAT_URL = "https://ahoychat.firebaseio.com";
    private List<String> mChats = new ArrayList<String>();
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private ImageButton mButtonSend;
    private EditText mMessage;

    private Firebase mFirebase;
    private String mUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Random r = new Random();
        mUsername = "AhoyUser" + r.nextInt(1000);

        setContentView(R.layout.day30_activity_firebase);

        mButtonSend = (ImageButton) findViewById(R.id.button_send);
        mMessage = (EditText) findViewById(R.id.message);
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setBackgroundColor(Color.parseColor("#26B895"));

        mFirebase = new Firebase(AHOY_CHAT_URL).child("chat");

        queryData();

        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
//        Chat chat = new Chat(mMessage.getText().toString(), mUsername);

        Map<String, Object> chat = new HashMap<String, Object>();
        chat.put("owner", mUsername);
        chat.put("message", mMessage.getText().toString());

        mFirebase.push().setValue(chat);
        mMessage.setText("");
    }

    private void queryData() {
        Query query = mFirebase.limit(10);

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map<String, Object> newPost = (Map<String, Object>) dataSnapshot.getValue();
                String owner = newPost.get("owner").toString();
                String message = newPost.get("message").toString();

                mChats.add(0, owner + " Say: " + message);

                if (mAdapter == null) {

                    mAdapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_list_item_1, mChats);

                    mListView.setAdapter(mAdapter);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
