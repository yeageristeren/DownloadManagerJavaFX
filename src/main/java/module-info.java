module dev.javafx.downloadmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens dev.javafx.downloadmanager to javafx.fxml;
    exports dev.javafx.downloadmanager;
}