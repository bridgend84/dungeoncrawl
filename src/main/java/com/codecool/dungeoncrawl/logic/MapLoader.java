package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Skeleton;
import com.codecool.dungeoncrawl.data.items.Computer;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.ItemType;
import com.codecool.dungeoncrawl.data.items.Weapon;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ' -> {
                            cell.setType(CellType.EMPTY);
                        }
                        case '#' -> {
                            cell.setType(CellType.WALL);
                        }
                        case '.' -> {
                            cell.setType(CellType.FLOOR);
                        }
                        case 's' -> {
                            cell.setType(CellType.FLOOR);
                            cell.setActor(new Skeleton(cell));
                        }
                        case '@' -> {
                            cell.setType(CellType.FLOOR);
                            Player player = new Player(cell);
                            cell.setActor(player);
                            map.setPlayer(player);
                        }
                        case 'w' -> {
                            cell.setType(CellType.WATER);
                        }
                        case 'f' -> {
                            cell.setType(CellType.FIRE);
                        }
                        case 't' -> {
                            cell.setType(CellType.TREE);
                        }
                        case 'g' -> {
                            cell.setType(CellType.GRASS);
                        }
                        case 'i' -> {
                            cell.setType(CellType.FLOOR);
                            Item weapon = new Weapon(ItemType.INGRAM, cell);
                            cell.setItem(weapon);
                        }
                        case 'c' -> {
                            cell.setType(CellType.FLOOR);
                            Item computer = new Computer(ItemType.COMPUTER, cell);
                            cell.setItem(computer);
                        }
                        case 'd' -> {
                            cell.setType(CellType.DOOR);
                        }
                        case 'O' -> {
                            cell.setType(CellType.DOOR_OPEN);
                        }
                        default -> {
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                        }
                    }
                }
            }
        }
        return map;
    }

}
