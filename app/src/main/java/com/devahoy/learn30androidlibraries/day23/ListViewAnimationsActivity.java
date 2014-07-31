package com.devahoy.learn30androidlibraries.day23;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.devahoy.learn30androidlibraries.R;
import com.nhaarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissAdapter;
import com.nhaarman.listviewanimations.swinginadapters.prepared.ScaleInAnimationAdapter;
import com.nhaarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.nhaarman.listviewanimations.swinginadapters.prepared.SwingLeftInAnimationAdapter;

import java.util.ArrayList;

public class ListViewAnimationsActivity extends ActionBarActivity {

    private ArrayList<String> mDataset = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day23_activity_listview_animation);

        ListView listView = (ListView) findViewById(R.id.list_view);

        for (int i = 1; i < 100; i++) {
            mDataset.add("Lorem ipsum quis leo pharetra item #" + i);
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mDataset);

        SwingBottomInAnimationAdapter swingBottomInAdapter =
                new SwingBottomInAnimationAdapter(adapter);
        swingBottomInAdapter.setAbsListView(listView);

        ScaleInAnimationAdapter scaleInAdapter = new ScaleInAnimationAdapter(adapter);
        scaleInAdapter.setAbsListView(listView);

        SwingLeftInAnimationAdapter swingLeftInAdapter = new SwingLeftInAnimationAdapter(adapter);
        swingLeftInAdapter.setAbsListView(listView);

        SwipeDismissAdapter swipeDismissAdapter = new SwipeDismissAdapter(adapter, new OnDismissCallback() {
            @Override
            public void onDismiss(AbsListView listView, int[] reverseSortedPositions) {
                for (int position : reverseSortedPositions) {
                    adapter.remove(mDataset.get(position));
                }
            }
        });
        swipeDismissAdapter.setAbsListView(listView);

        listView.setAdapter(swipeDismissAdapter);
    }
}
