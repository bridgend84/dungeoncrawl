package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class GiantSkeleton extends Actor{
    public static final int GIANT_SKELETON_HEALTH = 30;
    public static final int GIANT_SKELETON_STRENGTH = 15;
    public GiantSkeleton(Cell cell) {
        super(cell, GIANT_SKELETON_HEALTH, GIANT_SKELETON_STRENGTH, false);
    }

    @Override
    public String getTileName() {
        return "giant_skeleton";
    }
}
