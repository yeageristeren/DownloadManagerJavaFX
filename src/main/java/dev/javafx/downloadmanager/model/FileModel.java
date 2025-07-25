package dev.javafx.downloadmanager.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FileModel {
    private SimpleStringProperty name=new SimpleStringProperty();
    private SimpleStringProperty url=new SimpleStringProperty();
    private SimpleIntegerProperty sno=new SimpleIntegerProperty();
    private SimpleStringProperty status=new SimpleStringProperty();
    private SimpleStringProperty action=new SimpleStringProperty();
    private SimpleStringProperty path=new SimpleStringProperty();

    public FileModel(String name, String url, int sno, String status, String action, String path) {
        this.name.set(name);
        this.url.set(url);
        this.sno.set(sno);
        this.status.set(status);
        this.action.set(action);
        this.path.set(path);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
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

    public int getSno() {
        return sno.get();
    }

    public SimpleIntegerProperty snoProperty() {
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
        this.sno.set(sno);
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

    public String getAction() {
        return action.get();
    }

    public SimpleStringProperty actionProperty() {
        return action;
    }

    public void setAction(String action) {
        this.action.set(action);
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "name=" + name +
                ", url=" + url +
                ", sno=" + sno +
                ", status=" + status +
                ", action=" + action +
                ", path=" + path +
                '}';
    }
}
