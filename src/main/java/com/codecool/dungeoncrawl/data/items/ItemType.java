package com.codecool.dungeoncrawl.data.items;

public enum ItemType {

    COMPUTER("computer"),
    INGRAM("ingram", 10),
    SHOTGUN("shotgun", 15),
    DUMMY_WEAPON("dummy_weapon",0);

    private int damage;
    private final String name;

    ItemType(String name){
        this.name = name;
    }

    ItemType(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
    public String getName() { return name; }
}
