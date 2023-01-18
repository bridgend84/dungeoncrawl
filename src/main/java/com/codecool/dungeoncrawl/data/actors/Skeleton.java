package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Skeleton extends Actor {
    public static final int SKELETON_HEALTH = 10;
    public static final int SKELETON_STRENGTH = 5;
    public Skeleton(Cell cell) {
        super(cell, SKELETON_HEALTH, SKELETON_STRENGTH, true);
    }
    @Override
    public String getTileName() {
        return "skeleton";
    }
}
