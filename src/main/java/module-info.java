module com.lab6.textprocessinganddatamanagementtoolteamproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.lab6.textprocessinganddatamanagementtoolteamproject to javafx.fxml;
    exports com.lab6.textprocessinganddatamanagementtoolteamproject;
}