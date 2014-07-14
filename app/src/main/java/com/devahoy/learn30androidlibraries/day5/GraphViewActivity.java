package com.devahoy.learn30androidlibraries.day5;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.LinearLayout;

import com.devahoy.learn30androidlibraries.R;
import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

public class GraphViewActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.day5_activity_graphview);


//        getSampleCode();
        sampleMultipleSeries();
    }

    private void sampleMultipleSeries() {
        String[] months = {
                "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
                "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"
        };

        int[] index = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] incomeA = {4000, 5500, 2300, 2100, 2500, 2900, 3200, 2400, 1800, 2100, 3500, 5900};
        int[] incomeB = {3600, 4500, 3200, 3600, 2800, 1800, 2100, 2900, 2200, 2500, 4000, 3500};
        int[] incomeC = {4300, 4000, 3000, 3200, 2400, 2500, 2600, 3400, 3900, 4500, 5000, 4500};


        int num = 100;
        GraphView.GraphViewData[] data = new GraphView.GraphViewData[index.length];
        for (int i = 0; i < index.length; i++) {
            data[i] = new GraphView.GraphViewData(i, incomeA[i]);
        }
        GraphViewSeries seriesA = new GraphViewSeries("Googla",
                new GraphViewSeries.GraphViewSeriesStyle(Color.RED, 5), data);

        data = new GraphView.GraphViewData[index.length];
        for (int i = 0; i < index.length; i++) {
            data[i] = new GraphView.GraphViewData(i, incomeB[i]);
        }
        GraphViewSeries seriesB = new GraphViewSeries("Microsa",
                new GraphViewSeries.GraphViewSeriesStyle(Color.BLUE, 5), data);

        data = new GraphView.GraphViewData[index.length];
        for (int i = 0; i < index.length; i++) {
            data[i] = new GraphView.GraphViewData(i, incomeC[i]);
        }
        GraphViewSeries seriesC = new GraphViewSeries("Appla",
                new GraphViewSeries.GraphViewSeriesStyle(Color.GREEN, 5), data);

        GraphView graphView = new LineGraphView(this, "Multiple Series");
        graphView.addSeries(seriesA);
        graphView.addSeries(seriesB);
        graphView.addSeries(seriesC);

        graphView.setShowLegend(true);
        graphView.getGraphViewStyle().setLegendWidth(200);

        LinearLayout layout = (LinearLayout) findViewById(R.id.linear_layout);
        layout.addView(graphView);

        graphView.setBackgroundColor(Color.WHITE);
    }


    private void getSampleCode() {

        GraphViewSeries exampleSeries = new GraphViewSeries(new GraphView.GraphViewData[] {
                new GraphView.GraphViewData(1, 2.0d)
                , new GraphView.GraphViewData(2, 1.5d)
                , new GraphView.GraphViewData(3, 2.5d)
                , new GraphView.GraphViewData(4, 1.0d)
        });

        GraphView graphView = new LineGraphView(this, "GraphViewDemo");
        graphView.addSeries(exampleSeries);

        GraphView barGraphView = new BarGraphView(this, "BarGraphView");
        barGraphView.addSeries(exampleSeries);

        LinearLayout layout = (LinearLayout) findViewById(R.id.linear_layout);
        layout.addView(barGraphView);
    }
}
