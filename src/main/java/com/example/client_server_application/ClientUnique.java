package com.example.client_server_application;

public class ClientUnique {
    private static ClientUnique instance = null;
    private int clientId;

    private ClientUnique() {
    }

    public static ClientUnique getInstance() {
        if (instance == null) {
            instance = new ClientUnique();
        }
        return instance;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getClientId() {
        return this.clientId;
    }
}
