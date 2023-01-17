package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameMap {
    private final int width;
    private final int height;
    private final Cell[][] cells;
    private Player player;
    private Set<Actor> enemies;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        this.enemies = new HashSet<>();
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setEnemy(Actor actor) {
        enemies.add(actor);
    }

    public Player getPlayer() {
        return player;
    }

    public Set<Actor> getEnemies() {
        return enemies;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void killEnemies() {
        this.enemies = enemies.stream().filter(actor -> actor.getHealth() > 0).collect(Collectors.toSet());
    }
}
