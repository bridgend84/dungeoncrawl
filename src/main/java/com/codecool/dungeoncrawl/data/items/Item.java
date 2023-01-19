package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

import java.util.Objects;
import java.util.UUID;

public abstract class Item implements Drawable {
    private final ItemType itemType;
    private final UUID id;
    private final Cell cell;

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

    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public String getTileName() {
        return getItemType().getName();
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
