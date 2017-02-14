package com.project.alex.reciclabcn.cards;

/**
 * Created by alexbruch on 11/2/17.
 */

public class Card {
    private String name, color, color2;
    private int thumbnail;

    public Card() {
    }

    public Card(String name, String color, String color2, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.color = color;
        this.color2 = color2;
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

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }
}
