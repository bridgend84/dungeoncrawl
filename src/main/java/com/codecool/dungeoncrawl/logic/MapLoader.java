package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Ghost;
import com.codecool.dungeoncrawl.data.actors.GiantSkeleton;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Skeleton;
import com.codecool.dungeoncrawl.data.items.*;

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
                        case 'S' -> {
                            cell.setType(CellType.FLOOR);
                            cell.setActor(new GiantSkeleton(cell));
                        }
                        case 'G' -> {
                            cell.setType(CellType.FLOOR);
                            cell.setActor(new Ghost(cell));
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
                            Item weapon = new Ingram(cell);
                            cell.setItem(weapon);
                        }
                        case 'D' -> {
                            cell.setType(CellType.FLOOR);
                            Item weapon = new Shotgun(cell);
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
                        case '-' -> {
                            cell.setType(CellType.CONCRETE);
                        }
                        case '_' -> {
                            cell.setType(CellType.CONCRETE_DOWN);
                        }
                        case 'T' -> {
                            cell.setType(CellType.TOILET);
                        }
                        case 'H' -> {
                            cell.setType(CellType.FLOOR);
                            Item health = new Health(cell);
                            cell.setItem(health);
                        }
                        case 'C' -> {
                            cell.setType(CellType.FLOOR);
                            Item cat = new Cat(ItemType.CAT_TRICKY, cell);
                            cell.setItem(cat);
                        }
                        case '&' -> {
                            cell.setType(CellType.SEA);
                        }
                        case 'P' -> {
                            cell.setType(CellType.PURPLE_FLOOR);
                        }
                        case '5' -> {
                            cell.setType(CellType.FIVE);
                        }
                        case '7' -> {
                            cell.setType(CellType.SEVEN);
                        }
                        case '8' -> {
                            cell.setType(CellType.EIGHT);
                        }
                        case 'b' -> {
                            cell.setType(CellType.FLOOR);
                            Item bogyo = new Cat(ItemType.CAT_BOGYO, cell);
                            cell.setItem(bogyo);
                        }
                        case 'M' -> {
                            cell.setType(CellType.FLOOR);
                            Item masni = new Cat(ItemType.CAT_MASNI, cell);
                            cell.setItem(masni);
                        }
                        case 'N' -> {
                            cell.setType(CellType.FLOOR);
                            Item nyafi = new Cat(ItemType.CAT_NYAFI, cell);
                            cell.setItem(nyafi);
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
