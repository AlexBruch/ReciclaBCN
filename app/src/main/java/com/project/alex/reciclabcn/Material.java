package com.project.alex.reciclabcn;

/**
 * Created by alexbruch on 13/2/17.
 */

public class Material {
    private String material, thumbnail, contenidor, localitzacio, description;
    private int id;

    public Material() {
    }

    public Material(int id, String material, String thumbnail, String contenidor, String localitzacio, String description) {
        this.id = id;
        this.material = material;
        this.thumbnail = thumbnail;
        this.contenidor = contenidor;
        this.localitzacio = localitzacio;
        this.description = description;
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
}
