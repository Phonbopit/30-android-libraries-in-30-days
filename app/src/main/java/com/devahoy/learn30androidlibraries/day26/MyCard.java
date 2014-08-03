package com.devahoy.learn30androidlibraries.day26;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devahoy.learn30androidlibraries.R;

import it.gmariotti.cardslib.library.internal.Card;


public class MyCard extends Card {

    public MyCard(Context context) {
        super(context, R.layout.day26_list_item_cards);
    }

    public MyCard(Context context, int innerLayout) {
        super(context, innerLayout);
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText("Lorem ipsum, This is a book!!");
        title.setGravity(Gravity.CENTER_VERTICAL);
    }
}
