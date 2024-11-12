package com.example.client_server_application;

public class BicycleModels {

    String name;
    String type;
    String number_of_gears;
    String id_model_bicycle;

    public BicycleModels(String name, String type, String number_of_gears) {
        this.name = name;
        this.type = type;
        this.number_of_gears = number_of_gears;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumber_of_gears(String number_of_gears) {
        this.number_of_gears = number_of_gears;
    }

    public void setId_model_bicycle(String id_model_bicycle) {
        this.id_model_bicycle = id_model_bicycle;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getNumber_of_gears() {
        return number_of_gears;
    }

    public String getId_model_bicycle() {
        return id_model_bicycle;
    }
}
