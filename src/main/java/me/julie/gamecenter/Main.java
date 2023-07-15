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
    private Parent menuScene = null;
    private Parent minesweeperScene = null;
    private Parent wordleScene = null;
    private Parent simonScene = null;
    // private Scene battleshipScene = null;
    // private Scene cardMemoryScene = null;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Starting Game Center");
        instance = this;
        mainStage = stage;

        menuScene = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("game-center.fxml")));
        System.out.println("Loaded Game Center");
        minesweeperScene = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("minesweeper.fxml")));
        System.out.println("Loaded Minesweeper");
        wordleScene = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("wordle-board.fxml")));
        System.out.println("Loaded Wordle");
        simonScene = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("simon.fxml")));
        System.out.println("Loaded Simon");
        // battleshipScene = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("battleship.fxml")));
        // cardMemoryScene = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("card-memory.fxml")));

        mainStage.setTitle("Games");
        mainStage.setScene(new Scene(menuScene));
        mainStage.setMaximized(true);
        mainStage.show();
    }

    public static Image getImage(String s) {
        return new Image(Objects.requireNonNull(Main.class.getResourceAsStream(s)));
    }

    public static Main getInstance() {
        return instance;
    }

    public Stage getStage() {
        return mainStage;
    }

    public Parent getMinesweeperScene() {
        return minesweeperScene;
    }

    public Parent getWordleScene() {
        return wordleScene;
    }

    public Parent getSimonScene() {
        return simonScene;
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