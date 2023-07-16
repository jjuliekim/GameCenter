package me.julie.gamecenter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class GameCenterController {
    @FXML
    private Label gameName;
    @FXML
    private ImageView image;
    @FXML
    private Button prevButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button playButton;

    private int gameIndex;
    private ArrayList<String> listOfGames = null;
    private ArrayList<String> listOfImages = null;

    @FXML
    public void initialize() {
        prevButton.setFocusTraversable(false);
        gameIndex = 0;
        listOfGames = new ArrayList<>(Arrays.asList("Minesweeper", "Wordle", "Simon", "Memory Game", "Battleship"));
        listOfImages = new ArrayList<>(Arrays.asList("images/minesweeperPic.png", "images/wordlePic.jpg",
                "images/simonPic.jpg", "images/memoryPic.png", "images/battleshipPic2.jpg"));
        gameName.setText(listOfGames.get(gameIndex));
        image.setImage(Main.getImage(listOfImages.get(gameIndex)));

        prevButton.setOnAction(e -> {
            if (gameIndex == 0) {
                gameIndex = listOfGames.size() - 1;
            } else {
                gameIndex--;
            }
            gameName.setText(listOfGames.get(gameIndex));
            image.setImage(Main.getImage(listOfImages.get(gameIndex)));
        });

        nextButton.setOnAction(e -> {
            if (gameIndex == listOfGames.size() - 1) {
                gameIndex = 0;
            } else {
                gameIndex++;
            }
            gameName.setText(listOfGames.get(gameIndex));
            image.setImage(Main.getImage(listOfImages.get(gameIndex)));
        });

        playButton.setOnAction(e -> {
            switch (gameIndex) {
                case 0 -> Main.getInstance().loadMinesweeper();
                case 1 -> Main.getInstance().loadWordle();
                case 2 -> Main.getInstance().loadSimon();
                case 3 -> Main.getInstance().loadMemoryMenu();
                default -> {
                }
            }
        });
    }
}