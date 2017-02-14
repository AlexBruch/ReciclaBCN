package com.project.alex.reciclabcn.lists;

/**
 * Created by alexbruch on 13/2/17.
 */

public class Material {
    private String material;
    private int thumbnail;

    public Material() {
    }

    public Material(String material, int thumbnail) {
        this.material = material;
        this.thumbnail = thumbnail;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
