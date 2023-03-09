package com.example.coursexchange;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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

public class logController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField emailuserField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    //login method
    @FXML
    public void login(ActionEvent event) throws SQLException,IOException{
        Window owner = submitButton.getScene().getWindow();

        //results
        System.out.println(emailuserField.getText());
        System.out.println(passwordField.getText());


        //proverka
        //email/username is empty
        if (emailuserField.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter email or username!");
           return;
        }
        //pass is empty
        if(passwordField.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter your password!");
            return;
        }

        //zadavane
        String emailche = emailuserField.getText();
        String username = emailuserField.getText();
        String password = passwordField.getText();

        jdbc jdbc = new jdbc();
        boolean flag = jdbc.validate(emailche,password,username);



        //info boxes
        if (!flag){
            infoBox("Please enter correct Email and Password",null,"Login failed!");
        }else{
            infoBox("Login Successful!",null,"Login Complete!");
            jdbc.getUsID(emailche,password,username);
        }


        //redirect to home page
        if(flag) {

            root = FXMLLoader.load(getClass().getResource("BlackMarket_homepage.fxml"));

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            stage.getIcons().add(new Image("file:logo_black.png"));
        }
    }


    //login infobox
    public static void infoBox(String infoMessage,String headerText,String title){
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    //alerts
    private static void showAlert(Alert.AlertType alertType, Window owner,String title,String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    //redirections
    @FXML
    private void loadReg(ActionEvent ae) throws IOException {
        root = FXMLLoader.load(getClass().getResource("reg.fxml"));

        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.getIcons().add(new Image("file:logo_black.png"));
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
}
