package dev.javafx.downloadmanager;

import dev.javafx.downloadmanager.config.AppConfig;
import dev.javafx.downloadmanager.model.FileModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private int index = 0;
    @FXML
    TextField urlTextField;
    @FXML
    TableView<FileModel> tableView;

    @FXML
    private void downloadFile(ActionEvent event){
        if(urlTextField.getText().equals("")){return;}
        String url=urlTextField.getText();
        String name = url.substring(url.lastIndexOf("/")+1);
        System.out.println(name);
        String status = "STARTING";
        String action = "Open";
        String path = AppConfig.downloadPath+ File.separator+name;
        FileModel fileModel = new FileModel(name,url,index,status,action,path);
        DownloaderThread downloaderThread = new DownloaderThread(this,fileModel);
        tableView.getItems().add(fileModel);
        index++;
        downloaderThread.start();
        urlTextField.setText("");
    }

    public void update(FileModel file) {
        System.out.println(file.toString());
        FileModel row = tableView.getItems().get(Integer.parseInt(file.getSno()));
        row.setStatus(file.getStatus());
        tableView.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn<FileModel,String> sno = (TableColumn<FileModel, String>) tableView.getColumns().get(0);
        sno.setCellValueFactory(e->{
            return e.getValue().snoProperty();
        });
        TableColumn<FileModel,String> fileName = (TableColumn<FileModel, String>) tableView.getColumns().get(1);
        fileName.setCellValueFactory(e->{
            return e.getValue().nameProperty();
        });
        TableColumn<FileModel,String> fileURL = (TableColumn<FileModel, String>) tableView.getColumns().get(2);
        fileURL.setCellValueFactory(e->{
            return e.getValue().urlProperty();
        });
        TableColumn<FileModel,String> status= (TableColumn<FileModel, String>) tableView.getColumns().get(3);
        status.setCellValueFactory(e->{
            return e.getValue().statusProperty();
        });
        TableColumn<FileModel,String> action = (TableColumn<FileModel, String>) tableView.getColumns().get(4);
        action.setCellValueFactory(e->{
            return e.getValue().actionProperty();
        });
        System.out.println("index initialised");
    }
}