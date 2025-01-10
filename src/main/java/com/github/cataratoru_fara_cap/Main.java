package com.github.cataratoru_fara_cap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Survival Game");

        // Create buttons
        Button resumeButton = new Button("Resume");
        Button newGameButton = new Button("New Game");
        Button optionsButton = new Button("Options");
        Button helpButton = new Button("Help");
        Button exitButton = new Button("Exit");

        // Set button actions
        resumeButton.setOnAction(e -> loadGame());
        newGameButton.setOnAction(e -> startNewGame(primaryStage));
        optionsButton.setOnAction(e -> showOptions());
        helpButton.setOnAction(e -> showHelp());
        exitButton.setOnAction(e -> primaryStage.close());

        // Layout for the menu
        VBox menuLayout = new VBox(10);
        menuLayout.getChildren().addAll(resumeButton, newGameButton, optionsButton, helpButton, exitButton);
        menuLayout.setStyle("-fx-alignment: center; -fx-padding: 20px;");

        // Create and set the scene
        Scene menuScene = new Scene(menuLayout, 300, 250);
        menuScene.getStylesheets().add("file:///c:/Users/gabiv/Programing/java_projects/grand_devoir_3/src/main/resources/style.css");
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    private void loadGame() {
        // Implement load game logic
    }

    private void startNewGame(Stage primaryStage) {
        GameMap gameMap = new GameMap();
        gameMap.display(primaryStage);
    }

    private void showOptions() {
        // Implement options logic
    }

    private void showHelp() {
        // Implement help logic
    }

    public static void main(String[] args) {
        launch(args);
    }
}

