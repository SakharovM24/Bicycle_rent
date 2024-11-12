package com.example.client_server_application;

public class ClientModel {
    public String name;
    public String passport;
    public String address;

    public ClientModel(String name, String passport, String address) {
        this.name = name;
        this.passport = passport;
        this.address = address;
    }

    public ClientModel() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    public String getAddress() {
        return address;
    }
}
