package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Ghost extends Actor {
    public static final int GHOST_HEALTH = 20;
    public static final int GHOST_STRENGTH = 7;
    public Ghost(Cell cell) {
        super(cell, GHOST_HEALTH, GHOST_STRENGTH, true);
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getActor() == null) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
        if (nextCell.getActor() != null && !(nextCell.getActor().equals(this))) {
            attackEnemy(nextCell.getActor());
        }
    }

    @Override
    public String getTileName() {
        return "ghost";
    }
}
