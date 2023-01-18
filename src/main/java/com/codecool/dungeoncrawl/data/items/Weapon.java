package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Weapon extends Item {

    private final int damage;

    public Weapon(ItemType itemType, Cell cell) {
        super(itemType, cell);
        this.damage = itemType.getDamage();
    }

    @Override
    public String getTileName() {
        return getItemType().getName();
    }

    public int getDamage() {
        return damage;
    }
}
