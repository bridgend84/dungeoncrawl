package com.codecool.dungeoncrawl.data.items;

public enum ItemType {

    COMPUTER("computer"),
    INGRAM("ingram", 10),
    SHOTGUN("shotgun", 15),
    HEALTH(20, "health"),
    CAT(5, "cat");
    private int damage;
    private final String name;
    private int health;

    ItemType(int health, String name) {
        this.name = name;
        this.health = health;
    }

    ItemType(String name) {
        this.name = name;
    }

    ItemType(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
