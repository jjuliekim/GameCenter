module me.julie.gamecenter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens me.julie.gamecenter to javafx.fxml;
    exports me.julie.gamecenter;
    exports me.julie.gamecenter.controller;
    opens me.julie.gamecenter.controller to javafx.fxml;
}