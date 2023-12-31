package me.julie.gamecenter;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import me.julie.gamecenter.memory.Difficulty;
import me.julie.gamecenter.wordle.WordleController;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    private static Main instance;
    private Stage mainStage;
    private static Difficulty difficulty;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        instance = this;
        mainStage = stage;

        mainStage.setTitle("Games");
        loadMenu();
        mainStage.setMaximized(true);
        mainStage.show();
    }

    public void loadMenu() {
        loadFXML("game-center");
    }

    public void loadMinesweeper() {
        loadFXML("minesweeper");
    }

    public void loadSimon() {
        loadFXML("simon");
    }

    public void loadWordle() {
        loadFXML("wordle-board");
    }

    public void loadMemory() {
        loadFXML("memory");
    }

    public void loadMemoryMenu() {
        loadFXML("menu");
    }

    private void loadFXML(String fxmlFile) {
        try {
            final Scene scene = FXMLLoader.load(Objects.requireNonNull(getClass()
                    .getResource("fxml/" + fxmlFile + ".fxml")));
            mainStage.setScene(scene);
            if (fxmlFile.equals("wordle-board")) {
                scene.setOnKeyPressed(e -> WordleController.getInstance().handleKeys(e));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public static Difficulty getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(Difficulty difficulty) {
        Main.difficulty = difficulty;
    }
}