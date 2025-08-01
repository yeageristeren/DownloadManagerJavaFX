package dev.javafx.downloadmanager.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FileModel {
    private SimpleStringProperty name=new SimpleStringProperty();
    private SimpleStringProperty url=new SimpleStringProperty();
    private SimpleStringProperty sno=new SimpleStringProperty();
    private SimpleStringProperty status=new SimpleStringProperty();
    private SimpleStringProperty path=new SimpleStringProperty();
    private SimpleStringProperty percent=new SimpleStringProperty();

    public FileModel(String name, String url, int sno, String status, String action, String path,double per) {
        this.name.set(name);
        this.url.set(url);
        this.sno.set(Integer.toString(sno));
        this.status.set(status);
        this.path.set(path);
        this.percent.set(Double.toString(per));}

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setSno(String sno) {
        this.sno.set(sno);
    }

    public String getPercent() {
        return percent.get();
    }

    public SimpleStringProperty percentProperty() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent.set(percent);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getUrl() {
        return url.get();
    }

    public SimpleStringProperty urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public String getSno() {
        return sno.get();
    }

    public SimpleStringProperty snoProperty() {
        return sno;
    }

    public String getPath() {
        return path.get();
    }

    public SimpleStringProperty pathProperty() {
        return path;
    }

    public void setPath(String path) {
        this.path.set(path);
    }

    public void setSno(int sno) {
        this.sno.set(Integer.toString(sno));
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "name=" + name +
                ", url=" + url +
                ", sno=" + sno +
                ", status=" + status +
                ", path=" + path +
                '}';
    }
}
