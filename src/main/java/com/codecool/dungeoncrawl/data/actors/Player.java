package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Player extends Actor {
    public static final int PLAYER_HEALTH = 100;
    public static final int PLAYER_STRENGTH = 5;
    public Player(Cell cell) {
        super(cell, PLAYER_HEALTH, PLAYER_STRENGTH);
    }

    public String getTileName() {
        return "player";
    }
}
