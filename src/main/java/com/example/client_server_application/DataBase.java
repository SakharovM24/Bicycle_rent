package com.example.client_server_application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost/db_course_project";
        String username = "root";
        String password = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(url, username, password);
        return dbConnection;
    }

    // sql запрос
    public void signUpUser(UserModel userModel, ClientModel clientModel)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO users (client_id, userName, password) VALUES (?,?,?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        preparedStatement.setInt(1, findClientIdByName(clientModel.getName()));
        preparedStatement.setString(2, userModel.getUserName());
        preparedStatement.setString(3, userModel.getPassword());
        preparedStatement.executeUpdate();
    }

    public void addClients(ClientModel clientModel) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO clients (name, passport, address) VALUES (?,?,?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        preparedStatement.setString(1, clientModel.name);
        preparedStatement.setString(2, clientModel.passport);
        preparedStatement.setString(3, clientModel.address);
        preparedStatement.executeUpdate();
    }

    public int findClientIdByName(String clientName) throws SQLException, ClassNotFoundException {
        String select = "SELECT id FROM clients WHERE name = ?";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        preparedStatement.setString(1, clientName);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("id");
        } else {
            return -1;
        }
    }

    public void fetchClientId(String clientName) throws SQLException, ClassNotFoundException {
        String select = "SELECT id FROM clients WHERE name = ?";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        preparedStatement.setString(1, clientName);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int clientId = resultSet.getInt("id");
            ClientUnique.getInstance().setClientId(clientId);
            ClientUnique.getInstance().setClientId(clientId);
        }
    }


    public ResultSet getUser(UserModel userModel) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + "users" + " WHERE " +
                "userName" + "=? AND " + "password" + "=?";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        preparedStatement.setString(1, userModel.getUserName());
        preparedStatement.setString(2, userModel.getPassword());

        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public void changePasswordByUsername(String username, String newPassword) throws SQLException, ClassNotFoundException {
        String update = "UPDATE " + "users" + " SET " + "password" + "=? WHERE " + "userName" + "=?";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
        preparedStatement.setString(1, newPassword);
        preparedStatement.setString(2, username);

        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Вы изменили пароль!");
        } else {
            System.out.println("Пользователь не найден!");
        }

    }

    public List<BicycleModels> getBicycles() throws SQLException, ClassNotFoundException {
        List<BicycleModels> bicycles = new ArrayList<>();

        String select = "SELECT * FROM models_bicycle";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String type = resultSet.getString("type");
            String number_of_gears = resultSet.getString("num_of_gears");

            BicycleModels bicycle = new BicycleModels(name, type, number_of_gears);
            bicycles.add(bicycle);
        }

        return bicycles;
    }

    public List<ShopModel> getMagazin() throws SQLException, ClassNotFoundException {
        List<ShopModel> shopModels = new ArrayList<>();

        String select = "SELECT * FROM shops";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            ShopModel shopModel = new ShopModel(name, address);
            shopModels.add(shopModel);
        }

        return shopModels;
    }

    public void addRent(RentModel rentModel) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO rents (client_id, bicycle_id, shop_id, date_receipt, date_return) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        preparedStatement.setInt(1, ClientUnique.getInstance().getClientId());
        preparedStatement.setInt(2, BicycleUnique.getInstance().getBicycleId());
        preparedStatement.setInt(3, ShopUnique.getInstance().getShopId());
        preparedStatement.setString(4, rentModel.getDate_receipt());
        preparedStatement.setString(5, rentModel.getDate_return());
        preparedStatement.executeUpdate();
    }

    public int getClientIdByUsername(String username) throws SQLException, ClassNotFoundException {
        String select = "SELECT client_id FROM users WHERE userName=?";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("client_id");
        } else {
            return 0;
        }
    }
}
