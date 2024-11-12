package com.example.client_server_application;

public class ShopModel {
    public ShopModel(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public ShopModel() {

    }

    private String name;

    private String adress;

    private String id_magazin;

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setId_magazin(String id_magazin) {
        this.id_magazin = id_magazin;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getId_magazin() {
        return id_magazin;
    }
}
