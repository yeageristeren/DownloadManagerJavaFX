package dev.javafx.downloadmanager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("DownloadManager.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Download Manager");
        stage.getIcons().add(new Image("img.png"));
        stage.setOnCloseRequest(e -> {
            exit(e);
        });
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }

    public void exit(Event event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText("Are you sure you want to exit?");
        alert.setContentText("Any ongoing downloads may be interrupted.");
        if(alert.showAndWait().get()!= ButtonType.OK){
            event.consume();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}