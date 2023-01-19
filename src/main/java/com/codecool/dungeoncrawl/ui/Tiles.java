package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private final static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private final static Map<String, Tile> tileMap = new HashMap<>();

    public static class Tile {
        public final int x, y, w, h;

        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(0, 0));
        tileMap.put("wall", new Tile(10, 17));
        tileMap.put("floor", new Tile(1, 0));
        tileMap.put("player", new Tile(27, 0));
        tileMap.put("skeleton", new Tile(29, 6));
        tileMap.put("giant_skeleton", new Tile(30, 6));
        tileMap.put("ghost", new Tile(26, 6));
        tileMap.put("water", new Tile(14, 18));
        tileMap.put("fire", new Tile(14, 10));
        tileMap.put("tree", new Tile(4, 2));
        tileMap.put("grass", new Tile(21, 2));
        tileMap.put("Ingram gun", new Tile(9, 31));
        tileMap.put("Shotgun", new Tile(7, 31));
        tileMap.put("Computer", new Tile(7, 21));
        tileMap.put("door", new Tile(6, 10));
        tileMap.put("door-open", new Tile(8, 10));
        tileMap.put("concrete", new Tile(19, 0));
        tileMap.put("concrete-down", new Tile(19, 2));
        tileMap.put("toilet", new Tile(12, 10));
        tileMap.put("Health potion (Beer)", new Tile(15, 31));
        tileMap.put("sea", new Tile(8, 5));
        tileMap.put("purple-floor", new Tile(23, 27));
        tileMap.put("five", new Tile(24, 16));
        tileMap.put("seven", new Tile(26, 16));
        tileMap.put("eight", new Tile(27, 16));
        tileMap.put("Tricky", new Tile(30, 7));
        tileMap.put("Bogyó", new Tile(29, 7));
        tileMap.put("Masni", new Tile(28, 7));
        tileMap.put("Nyafi", new Tile(27, 7));
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
