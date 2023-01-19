package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Cat;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.ItemType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GameMap implements GameMapModifier {
    private final int width;
    private final int height;
    private final Cell[][] cells;
    private Player player;
    private final Set<Actor> movableMonsters;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
        this.movableMonsters = new HashSet<>();
    }

    public Cell getCell(int x, int y) {
        return cells[x < 0 ? 0 : Math.min(x, width - 1)][y < 0 ? 0 : Math.min(y, height - 1)];
    }

    public void addMovableMonsters(Actor actor) {
        movableMonsters.add(actor);
    }

    public void setMovableMonsters() {
        Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .map(Cell::getActor)
                .filter(Objects::nonNull)
                .filter(Actor::isRandomMovable)
                .forEach(this::addMovableMonsters);
    }

    @Override
    public void moveMonsters() {
        movableMonsters.forEach(Actor::randomMove);
    }

    @Override
    public boolean isAllMonstersDead() {
        return Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .map(Cell::getActor)
                .filter(Objects::nonNull)
                .allMatch(actor -> actor instanceof Player);
    }

    @Override
    public boolean isPlayerDead() {
        return Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .map(Cell::getActor)
                .noneMatch(actor -> actor instanceof Player);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void removeItem(Item item) {
        cells[item.getX()][item.getY()].setItem(null);
    }

    @Override
    public void removeDeadActors() {
        Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .filter(cell -> cell.getActor() != null)
                .filter(cell -> cell.getActor().getHealth() <= 0)
                .forEach(cell -> cell.setActor(null));
    }

    public boolean isAllCatsCollected() {
        return Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .filter(cell -> cell.getItem() != null)
                .noneMatch(cell -> cell.getItem() instanceof Cat);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
