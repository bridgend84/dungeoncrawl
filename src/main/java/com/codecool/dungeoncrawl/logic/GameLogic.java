package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.Set;

public class GameLogic {
    private final GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
        map.setMovableMonsters();
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public String getPlayerStrength() {
        return Integer.toString(map.getPlayer().getStrength());
    }

    public Set<Item> getPlayerInventory() {
        return map.getPlayer().getItems();
    }

    public GameMap getMap() {
        return map;
    }
}
