module dev.javafx.downloadmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.javafx.downloadmanager to javafx.fxml;
    exports dev.javafx.downloadmanager;
}