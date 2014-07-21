package com.devahoy.learn30androidlibraries.day13;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.devahoy.learn30androidlibraries.R;

public class SimpleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int position = 0;

        int[] colors = {
            Color.rgb(0xF6, 0x47, 0x47), // #F64747
            Color.rgb(0x9A, 0x12, 0xB3), // #9A12B3
            Color.rgb(0x22, 0xA7, 0xF0), // #22A7F0
            Color.rgb(0x4B, 0x77, 0xBE), // #4B77BE
            Color.rgb(0x1B, 0xBC, 0x9B), // #1BBC9B
            Color.rgb(0xF2, 0x79, 0x35)  // #F27935
        };

        final String[] names = {
                "John Doe", "Jane Doe", "Chuck Norris", "Janie Roe", "James Roe"
        };

        Bundle bundle = getArguments();

        position = bundle.getInt(SimplePagerAdapter.ARGS_POSITION);

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.day13_fragment, container, false);

        TextView greeting = (TextView) rootView.findViewById(R.id.greeting);
        LinearLayout linearLayout = (LinearLayout)
                rootView.findViewById(R.id.linear_layout);

        linearLayout.setBackgroundColor(colors[position % colors.length]);
        greeting.setText("Hello " + names[position % names.length]);

        return rootView;
    }
}
