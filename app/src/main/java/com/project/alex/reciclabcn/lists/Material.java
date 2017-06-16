package com.project.alex.reciclabcn.lists;

/**
 * Created by alexbruch on 13/2/17.
 */

public class Material {
    private String material, thumbnail, contenidor;
    private int id;

    public Material() {
    }

    public Material(int id, String material, String thumbnail, String contenidor) {
        this.id = id;
        this.material = material;
        this.thumbnail = thumbnail;
        this.contenidor = contenidor;
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
}
