package com.example.client_server_application;

public class BicyclesModel {
    public BicyclesModel(String bicycles_id, String models_bicycles_id) {
        this.bicycles_id = bicycles_id;
        this.models_bicycles_id = models_bicycles_id;
    }

    public BicyclesModel() {

    }

    public void setBicycles_id(String bicycles_id) {
        this.bicycles_id = bicycles_id;
    }

    public void setModels_bicycles_id(String models_bicycles_id) {
        this.models_bicycles_id = models_bicycles_id;
    }

    public String getBicycles_id() {
        return bicycles_id;
    }

    public String getModels_bicycles_id() {
        return models_bicycles_id;
    }

    private String bicycles_id;
    private String models_bicycles_id;


}
