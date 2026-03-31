package com.example.androidar.models;

import java.util.ArrayList;
import java.util.List;

public class FurnitureListItem {
    private List<Furniture> furnitureList;

    public FurnitureListItem() {
        furnitureList = new ArrayList<>();
    }

    public void addFurniture(Furniture furniture) {
        furnitureList.add(furniture);
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }
}

