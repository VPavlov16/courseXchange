package com.example.coursexchange;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox<String> comboBoxType = new ComboBox<>();
    @FXML
    private ComboBox<String> comboBoxSubject = new ComboBox<>();

    @FXML
    void initialize() {
        comboBoxType.getItems().removeAll(comboBoxType.getItems());
        comboBoxType.getItems().addAll("Website", "Game", "App","RC Project","Website Game");
        comboBoxSubject.getItems().removeAll(comboBoxSubject.getItems());
        comboBoxSubject.getItems().addAll("DataBase","Web Design","Software Development","OOP Exercise","OOP","OS","MOP");
    }

    //all links to other scenes
    @FXML
    private void loadReg(ActionEvent ae) throws IOException{
        root = FXMLLoader.load(getClass().getResource("reg.fxml"));

        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.getIcons().add(new Image("file:logo_black.png"));



    }
    @FXML
    private void loadLog(ActionEvent ae) throws IOException{
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    private void loadPost(ActionEvent ae) throws IOException{
        root = FXMLLoader.load(getClass().getResource("upload.fxml"));

        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.getIcons().add(new Image("file:logo_black.png"));



    }
    @FXML
    private void loadHome(ActionEvent ae) throws IOException{
        root = FXMLLoader.load(getClass().getResource("BlackMarket_homepage.fxml"));

        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.getIcons().add(new Image("file:logo_black.png"));



    }

}
