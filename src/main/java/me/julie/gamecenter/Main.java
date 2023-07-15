package me.julie.gamecenter;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    private static Main instance = null;
    private Stage mainStage = null;
    private Parent menuRoot = null;
    private Parent minesweeperRoot = null;
    private Parent wordleRoot = null;
    private Parent simonRoot = null;
    // private Parent battleshipRoot = null;
    // private Parent cardMemoryRoot = null;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Starting Game Center");
        instance = this;
        mainStage = stage;

        System.out.println("Loading Scenes");
        menuRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("fxml/game-center.fxml")));
        System.out.println("Loaded Game Center");
        minesweeperRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("fxml/minesweeper.fxml")));
        System.out.println("Loaded Minesweeper");
        wordleRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("fxml/wordle-board.fxml")));
        System.out.println("Loaded Wordle");
        simonRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("fxml/simon.fxml")));
        System.out.println("Loaded Simon");
        // battleshipRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("battleship.fxml")));
        // cardMemoryRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("card-memory.fxml")));

        mainStage.setTitle("Games");
        mainStage.setScene(menuRoot.getScene());
        mainStage.setMaximized(true);
        mainStage.show();
    }

    public static Image getImage(String s) {
        return new Image("./" + s);
    }

    public static Main getInstance() {
        return instance;
    }

    public Stage getStage() {
        return mainStage;
    }

    public Parent getMinesweeperRoot() {
        return minesweeperRoot;
    }

    public Parent getWordleRoot() {
        return wordleRoot;
    }

    public Parent getSimonRoot() {
        return simonRoot;
    }

    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<>() {
            @Override
            protected Void call() {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }
}