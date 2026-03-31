package com.example.androidar.models;

public class Place {
    private String placeId;
    private String name;
    // 다른 필드들을 필요에 따라 추가할 수 있습니다.

    public Place(String placeId, String name) {
        this.placeId = placeId;
        this.name = name;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

