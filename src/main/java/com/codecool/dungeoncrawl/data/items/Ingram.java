package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Ingram extends Weapon{

    public static final int INGRAM_DAMAGE = 10;

    public Ingram(Cell cell) {
        super(ItemType.INGRAM, cell, INGRAM_DAMAGE);
    }
}
