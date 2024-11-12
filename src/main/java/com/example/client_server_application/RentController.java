package com.example.client_server_application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RentController {
    @FXML
    private TextField str1_1;

    @FXML
    private TextField str1_2;
    private Stage stage;
    private Scene scene;


    @FXML
    void goNext(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("refund.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToMagazin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("shop-list.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saveValues() throws SQLException, ClassNotFoundException {
        String value1 = str1_1.getText();
        String value2 = str1_2.getText();
        RentModel rents = new RentModel();

        rents.setDate_receipt(value1);
        rents.setDate_return(value2);

        DataBase dataBase = new DataBase();
        rents.setClient_id(dataBase.getClientIdByUsername(value1));
        dataBase.addRent(rents);
        System.out.println("Вы арендовали велосипед!");
    }

    @FXML
    void initialize() {
    }
}
