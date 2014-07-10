package com.devahoy.learn30androidlibraries.day2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.devahoy.learn30androidlibraries.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.chrisjenx.paralloid.Parallaxor;

/**
 * Created by phonbopit on 7/9/14.
 */
public class ParallaxListActivity extends ActionBarActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day2_parallax_list_view);

        mListView = (ListView) findViewById(R.id.list_view);

        List<Map<String, String>> maps = new ArrayList<Map<String, String>>(50);
        Map<String, String> map;
        for (int i = 0; i < 50; i++) {
            map = new HashMap<String, String>();
            map.put("text", "Example Text " + i);
            maps.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, maps,
                android.R.layout.simple_list_item_1,
                new String[]{"text"},
                new int[]{android.R.id.text1});

        mListView.setAdapter(adapter);

        // Set the background after the setting the Adapter, it shouldn't matter until the view is drawn.
        // If you have difficulty getting this to work, just make sure this is called after adapter is added/view drawn for
        // ListViews, they have a limited support unfortunately.
        if (mListView instanceof Parallaxor) {
            ((Parallaxor) mListView).parallaxViewBackgroundBy(mListView, getResources().getDrawable(R.drawable.day2_example_rainbow), 1.0f);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, ParallaxBackgroundActivity.class);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }
}
