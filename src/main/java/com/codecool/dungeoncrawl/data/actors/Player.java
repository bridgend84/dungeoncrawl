package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.HashSet;
import java.util.Set;

public class Player extends Actor {
    public static final int PLAYER_HEALTH = 100;
    public static final int PLAYER_STRENGTH = 5;

    private Set<Item> items;

    public Player(Cell cell) {
        super(cell, PLAYER_HEALTH, PLAYER_STRENGTH);
        this.items = new HashSet<>();
    }

    public String getTileName() {
        return "player";
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        if (getCell().getItem() != null) {
            pickUpItem();
        }
    }

    public void pickUpItem() {
        items.add(this.getCell().getItem());
        getCell().removeItem(getCell().getItem());
    }
}
