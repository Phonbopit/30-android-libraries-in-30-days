package com.devahoy.learn30androidlibraries.day1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.devahoy.learn30androidlibraries.R;
import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private StaggeredGridView mGridView;
    private CustomAdapter mAdapter;
    private ArrayList<String> mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day1_activity_main);

        mGridView = (StaggeredGridView) findViewById(R.id.grid_view);
        mAdapter = new CustomAdapter(this, R.id.image);

        mDataset = generateSampleData();
        for (String data : mDataset) {
            mAdapter.add(data);
        }

        mGridView.setAdapter(mAdapter);

    }

    private ArrayList<String> generateSampleData() {
        final ArrayList<String> data = new ArrayList<String>();

        data.add("https://d13yacurqjgara.cloudfront.net/users/283599/screenshots/1635215/never_quit.jpg");
        data.add("https://d13yacurqjgara.cloudfront.net/users/46938/screenshots/1635213/datastory-gis-map-icon-set_1x.jpg");
        data.add("https://d13yacurqjgara.cloudfront.net/users/46938/screenshots/1635210/appointment-used-eye-doctor-optometrist-icon-set_1x.jpg");
        data.add("https://d13yacurqjgara.cloudfront.net/users/565942/screenshots/1635208/megacourse-checkout_1x.png");
        data.add("https://d13yacurqjgara.cloudfront.net/users/111758/screenshots/1635207/qwilt_cutting_room_floor_1x.gif");
        data.add("https://d13yacurqjgara.cloudfront.net/users/99875/screenshots/1635187/lonely-goalie_teaser.gif");
        data.add("https://d13yacurqjgara.cloudfront.net/users/46938/screenshots/1635206/unused-eye-doctor-optometrist-icon-set_1x.jpg");
        data.add("https://d13yacurqjgara.cloudfront.net/users/340376/screenshots/1635184/momentum_progress3-02_teaser.jpg");
        data.add("https://d13yacurqjgara.cloudfront.net/users/248947/screenshots/1635205/screen_shot_2014-07-09_at_9.39.23_am_teaser.png");
        data.add("https://d13yacurqjgara.cloudfront.net/users/197415/screenshots/1635204/round-bold-soft-icons_v2short_teaser.jpg");
        data.add("https://d13yacurqjgara.cloudfront.net/users/73845/screenshots/1635203/icons_1x.gif");
        data.add("https://d13yacurqjgara.cloudfront.net/users/46938/screenshots/1635201/bli-custiom-business-learning-icons-set_1x.jpg");
        data.add("https://d13yacurqjgara.cloudfront.net/users/11431/screenshots/1635200/youngblood_01_905_1x.jpg");
        data.add("https://d13yacurqjgara.cloudfront.net/users/406256/screenshots/1635199/micro_1x.jpg");
        data.add("https://d13yacurqjgara.cloudfront.net/users/568675/screenshots/1635198/productshot_teaser.png");
        data.add("https://d13yacurqjgara.cloudfront.net/users/111758/screenshots/1635197/qwilt_comp_1x.jpg");
        data.add("https://d13yacurqjgara.cloudfront.net/users/607527/screenshots/1635195/khal-drogo_x1000_1x.jpg");
        data.add("https://d13yacurqjgara.cloudfront.net/users/607527/screenshots/1635188/dragonfruit_paper_x1000_teaser.jpg");

        return data;
    }
}
