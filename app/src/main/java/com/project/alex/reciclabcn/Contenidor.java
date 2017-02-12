package com.project.alex.reciclabcn;

/**
 * Created by alexbruch on 11/2/17.
 */

public class Contenidor {
    private String name, color;
    private int thumbnail;

    public Contenidor() {
    }

    public Contenidor(String name, String color, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
