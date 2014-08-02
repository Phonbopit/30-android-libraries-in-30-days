package com.devahoy.learn30androidlibraries.day25;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devahoy.learn30androidlibraries.R;

import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

public class LineChartFragment extends Fragment {

    private ValueLineChart mLineChart;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.day25_fragment_line_chart, container, false);
        mLineChart = (ValueLineChart) view.findViewById(R.id.linechart);

        initData();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mLineChart.startAnimation();
    }
    private void initData() {

        ValueLineSeries series = new ValueLineSeries();
        series.setColor(Color.parseColor("#f62459"));

        series.addPoint(new ValueLinePoint("Sun", 12.4f));
        series.addPoint(new ValueLinePoint("Mon", 23.4f));
        series.addPoint(new ValueLinePoint("Tue", 51.2f));
        series.addPoint(new ValueLinePoint("Wed", 26.6f));
        series.addPoint(new ValueLinePoint("Thu", 34.2f));
        series.addPoint(new ValueLinePoint("Fri", 13.5f));
        series.addPoint(new ValueLinePoint("Sat", 61.9f));

        mLineChart.addSeries(series);
    }
}
