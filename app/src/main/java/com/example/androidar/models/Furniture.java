package com.example.androidar.models;

import java.io.Serializable;

public class Furniture implements Serializable {
    private int furnitureImage;
    private String furnitureName;
    private String furniturePrice;
    private String furnitureManufacture;
    private String furnitureDescription;
    private String item3D;
    private boolean isFavorite; // 찜 상태 여부

    public Furniture(int furnitureImage, String furnitureName, String furniturePrice, String furnitureManufacture, String furnitureDescription, String item3D) {
        this.furnitureImage = furnitureImage;
        this.furnitureName = furnitureName;
        this.furniturePrice = furniturePrice;
        this.furnitureManufacture = furnitureManufacture;
        this.furnitureDescription = furnitureDescription;
        this.item3D = item3D;
        this.isFavorite = false; // 초기에는 찜되지 않은 상태로 초기화
    }

    public String getItem3D() {
        return item3D;
    }

    public void setItem3D(String item3D) {
        this.item3D = item3D;
    }

    public int getFurnitureImage() {
        return furnitureImage;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public String getFurniturePrice() {
        return furniturePrice;
    }

    public String getFurnitureManufacture() {
        return furnitureManufacture;
    }

    public String getFurnitureDescription() {
        return furnitureDescription;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
