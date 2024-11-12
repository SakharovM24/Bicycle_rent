package com.example.client_server_application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpLogin;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpPassport;
    @FXML
    private TextField signUpAddress;

    @FXML
    private TextField signUpPassword;
    private Stage stage;
    private Scene scene;

    public void switchToSceneGL(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        signUpButton.setOnAction(event -> {
            try {
                if (signUpLastName.getText().isEmpty() || signUpLogin.getText().isEmpty() ||
                        signUpName.getText().isEmpty() || signUpPassword.getText().isEmpty() || signUpPassport.getText().isEmpty()
                        || signUpAddress.getText().isEmpty()) {
                    System.out.println("Неверные данные!");
                    return;
                }
                signUpNewUser();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Регистрация прошла успешно!");
        });
    }

    private void signUpNewUser() throws SQLException, ClassNotFoundException {
        DataBase dataBase = new DataBase();

        String name = signUpName.getText() + " " + signUpLastName.getText();
        String passport = signUpPassport.getText();
        String address = signUpAddress.getText();

        String userName = signUpLogin.getText();
        String password = signUpPassword.getText();

        UserModel userModel = new UserModel(userName, password);
        ClientModel clientModel = new ClientModel(name, passport, address);

        dataBase.addClients(clientModel);
        dataBase.fetchClientId(name);
        dataBase.signUpUser(userModel, clientModel);
    }
}

