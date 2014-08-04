package com.devahoy.learn30androidlibraries.day27;

import com.devahoy.learn30androidlibraries.R;
import com.mobsandgeeks.adapters.InstantText;

public class Player {

    public Player(String name, String club) {
        setName(name);
        setClub(club);
    }
    private String name;
    private String club;

    @InstantText(viewId = R.id.name)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @InstantText(viewId = R.id.club)
    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
