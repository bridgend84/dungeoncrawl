package com.codecool.dungeoncrawl.data.items;

public enum ItemType {

    COMPUTER(),
    INGRAM(10);

    private int damage;

    ItemType(){}

    ItemType(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
