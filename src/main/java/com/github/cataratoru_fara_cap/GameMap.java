package com.github.cataratoru_fara_cap;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameMap {
    private static final int TILE_SIZE = 40;
    private static final int MAP_SIZE = 10;
    private static final char EMPTY = '0';
    private static final char PLAYER = 'P';
    private char[][] map;
    private int playerX = 0;
    private int playerY = 0;

    public GameMap() {
        map = new char[MAP_SIZE][MAP_SIZE];
        // Initialize map with empty cells and random objects
        initializeMap();
    }

    private void initializeMap() {
        // Randomly place objects on the map
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY; // Empty cell
            }
        }
        map[playerX][playerY] = PLAYER; // Player's initial position
    }

    public void display(Stage stage) {
        Canvas canvas = new Canvas(MAP_SIZE * TILE_SIZE, MAP_SIZE * TILE_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawMap(gc);

        Scene scene = new Scene(new StackPane(canvas));
        scene.setOnKeyPressed(this::handleKeyPress);

        stage.setScene(scene);
        stage.show();
    }

    private void drawMap(GraphicsContext gc) {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                switch (map[i][j]) {
                    case 'P':
                        gc.fillText("P", j * TILE_SIZE, i * TILE_SIZE);
                        break;
                    case 'T':
                        gc.fillText("T", j * TILE_SIZE, i * TILE_SIZE);
                        break;
                    case 'R':
                        gc.fillText("R", j * TILE_SIZE, i * TILE_SIZE);
                        break;
                    case 'G':
                        gc.fillText("G", j * TILE_SIZE, i * TILE_SIZE);
                        break;
                    case 'E':
                        gc.fillText("E", j * TILE_SIZE, i * TILE_SIZE);
                        break;
                    default:
                        gc.fillText("0", j * TILE_SIZE, i * TILE_SIZE);
                }
            }
        }
    }

    private void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                movePlayer(-1, 0);
                break;
            case A:
                movePlayer(0, -1);
                break;
            case S:
                movePlayer(1, 0);
                break;
            case D:
                movePlayer(0, 1);
                break;
            default:
                break;
        }
    }

    private void movePlayer(int dx, int dy) {
        int newX = playerX + dx;
        int newY = playerY + dy;
        if (newX >= 0 && newX < MAP_SIZE && newY >= 0 && newY < MAP_SIZE) {
            map[playerX][playerY] = EMPTY; // Empty the old cell
            playerX = newX;
            playerY = newY;
            map[playerX][playerY] = PLAYER; // Move player to the new cell
        }
    }
}