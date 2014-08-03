package com.devahoy.learn30androidlibraries.day26;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.devahoy.learn30androidlibraries.R;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;

public class CardsActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day26_activity_cards);

        Card card = new Card(this);

        CardView cardView = (CardView) findViewById(R.id.card);

        cardView.setCard(card);
    }
}
