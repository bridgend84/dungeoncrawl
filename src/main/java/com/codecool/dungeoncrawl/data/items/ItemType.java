package com.codecool.dungeoncrawl.data.items;

public enum ItemType {

    COMPUTER("computer"),
    INGRAM("ingram"),
    SHOTGUN("shotgun"),
    HEALTH("health"),
    CAT_TRICKY("Tricky"),
    CAT_BOGYO("Bogyó"),
    CAT_MASNI("Masni"),
    CAT_NYAFI("Nyafi");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
