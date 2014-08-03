package com.devahoy.learn30androidlibraries.day26;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.devahoy.learn30androidlibraries.R;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;

public class CardsActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day26_activity_cards);

        CardView cardView = (CardView) findViewById(R.id.card);


        CardHeader cardHeader = new CardHeader(this);
        cardHeader.setTitle("This is header");

                Card card = new Card(this, R.layout.day26_list_item_cards);
//        Card card = new MyCard(this);
//        card.setTitle("This is Title of Card");
        card.addCardHeader(cardHeader);

        cardView.setCard(card);

        // Card ListView
        ArrayList<Card> cards = new ArrayList<Card>();

        for (int i = 0; i < 5; i++) {
            Card c = new Card(this);
            c.setTitle("Title #" + i);
            cards.add(c);
        }

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this,cards);

        CardListView listView = (CardListView) findViewById(R.id.card_list);
        if (listView!=null){
            listView.setAdapter(mCardArrayAdapter);
        }
    }
}
