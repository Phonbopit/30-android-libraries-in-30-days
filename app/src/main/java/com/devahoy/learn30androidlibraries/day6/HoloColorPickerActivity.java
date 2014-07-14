package com.devahoy.learn30androidlibraries.day6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.devahoy.learn30androidlibraries.R;
import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;
import com.larswerkman.holocolorpicker.SVBar;

public class HoloColorPickerActivity extends ActionBarActivity {

    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day6_activity_holo_color);

        mLinearLayout = (LinearLayout) findViewById(R.id.linear_layout);

        final Button button = (Button) findViewById(R.id.button_pick_color);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void openDialog() {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View view = inflater.inflate(R.layout.day6_dialog, null);
        builder.setView(view);

        final ColorPicker picker = (ColorPicker) view.findViewById(R.id.picker);
        SVBar svBar = (SVBar) view.findViewById(R.id.svbar);
        OpacityBar opacityBar = (OpacityBar) view.findViewById(R.id.opacitybar);

        picker.addOpacityBar(opacityBar);
        picker.addSVBar(svBar);

        picker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
            @Override
            public void onColorChanged(int i) {
                mLinearLayout.setBackgroundColor(picker.getColor());
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Change color go here.
                mLinearLayout.setBackgroundColor(picker.getColor());

            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
}
