package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

import java.util.UUID;

public abstract class Actor implements Drawable {
    private final UUID id;
    private Cell cell;
    private int health;
    private int strength;

    public Actor(Cell cell, int health, int strength) {
        this.id = UUID.randomUUID();
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
        this.strength = strength;
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.canActorMoveOn()) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
        if (nextCell.getActor() != null && !(nextCell.getActor().equals(this))) {
            attackEnemy(nextCell.getActor());
        }
    }

    private void attackEnemy(Actor enemy) {
        enemy.takeDamage(this.strength);
        this.takeDamage(enemy.strength);
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    public UUID getId() {
        return id;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }
}
