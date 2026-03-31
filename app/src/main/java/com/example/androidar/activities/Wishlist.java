package com.example.androidar.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidar.R;

import java.util.ArrayList;

public class Wishlist {
    private int furnitureImage;
    private String furnitureName;
    private String furnitureDescription;

    ArrayList<Wishlist> wishlist = new ArrayList<>();


    public Wishlist(int image, String name, String description) {
        this.furnitureImage = image;
        this.furnitureName = name;
        this.furnitureDescription = description;
    }

    public int getFurnitureImage() {
        return furnitureImage;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public String getFurnitureDescription() {
        return furnitureDescription;
    }


}
