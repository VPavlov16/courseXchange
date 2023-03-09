package com.example.coursexchange;
import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class regController {
    private Stage stage;
    private Scene scene;
    private Parent root;

        @FXML
        private TextField email;

        @FXML
        private TextField fName;

        @FXML
        private TextField lName;

        @FXML
        private TextField pNumber;

        @FXML
        private PasswordField pass;

        @FXML
        private TextField userName;

        @FXML
        private Button submitButton;


    // redirect to login
    @FXML
    private void loadLog(ActionEvent ae) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    //register
    @FXML
    public void register(ActionEvent event) throws SQLException, IOException {

        Window owner = submitButton.getScene().getWindow();

        //errors
        if (fName.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter your first name!");
            return;
        }
        if (lName.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter your last name!");
            return;
        }
        if (userName.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter your username!");
            return;
        }
        if (pNumber.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter your phone number!");
            return;
        }
        if (email.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter your email!");
            return;
        }
        if (pass.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter your password!");
            return;
        }

        String firstName = fName.getText();
        String lastName = lName.getText();
        String UserName = userName.getText();
        String phoneNum = pNumber.getText();
        String emailche = email.getText();
        String password = pass.getText();

        jdbc jdbc = new jdbc();
        jdbc.insertRecords(firstName,lastName,UserName,phoneNum,emailche,password);

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + fName.getText());

        //redirect to login
            root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

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

}
