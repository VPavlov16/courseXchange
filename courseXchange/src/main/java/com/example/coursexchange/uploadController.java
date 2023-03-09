package com.example.coursexchange;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;

public class uploadController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private ComboBox<String> comboBoxType = new ComboBox<>();
    @FXML
    private ComboBox<String> comboBoxSubject = new ComboBox<>();

    @FXML
    private TextArea projDescr;

    @FXML
    private TextField projPrice;

    @FXML
    private TextField projTitle;

    @FXML
    private Button submitButton;



    //fill db
    @FXML
    public void post(ActionEvent event) throws SQLException, IOException {

        Window owner = submitButton.getScene().getWindow();

        //errors
        if (projTitle.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter project title!");
            return;
        }
        if (String.valueOf(comboBoxType).isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter project type!");
            return;
        }
        if (String.valueOf(comboBoxSubject).isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter project subject!");
            return;
        }
        if (projDescr.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter project description!");
            return;
        }
        if (projPrice.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter project price!");
            return;
        }
        System.out.println(comboBoxType.getValue());
        System.out.println(comboBoxSubject.getValue());



        String title = projTitle.getText();
        String type = comboBoxType.getValue();
        String subject = comboBoxSubject.getValue();
        String description = projDescr.getText();
        String price = projPrice.getText();
        int aidi = jdbc.uid;


        jdbc jdbc = new jdbc();
        jdbc.insertAnn(title,type,subject,description, Double.parseDouble(price),aidi);


        showAlert(Alert.AlertType.CONFIRMATION, owner, "Upload Successful!",
                "Wish you luck with " + title);

        //redirect to login
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    //alerts
    //alerts
    private static void showAlert(Alert.AlertType alertType, Window owner,String title,String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    //fill comboboxes
    @FXML
    void initialize() {
        comboBoxType.getItems().removeAll(comboBoxType.getItems());
        comboBoxType.getItems().addAll("Website","Data Base", "Game", "App","RC Project","Website Game");
        comboBoxSubject.getItems().removeAll(comboBoxSubject.getItems());
        comboBoxSubject.getItems().addAll("DataBase","Web Design","Software Development","OOP Exercise","OOP","OS","MOP");
    }

    //redirections
    @FXML
    private void loadInfo(ActionEvent ae) throws IOException {
        root = FXMLLoader.load(getClass().getResource("postInfo.fxml"));

        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.getIcons().add(new Image("file:logo_black.png"));

    }
    @FXML
    private void loadHome(ActionEvent ae) throws IOException {
        root = FXMLLoader.load(getClass().getResource("BlackMarket_homepage.fxml"));

        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }



}