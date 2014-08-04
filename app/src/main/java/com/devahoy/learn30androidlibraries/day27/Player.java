package com.devahoy.learn30androidlibraries.day27;

public class Player {

    public Player(String name, String club) {
        setName(name);
        setClub(club);
    }
    private String name;
    private String club;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
