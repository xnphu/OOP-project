package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutUsController implements Initializable {

    @FXML
    private Label about;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        about.setText("\tMember of Team: \n\n"+"Xuan Phu Nguyen\nEmail: immrp188@gmail.com\n\n"+"Hoang Hiep Nguyen\nEmail: darkhader@gmail.com");
    }
}
