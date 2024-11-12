package com.example.client_server_application;

public class BicycleUnique {
    private static BicycleUnique instance = null;
    private int bicycleId;

    private BicycleUnique() {
    }

    public static BicycleUnique getInstance() {
        if (instance == null) {
            instance = new BicycleUnique();
        }
        return instance;
    }

    public void setBicycleId(int bicycleId) {
        this.bicycleId = bicycleId;
    }

    public int getBicycleId() {
        return this.bicycleId;
    }

}
