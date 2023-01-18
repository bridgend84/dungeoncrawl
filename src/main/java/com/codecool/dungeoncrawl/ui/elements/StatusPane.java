package com.codecool.dungeoncrawl.ui.elements;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthValueLabel;

    private Label inventoryLabel;
    ListView<String> inventoryList;

    public StatusPane() {
        ui = new GridPane();
        healthValueLabel = new Label();
        inventoryList = new ListView<>();
        inventoryLabel = new Label("Inventory: ");
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthValueLabel, 0, 0);
        ui.add(inventoryLabel, 0, 1);
        ui.add(inventoryList, 0, 2);
        inventoryList.setPrefHeight(100);
        inventoryList.setPrefWidth(120);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText("Health: " + text);
    }

    public void setInventoryList(ObservableList<String> playerInventoryList) {
        inventoryList.setItems(playerInventoryList);
    }
}
