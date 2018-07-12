package com.project.alex.reciclabcn;

/**
 * Created by alexbruch on 13/2/17.
 */

public class Material {
    private String material, thumbnail, contenidor, localitzacio, description, cubo, color1, color2;
    private int id;

    public Material() {
    }

    public Material(int id, String material, String thumbnail, String contenidor,String cubo, String color1, String color2, String localitzacio, String description) {
        this.id = id;
        this.material = material;
        this.thumbnail = thumbnail;
        this.contenidor = contenidor;
        this.localitzacio = localitzacio;
        this.description = description;
        this.cubo = cubo;
        this.color1 = color1;
        this.color2 = color2;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenidor() {
        return contenidor;
    }

    public void setContenidor(String contenidor) {
        this.contenidor = contenidor;
    }

    public String getLocalitzacio() {
        return localitzacio;
    }

    public void setLocalitzacio(String localitzacio) {
        this.localitzacio = localitzacio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCubo() {
        return cubo;
    }

    public void setCubo(String cubo) {
        this.cubo = cubo;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }
}
