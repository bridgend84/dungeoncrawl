package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Weapon extends Item {

    private int damage;

    public Weapon(ItemType itemType, Cell cell) {
        super(itemType, cell);
        this.damage = itemType.getDamage();
    }

    @Override
    public String getTileName() {
        return "ingram";
    }
}
