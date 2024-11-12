package com.example.client_server_application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController {
    @FXML
    private TextField login_field;
    @FXML
    private PasswordField password_field;
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField str1_1;
    @FXML
    private TextField str1_2;
    @FXML
    private TextField str1_3;
    @FXML
    private TextField str2_1;
    @FXML
    private TextField str2_2;
    @FXML
    private TextField str2_3;
    @FXML
    private TextField str3_1;
    @FXML
    private TextField str3_2;
    @FXML
    private TextField str3_3;

    public void switchToSceneSignUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneUpdatePassword(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("change-password.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneGL(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneHome(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        String login = login_field.getText().trim();
        String password = password_field.getText().trim();

        if (login.isEmpty() || password.isEmpty()) {
            System.out.println("Неверный логин или пароль!");
            return;
        }

        if (loginUser(login, password)) {
            Parent root = FXMLLoader.load(getClass().getResource("bicycle-list.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    public void switchToMagazin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("shop-list.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goSpisok(ActionEvent event) throws SQLException, ClassNotFoundException {

        DataBase dataBase = new DataBase();
        List<BicycleModels> bicycles = dataBase.getBicycles();

        if (!bicycles.isEmpty()) {
            str1_1.setText(bicycles.get(0).getName());
            str1_2.setText(bicycles.get(0).getType());
            str1_3.setText(bicycles.get(0).getNumber_of_gears());

        }

        if (!bicycles.isEmpty()) {
            str2_1.setText(bicycles.get(1).getName());
            str2_2.setText(bicycles.get(1).getType());
            str2_3.setText(bicycles.get(1).getNumber_of_gears());
        }

        if (!bicycles.isEmpty()) {
            str3_1.setText(bicycles.get(2).getName());
            str3_2.setText(bicycles.get(2).getType());
            str3_3.setText(bicycles.get(2).getNumber_of_gears());
        }

    }


    @FXML
    void initialize() {

    }

    @FXML
    public void handleButtonRent1(ActionEvent event) throws IOException {
        BicycleUnique.getInstance().setBicycleId(1);
        switchToMagazin(event);
    }

    @FXML
    public void handleButtonRent2(ActionEvent event) throws IOException {
        BicycleUnique.getInstance().setBicycleId(2);
        switchToMagazin(event);
    }

    @FXML
    public void handleButtonRent3(ActionEvent event) throws IOException {
        BicycleUnique.getInstance().setBicycleId(3);
        switchToMagazin(event);
    }

    private boolean loginUser(String loginText, String passwordText) throws SQLException, ClassNotFoundException {
        DataBase dataBase = new DataBase();
        UserModel userModel = new UserModel();
        userModel.setUserName(loginText);
        userModel.setPassword(passwordText);
        ResultSet result = dataBase.getUser(userModel);
        ClientUnique.getInstance().setClientId(dataBase.getClientIdByUsername(loginText));
        int count = 0;
        while (result.next()) count++;
        if (count >= 1) {
            System.out.println("Вход выполнен!");
            return true;
        } else {
            System.out.println("Неверные логин или пароль!");
            return false;
        }
    }
}