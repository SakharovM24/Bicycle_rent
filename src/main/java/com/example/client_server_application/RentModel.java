package com.example.client_server_application;

public class RentModel {
    public RentModel(int client_id, String bicycle_id, String shop_id, String date_receipt, String date_return) {
        this.client_id = client_id;
        this.bicycle_id = bicycle_id;
        this.shop_id = shop_id;
        this.date_receipt = date_receipt;
        this.date_return = date_return;
    }

    public RentModel() {

    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public void setBicycle_id(String bicycle_id) {
        this.bicycle_id = bicycle_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public void setDate_receipt(String date_receipt) {
        this.date_receipt = date_receipt;
    }

    public void setDate_return(String date_return) {
        this.date_return = date_return;
    }

    public int getClient_id() {
        return client_id;
    }

    public String getBicycle_id() {
        return bicycle_id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public String getDate_receipt() {
        return date_receipt;
    }

    public String getDate_return() {
        return date_return;
    }

    private int client_id;
    private String bicycle_id;
    private String shop_id;
    private String date_receipt;
    private String date_return;
}
