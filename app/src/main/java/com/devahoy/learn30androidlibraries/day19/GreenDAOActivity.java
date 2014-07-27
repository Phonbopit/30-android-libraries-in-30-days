package com.devahoy.learn30androidlibraries.day19;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.devahoy.learn30androidlibraries.DaoSession;
import com.devahoy.learn30androidlibraries.Player;
import com.devahoy.learn30androidlibraries.PlayerDao;

import java.util.ArrayList;
import java.util.List;

public class GreenDAOActivity extends ListActivity {

    GreenDaoApplication mApplication;
    DaoSession mDaoSession;
    PlayerDao mPlayerDao;
    ArrayList<String> mDataset = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApplication = (GreenDaoApplication) getApplication();
        mDaoSession = mApplication.getDaoSession();

        initSampleData();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mDataset);
        setListAdapter(adapter);
    }

    void initSampleData() {
        mPlayerDao = mDaoSession.getPlayerDao();

        mPlayerDao.deleteAll();

        Player messi = new Player(1L, "Leonel Messi", "FC Barcelona");
        Player ronaldo = new Player(2L, "Cristiano Ronaldo", "Real Madrid");
        Player gerrard = new Player(3L, "Steven Gerrard", "Liverpool");
        Player persie = new Player(4L, "Robin Van Persie", "Man Utd");
        Player teerasil = new Player(5L, "Teerasil Dangda", "UD Almeria");

        mPlayerDao.insert(messi);
        mPlayerDao.insert(ronaldo);
        mPlayerDao.insert(gerrard);
        mPlayerDao.insert(persie);
        mPlayerDao.insert(teerasil);

        List<Player> players = mPlayerDao.loadAll();
        for (Player player : players) {
            mDataset.add("Name : " + player.getName() + "\nClub : " + player.getClub());
        }
    }
}
