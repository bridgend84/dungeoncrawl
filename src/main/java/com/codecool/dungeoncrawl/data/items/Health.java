package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Health extends Item {
    public static final int HEALTH = 20;
    private final int health;

    public Health(Cell cell) {
        super(ItemType.HEALTH, cell);
        this.health = HEALTH;
    }

    @Override
    public String getTileName() {
        return getItemType().getName();
    }

    public int getHealth() {
        return health;
    }
}
