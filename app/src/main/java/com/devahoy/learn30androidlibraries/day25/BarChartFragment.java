package com.devahoy.learn30androidlibraries.day25;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devahoy.learn30androidlibraries.R;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

public class BarChartFragment extends Fragment {

    private BarChart mBarChart;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.day25_fragment_bar_chart, container, false);
        mBarChart = (BarChart) view.findViewById(R.id.barchart);

        initData();

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        mBarChart.startAnimation();
    }

    private void initData() {
        mBarChart.addBar(new BarModel("2010", 89.4f, 0xff663397));
        mBarChart.addBar(new BarModel("2011", 53.0f, 0xff4183d7));
        mBarChart.addBar(new BarModel("2012", 100, 0xff19b5fe));
        mBarChart.addBar(new BarModel("2013", 42.9f, 0xff1e8bc3));
        mBarChart.addBar(new BarModel("2014", 113.8f, 0xff36d7b7));
    }
}
