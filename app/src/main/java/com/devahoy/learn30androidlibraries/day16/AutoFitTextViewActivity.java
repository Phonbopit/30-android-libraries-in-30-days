package com.devahoy.learn30androidlibraries.day16;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.devahoy.learn30androidlibraries.R;

import me.grantland.widget.AutofitTextView;

public class AutoFitTextViewActivity extends ActionBarActivity {

    AutofitTextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day16_activity_autofit);
        mTextView = (AutofitTextView) findViewById(R.id.text_view);
        mEditText = (EditText) findViewById(R.id.edit_text);

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTextView.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
