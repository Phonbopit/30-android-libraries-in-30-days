package com.devahoy.learn30androidlibraries.day11;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.devahoy.learn30androidlibraries.R;
import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.sleepbot.datetimepicker.time.RadialPickerLayout;
import com.sleepbot.datetimepicker.time.TimePickerDialog;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimePickerActivity extends ActionBarActivity {

    private DatePickerDialog mDatePicker;
    private TimePickerDialog mTimePicker;
    private Calendar mCalendar;
    private Button mTimeButton;
    private Button mDateButton;
    private TextView mTextTime;
    private TextView mTextDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day11_activity_date_picker);

        mTimeButton = (Button) findViewById(R.id.button_time);
        mDateButton = (Button) findViewById(R.id.button_date);
        mTextTime = (TextView) findViewById(R.id.text_time);
        mTextDate = (TextView) findViewById(R.id.text_date);

        mCalendar = Calendar.getInstance();

        mDatePicker = DatePickerDialog.newInstance(onDateSetListener,
                mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH),
                false);

        mTimePicker = TimePickerDialog.newInstance(onTimeSetListener,
                mCalendar.get(Calendar.HOUR_OF_DAY),
                mCalendar.get(Calendar.MINUTE),
                true,
                false);

        mTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimePicker.show(getSupportFragmentManager(), "timePicker");
            }
        });

        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatePicker.setYearRange(2000, 2020);
                mDatePicker.show(getSupportFragmentManager(), "datePicker");
            }
        });
    }

    private TimePickerDialog.OnTimeSetListener onTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(RadialPickerLayout radialPickerLayout, int hourOfDay, int minute) {
            mTextTime.setText(" " + hourOfDay + " : " + minute);
        }
    };

    private DatePickerDialog.OnDateSetListener onDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {

            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
            mCalendar.set(year, month, day);
            Date date = mCalendar.getTime();
            String textDate = dateFormat.format(date);
            mTextDate.setText(textDate);
        }
    };
}
