package com.example.androidar.models;

public class Store {
    private String storeName;
    private String storeDescription;
    private int storeImage;
    // 추가적인 가구 속성들...

    public Store(String storeName, String storeDescription, int storeImage) {
        this.storeName = storeName;
        this.storeDescription = storeDescription;
        this.storeImage = storeImage;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreDescription() {
        return storeDescription;
    }
    public Integer getStoreImage() { return storeImage;}

    // 추가적인 getter 및 setter 메서드들...

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + storeName + '\'' +
                ", storeDescription='" + storeDescription + '\'' +
                // 추가적인 가구 속성들...
                '}';
    }
}
