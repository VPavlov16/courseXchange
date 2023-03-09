package com.example.coursexchange;

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

public class profController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField usernameField;

    @FXML TextField numberField;



    //getInfo
    @FXML
    void initialize() {
        firstNameField.setText(jdbc.firstName);
        lastNameField.setText(jdbc.lastName);
        usernameField.setText(jdbc.userName);
        emailField.setText(jdbc.email);
        numberField.setText(jdbc.phoneNum);
    }


    //redirections
    @FXML
    void loadFavs(ActionEvent ae) throws IOException {
        this.root = (Parent) FXMLLoader.load(this.getClass().getResource("wishlist.fxml"));
        this.stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();

    }

    @FXML
    private void loadHome(ActionEvent ae) throws IOException {
        this.root = (Parent) FXMLLoader.load(this.getClass().getResource("BlackMarket_homepage.fxml"));
        this.stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
