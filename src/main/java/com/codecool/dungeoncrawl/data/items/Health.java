package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Health extends Item {
    private int health;

    public Health(ItemType itemType, Cell cell) {
        super(itemType, cell);
        this.health = itemType.getHealth();
    }

    @Override
    public String getTileName() {
        return getItemType().getName();
    }

    public int getHealth() {
        return health;
    }
}
