package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Cat extends Item{

    public Cat(ItemType itemType, Cell cell) {
        super(itemType, cell);
    }

    @Override
    public String getTileName() {
        return "cat";
    }
}
