package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public abstract class Weapon extends Item {
    private final int damage;

    public Weapon(ItemType itemType, Cell cell, int damage) {
        super(itemType, cell);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
