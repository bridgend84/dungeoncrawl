package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.Weapon;

import java.util.HashSet;
import java.util.Set;

public class Player extends Actor {
    public static final int PLAYER_HEALTH = 100;
    public static final int PLAYER_STRENGTH = 5;

    private final Set<Item> items;

    public Player(Cell cell) {
        super(cell, PLAYER_HEALTH, PLAYER_STRENGTH);
        this.items = new HashSet<>();
    }

    public String getTileName() {
        return "player";
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        if (getCell().getItem() != null) {
            pickUpItem();
        }
    }

    public void pickUpItem() {
        Item currentItem = getCell().getItem();
        if (currentItem instanceof Weapon currentWeapon) {
            replaceWeapon(currentWeapon);
        } else {
            addItem(currentItem);
        }
    }

    public void addItem(Item item) {
        items.add(item);
        getCell().removeItem(item);
    }

    public void trashItem(Item item) {
        items.remove(item);
    }

    public void replaceWeapon(Weapon weapon) {
        items.stream()
                .filter(item -> item instanceof Weapon)
                .map(item -> (Weapon) item)
                .findFirst()
                .ifPresent(previousWeapon -> {
                    this.decreaseStrength(previousWeapon.getDamage());
                    trashItem(previousWeapon);
                });
        addItem(weapon);
        this.incrementStrength(weapon.getDamage());
    }

    public Set<Item> getItems() {
        return items;
    }
}
