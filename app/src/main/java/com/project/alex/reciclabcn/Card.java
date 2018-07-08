package com.project.alex.reciclabcn;

/**
 * Created by alexbruch on 11/2/17.
 */

public class Card {
    public String id = "", thumbnail = "", name = "", color1 = "", color2 = "";

    public Card() {
    }

    public Card(String id, String name, String color1, String color2, String thumbnail) {
        this.id = id;
        this.name = name;
        this.color1 = color1;
        this.color2 = color2;
        this.thumbnail = thumbnail;

    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }
}
