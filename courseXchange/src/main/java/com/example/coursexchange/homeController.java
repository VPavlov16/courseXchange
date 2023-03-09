package com.example.coursexchange;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class homeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void loadProfile(ActionEvent ae) throws IOException {
        root = FXMLLoader.load(getClass().getResource("profile.fxml"));

        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    private void loadHome(ActionEvent ae) throws IOException {
        root = FXMLLoader.load(getClass().getResource("BlackMarket_homepage.fxml"));

        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    private void upload(ActionEvent ae) throws IOException {
        root = FXMLLoader.load(getClass().getResource("upload.fxml"));

        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void loadFavs(ActionEvent ae) throws IOException {
        root = FXMLLoader.load(getClass().getResource("wishlist.fxml"));

        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}
