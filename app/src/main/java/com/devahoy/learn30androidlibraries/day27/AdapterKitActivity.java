package com.devahoy.learn30androidlibraries.day27;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.devahoy.learn30androidlibraries.R;
import com.mobsandgeeks.adapters.CircularListAdapter;
import com.mobsandgeeks.adapters.InstantAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterKitActivity extends ActionBarActivity {

    private List<Player> mPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day27_activity_adapter_kit);

        ListView listView = (ListView) findViewById(R.id.list_view);

        initData();

        InstantAdapter adapter = new InstantAdapter(
                this,
                R.layout.day27_list_item,
                Player.class,
                mPlayers);

        CircularListAdapter circularListAdapter = new CircularListAdapter(adapter);
        listView.setAdapter(new CircularListAdapter(adapter));
    }

    private void initData() {

        mPlayers = new ArrayList<Player>();

        mPlayers.add(new Player("Leonel Messi", "Barcelona"));
        mPlayers.add(new Player("Cristiano Ronaldo", "Real Madrid"));
        mPlayers.add(new Player("Teerasil Dangda", "UD Almeria"));
        mPlayers.add(new Player("Steven Gerrard", "Liverpool"));
        mPlayers.add(new Player("Arjen Robben", "Bayern"));
        mPlayers.add(new Player("Wayne Rooney", "Man Utd"));
        mPlayers.add(new Player("Sergio Aguero", "Man City"));
        mPlayers.add(new Player("Eden Hazard", "Chelsea"));
        mPlayers.add(new Player("Pipop On-Mo", "Chonburi FC"));
        mPlayers.add(new Player("Carmero Gonzalez", "Buriram Utd"));
    }
}
