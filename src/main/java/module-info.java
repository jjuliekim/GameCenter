module me.julie.gamecenter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens me.julie.gamecenter;
    exports me.julie.gamecenter;
    exports me.julie.gamecenter.minesweeper;
    opens me.julie.gamecenter.minesweeper;
    exports me.julie.gamecenter.wordle;
    opens me.julie.gamecenter.wordle;
    exports me.julie.gamecenter.memory;
    opens me.julie.gamecenter.memory;
    exports me.julie.gamecenter.simon;
    opens me.julie.gamecenter.simon;
}