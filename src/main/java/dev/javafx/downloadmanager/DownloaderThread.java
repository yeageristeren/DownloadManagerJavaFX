package dev.javafx.downloadmanager;

import dev.javafx.downloadmanager.config.AppConfig;
import dev.javafx.downloadmanager.model.FileModel;

import java.io.IOException;
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
            Files.copy(new URL(this.file.getUrl()).openStream(), Path.of(this.file.getPath()));
            this.file.setStatus("DONE");
        } catch (IOException e) {
            System.out.println("Downloading error");
            System.out.println(e.getStackTrace());
            this.file.setStatus("FAILED");
        }
        this.controller.update(this.file);
    }
}
