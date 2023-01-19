package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.Weapon;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.ui.elements.MainStage;
import com.codecool.dungeoncrawl.ui.keyeventhandler.KeyHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.util.Duration;

import java.util.Set;

public class UI {
    private final Canvas canvas;
    private final GraphicsContext context;
    private final MainStage mainStage;
    private final GameLogic logic;
    private final Set<KeyHandler> keyHandlers;

    public UI(GameLogic logic, Set<KeyHandler> keyHandlers) {
        this.canvas = new Canvas(
                logic.getMapWidth() * Tiles.TILE_WIDTH,
                logic.getMapHeight() * Tiles.TILE_WIDTH);
        this.logic = logic;
        this.context = canvas.getGraphicsContext2D();
        this.mainStage = new MainStage(canvas);
        this.keyHandlers = keyHandlers;
    }

    public void setUpPain(Stage primaryStage) {
        Scene scene = mainStage.getScene();
        primaryStage.setScene(scene);
        logic.setup();
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        for (KeyHandler keyHandler : keyHandlers) {
            keyHandler.perform(keyEvent, logic.getMap());
        }
        logic.getMap().removeDeadActors();
        refresh();
        checkWinLoseCondition();
    }

    public void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < logic.getMapWidth(); x++) {
            for (int y = 0; y < logic.getMapHeight(); y++) {
                Cell cell = logic.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        mainStage.setHealthLabelText(logic.getPlayerHealth());
        mainStage.setStrenghtLabelText(logic.getPlayerStrenght());
        mainStage.setPlayerInventoryList(getPlayerInventoryAsStringList());
    }

    public ObservableList<String> getPlayerInventoryAsStringList() {
        ObservableList<String> inventoryList = FXCollections.observableArrayList();
        Set<Item> inventory = logic.getPlayerInventory();
        for (Item item : inventory) {
            if (item instanceof Weapon) {
                inventoryList.add(item.getTileName() + " (Damage: " + ((Weapon) item).getDamage() + ")");
            } else {
                inventoryList.add(item.getTileName());
            }
        }
        return inventoryList;
    }

    private void alert(String message) {
        Alert alert = new Alert(
                Alert.AlertType.NONE,
                message,
                ButtonType.OK);
        alert.showAndWait();
    }

    public void moveMonsters() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev -> {
            logic.getMap().moveMonsters();
            refresh();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void checkWinLoseCondition() {
        if (logic.getMap().isPlayerDead()) {
            alert("GAME OVER");
        } else if (logic.getMap().isAllMonstersDead() || logic.getMap().isAllCatsCollected()) {
            alert("WIN! Bye-bye OOP module! <3");
        }
    }
}
