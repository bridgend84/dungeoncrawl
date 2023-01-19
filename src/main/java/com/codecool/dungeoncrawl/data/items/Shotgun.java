package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Shotgun extends Weapon{
    public static final int SHOTGUN_DAMAGE = 15;
    public Shotgun(Cell cell) {
        super(ItemType.SHOTGUN, cell, SHOTGUN_DAMAGE);
    }
}
