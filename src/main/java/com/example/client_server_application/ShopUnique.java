package com.example.client_server_application;

public class ShopUnique {
    private static ShopUnique instance = null;
    private int shopId;

    private ShopUnique() {
    }

    public static ShopUnique getInstance() {
        if (instance == null) {
            instance = new ShopUnique();
        }
        return instance;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getShopId() {
        return this.shopId;
    }
}
