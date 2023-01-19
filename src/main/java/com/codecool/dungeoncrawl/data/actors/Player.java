package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.items.Health;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.ItemType;
import com.codecool.dungeoncrawl.data.items.Weapon;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.HashSet;
import java.util.Set;

public class Player extends Actor {
    public static final int PLAYER_HEALTH = 100;
    public static final int PLAYER_STRENGTH = 5;

    private final Set<Item> items;

    public Player(Cell cell) {
        super(cell, PLAYER_HEALTH, PLAYER_STRENGTH, false);
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
        Cell nextCell = getCell().getNeighbor(dx, dy);
        if (nextCell.getType().equals(CellType.DOOR)) {
            if (items.stream().anyMatch(item -> item.getItemType().equals(ItemType.COMPUTER))) {
                openTheDoor(nextCell);
            } else {
                displayAlert();
            }
        }
        if (getCell().getType().equals(CellType.TOILET)) {
            flushToilet();
        }
    }

    public void openTheDoor(Cell doorCell) {
        doorCell.setType(CellType.DOOR_OPEN);
    }

    public void pickUpItem() {
        Item currentItem = getCell().getItem();
        if (currentItem instanceof Weapon currentWeapon) {
            replaceWeapon(currentWeapon);
        } else if (currentItem instanceof Health health) {
            drinkPotion(health);
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

    public void displayAlert() {
        Alert alert = new Alert(
                Alert.AlertType.NONE,
                "You have to get a computer to hack this door!",
                ButtonType.OK);
        alert.showAndWait();
    }

    public void drinkPotion(Health health) {
        int potion = health.getHealth();
        this.setHealth(getHealth() + potion);
        getCell().removeItem(getCell().getItem());
    }

    public void flushToilet() {
        Alert flush = new Alert(Alert.AlertType.NONE,
                "Flush...Just what I needed...",
                ButtonType.FINISH);
        flush.showAndWait();
    }

}
