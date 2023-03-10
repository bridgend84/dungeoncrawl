package com.codecool.dungeoncrawl.data;

public enum CellType {
    GRASS("grass", true),
    TREE("tree", false),
    FIRE("fire", true),
    WATER("water", false),
    EMPTY("empty", true),
    FLOOR("floor", true),
    WALL("wall", false),
    DOOR("door", false),
    DOOR_OPEN("door-open", true),
    CONCRETE("concrete", true),
    CONCRETE_DOWN("concrete-down", true),
    TOILET("toilet", true),
    HEALTH("health", true),
    SEA("sea", false),
    PURPLE_FLOOR("purple-floor", true),
    FIVE("five", false),
    SEVEN("seven", false),
    EIGHT("eight", false);
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
