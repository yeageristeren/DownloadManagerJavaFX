package dev.javafx.downloadmanager;

import dev.javafx.downloadmanager.config.AppConfig;
import dev.javafx.downloadmanager.model.FileModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;

public class Controller {
    private int index = 0;
    @FXML
    TextField urlTextField;

    @FXML
    private void downloadFile(ActionEvent event){
        String url=urlTextField.getText();
        String name = url.substring(url.lastIndexOf("/")+1);
        System.out.println(name);
        String status = "STARTING";
        String action = "Open";
        String path = AppConfig.downloadPath+ File.separator+name;
        FileModel fileModel = new FileModel(name,url,index,status,action,path);
        index++;
        DownloaderThread downloaderThread = new DownloaderThread(this,fileModel);
        downloaderThread.start();
    }

    public void update(FileModel file) {
        System.out.println(file.toString());
    }
}