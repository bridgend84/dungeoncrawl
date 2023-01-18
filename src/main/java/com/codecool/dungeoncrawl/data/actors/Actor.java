package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public abstract class Actor implements Drawable {
    private final UUID id;
    private Cell cell;
    private int health;
    private int strength;
    protected Random random;
    private boolean isRandomMovable;

    public Actor(Cell cell, int health, int strength, boolean isRandomMovable) {
        this.id = UUID.randomUUID();
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
        this.strength = strength;
        this.random = new Random();
        this.isRandomMovable = isRandomMovable;
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

    public void randomMove() {
        List<List<Integer>> directions = List.of(List.of(0,1), List.of(0,-1), List.of(1,0), List.of(-1, 0));
        List<Integer> currentMove = directions.get(random.nextInt(directions.size()));
        move(currentMove.get(0), currentMove.get(1));
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

    public void incrementStrength(int strength) {
        this.strength += strength;
    }

    public void decreaseStrength(int strength) {
        if (this.strength - strength < 0) {
            this.strength = 0;
        } else {
            this.strength -= strength;
        }
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

    public void takeDamage(int damage) {
        if (this.health - damage < 0) {
            this.health = 0;
        } else {
            this.health -= damage;
        }
    }

    public boolean isRandomMovable() {
        return isRandomMovable;
    }
}
