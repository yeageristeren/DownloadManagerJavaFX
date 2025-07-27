package dev.javafx.downloadmanager;

import dev.javafx.downloadmanager.config.AppConfig;
import dev.javafx.downloadmanager.model.FileModel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class DownloaderThread extends Thread {
    Controller controller;
    FileModel file;

    DownloaderThread(Controller controller,FileModel file){
        this.controller=controller;
        this.file=file;
    }

    @Override
    public void run(){
        this.file.setStatus("DOWNLOADING");
        this.controller.update(this.file);
        try {
            Path filePath = Path.of(this.file.getPath());

            if (Files.exists(filePath)) {
                System.out.println("File already exists, skipping download: " + filePath);
                this.file.setStatus("ALREADY EXISTS");
            } else {
                Files.copy(new URL(this.file.getUrl()).openStream(), filePath);
                this.file.setStatus("DONE");

            }
        this.controller.update(this.file);
    } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }}
