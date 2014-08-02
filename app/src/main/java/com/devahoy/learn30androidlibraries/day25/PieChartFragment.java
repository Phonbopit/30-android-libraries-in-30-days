package com.devahoy.learn30androidlibraries.day25;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devahoy.learn30androidlibraries.R;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.communication.IOnItemFocusChangedListener;
import org.eazegraph.lib.models.PieModel;

public class PieChartFragment extends Fragment {

    private PieChart mPieChart;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.day25_fragment_pie_chart, container, false);
        mPieChart = (PieChart) view.findViewById(R.id.piechart);
        initData();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPieChart.startAnimation();
    }

    private void initData() {
        mPieChart.addPieSlice(new PieModel("KitKat", 17.9f,
                Color.parseColor("#df5346")));
        mPieChart.addPieSlice(new PieModel("Jelly Bean", 56.5f,
                Color.parseColor("#6dd621")));
        mPieChart.addPieSlice(new PieModel("Ice Cream Sandwich", 11.4f,
                Color.parseColor("#1f3b83")));
        mPieChart.addPieSlice(new PieModel("Gingerbread", 13.5f,
                Color.parseColor("#34a394")));
        mPieChart.addPieSlice(new PieModel("Froyo", 0.7f,
                Color.parseColor("#22a7d0")));

        mPieChart.setOnItemFocusChangedListener(new IOnItemFocusChangedListener() {
            @Override
            public void onItemFocusChanged(int position) {
                // TODO: To do what you want.
            }
        });
    }

}
