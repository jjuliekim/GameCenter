package me.julie.gamecenter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import me.julie.gamecenter.Main;

import java.util.ArrayList;
import java.util.Arrays;

public class GameCenterController {
    @FXML
    private VBox mainVBox;
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
        mainVBox.setStyle("-fx-background-color: #fdeee6");
        gameIndex = 0;
        listOfGames = new ArrayList<>(Arrays.asList("Minesweeper", "Wordle", "Simon", "Battleship", "Memory Game"));
        listOfImages = new ArrayList<>(Arrays.asList("minesweeperPic.png", "wordlePic.jpg", "simonPic.jpg",
                "battleshipPic2.png", "memoryPic2.png"));
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
                case 0:
                    Main.getInstance().getStage().getScene()
                            .setRoot(Main.getInstance().getMinesweeperScene());
                    break;
                case 1:
                    Main.getInstance().getStage().getScene()
                            .setRoot(Main.getInstance().getWordleScene());
                    break;
                case 2:
                    Main.getInstance().getStage().getScene()
                            .setRoot(Main.getInstance().getSimonScene());
                    break;
                default:
                    break;
            }
        });
    }
}