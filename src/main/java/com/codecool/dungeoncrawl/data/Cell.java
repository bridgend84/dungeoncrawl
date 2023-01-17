package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Actor;

import java.util.Objects;

public class Cell implements Drawable {
    private CellType type;
    private Actor actor;
    private final GameMap gameMap;
    private final int x, y;

    public Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }

    @Override
    public String getTileName() {
        return type.getTileName();
    }

    public boolean canActorMoveOn() {
        return getType().getCanPlayerMoveOn() &&
                gameMap
                        .getEnemies()
                        .stream()
                        .noneMatch(actor -> actor.getX() == this.getX() && actor.getY() == this.getY());
    }

    public Actor isEnemyOnCell() {
        return gameMap
                .getEnemies()
                .stream()
                .filter(actor -> actor.getX() == this.getX() && actor.getY() == this.getY())
                .findAny()
                .orElse(null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void checkAllEnemyHealth() {
        gameMap.killEnemies();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
