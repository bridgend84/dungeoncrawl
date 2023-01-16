package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty", true),
    FLOOR("floor", true),
    WALL("wall", false);

    private final String tileName;
    private final boolean canPlayerMoveOn;

    CellType(String tileName, boolean canPlayerMoveOn) {
        this.tileName = tileName;
        this.canPlayerMoveOn = canPlayerMoveOn;
    }

    public String getTileName() {
        return tileName;
    }

    public boolean getCanPlayerMoveOn() {
        return canPlayerMoveOn;
    }
}
