package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Ghost extends Actor {
    public static final int GHOST_HEALTH = 20;
    public static final int GHOST_STRENGTH = 7;
    public Ghost(Cell cell) {
        super(cell, GHOST_HEALTH, GHOST_STRENGTH);
    }

    @Override
    public String getTileName() {
        return "ghost";
    }
}
