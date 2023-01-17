package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Computer extends Item {

    public Computer(ItemType itemType, Cell cell) {
        super(itemType, cell);
    }

    @Override
    public String getTileName() {
        return "computer";
    }
}
