package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.Arrays;

public class GameMap implements GameMapModifier {
    private final int width;
    private final int height;
    private final Cell[][] cells;
    private Player player;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
