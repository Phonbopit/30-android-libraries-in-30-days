package com.devahoy.learn30androidlibraries.day18;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devahoy.learn30androidlibraries.R;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ActionViewTarget;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class ShowcaseViewActivity extends ActionBarActivity {

    private TextView mStep1, mStep2, mStep3;
    private ShowcaseView mShowcaseView;
    private RelativeLayout mLayout;
    private int mState = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day18_activity_showcaseview);

        mStep1 = (TextView) findViewById(R.id.step1);
        mStep2 = (TextView) findViewById(R.id.step2);
        mStep3 = (TextView) findViewById(R.id.step3);
        mLayout = (RelativeLayout) findViewById(R.id.relative_layout);
    }

    View.OnClickListener ShowcaseViewOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (mState) {
                case 0:
                    mShowcaseView.setShowcase(new ViewTarget(mStep2), true);
//                    mShowcaseView.setTarget(new ViewTarget(mStep2));

                    break;
                case 1:
                    mShowcaseView.setShowcase(new ViewTarget(mStep3), true);
//                    mShowcaseView.setTarget(new ViewTarget(mStep3));
                    break;
                case 2:
                    ActionViewTarget target = new ActionViewTarget(ShowcaseViewActivity.this,
                            ActionViewTarget.Type.OVERFLOW);
//                    mShowcaseView.setTarget(target);
                    mShowcaseView.setTarget(target);
                    mLayout.setBackgroundColor(Color.parseColor("#FF31415A"));
                    mShowcaseView.setContentTitle("This is Help Menu");
                    setVisible(false);
                    mShowcaseView.setButtonText("OK");
                    break;
                default:
                    mShowcaseView.hide();
                    mLayout.setBackgroundColor(Color.TRANSPARENT);
                    setVisible(true);
                    break;
            }
            mState += 1;
        }
    };

    public void setVisible(boolean isVisible) {
        if(isVisible) {
            mStep1.setVisibility(View.VISIBLE);
            mStep2.setVisibility(View.VISIBLE);
            mStep3.setVisibility(View.VISIBLE);
        } else {
            mStep1.setVisibility(View.GONE);
            mStep2.setVisibility(View.GONE);
            mStep3.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        mShowcaseView = new ShowcaseView.Builder(this)
                .setTarget(new ViewTarget(mStep1))
                .setOnClickListener(ShowcaseViewOnClick)
                .build();

        mShowcaseView.setButtonText("Next Step");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }
}
