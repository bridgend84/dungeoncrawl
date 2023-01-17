package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

import java.util.Objects;
import java.util.UUID;

public abstract class Item implements Drawable {

    private ItemType itemType;

    private final UUID id;
    private Cell cell;

    public Item(ItemType itemType, Cell cell) {
        this.itemType = itemType;
        this.id = UUID.randomUUID();
        this.cell = cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
