package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.items.Item;

public interface GameMapModifier {
    void removeItem(Item item);

    void removeDeadActors();

    Cell getCell(int dx, int dy);

    void moveMonsters();

    boolean isAllMonstersDead();

    boolean isPlayerDead();
}
