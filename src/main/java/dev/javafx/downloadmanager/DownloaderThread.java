package dev.javafx.downloadmanager;

import dev.javafx.downloadmanager.config.AppConfig;
import dev.javafx.downloadmanager.model.FileModel;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;

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
                this.controller.update(file);
                return;
            }
//            else {
//                Files.copy(new URL(this.file.getUrl()).openStream(), filePath);
//               this.file.setStatus("DONE");
//
//            }
            URL url = new URL(this.file.getUrl());
            URLConnection connection = url.openConnection();
            double per = 0.0;
            int size = connection.getContentLength();
            int sizeRead = 0;
            double readSum=0.0;
            BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());
            FileOutputStream outputStream = new FileOutputStream(this.file.getPath());
            byte data[] = new byte[1024];

            while(true){
                sizeRead = inputStream.read(data, 0, 1024);
                if(sizeRead==-1){break;}
                outputStream.write(data,0,sizeRead);
                readSum+=sizeRead;
                per = (readSum/size)*100;
                DecimalFormat formatter = new DecimalFormat("0.00");
                this.file.setPercent(formatter.format(per));
            }
            this.file.setStatus("DONE");
            this.controller.update(this.file);
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }}
