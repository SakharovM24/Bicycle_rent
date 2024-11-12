package com.example.client_server_application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangePasswordController {
    private Stage stage;
    private Scene scene;
    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField oldPassword;
    @FXML
    private TextField login;

    public void switchToSceneGlavnaya(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneGlavnaya1(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        test();
        String login = this.login.getText().trim();
        String oldPass = oldPassword.getText().trim();
        String newPass = newPassword.getText().trim();

        if (oldPass.isEmpty() || newPass.isEmpty() || login.isEmpty()) {
            System.out.println("Неверно введен старый пароль, логин или неверный новый пароль!");
            return;
        }

        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void test() throws SQLException, ClassNotFoundException {
        DataBase dataBase = new DataBase();
        UserModel userModel = new UserModel();
        userModel.setUserName(login.getText());
        userModel.setPassword(oldPassword.getText());
        ResultSet result = dataBase.getUser(userModel);

        int count = 0;
        while (result.next()) count++;
        if (count >= 1) {
            dataBase.changePasswordByUsername(login.getText(), newPassword.getText());
        } else {
            System.out.println("Неверно введенные данные!");
        }
    }
}
