module me.julie.gamecenter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens me.julie.gamecenter to javafx.fxml;
    exports me.julie.gamecenter;
    exports me.julie.gamecenter.Minesweeper;
    opens me.julie.gamecenter.Minesweeper to javafx.fxml;
    exports me.julie.gamecenter.Wordle;
    opens me.julie.gamecenter.Wordle to javafx.fxml;
    exports me.julie.gamecenter.Memory;
    opens me.julie.gamecenter.Memory to javafx.fxml;
    exports me.julie.gamecenter.Simon;
    opens me.julie.gamecenter.Simon to javafx.fxml;
}