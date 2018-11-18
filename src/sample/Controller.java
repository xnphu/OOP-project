package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static String[] level = {"Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6", "Level 7", "Level 8", "Level 9", "Level 10"};

    @FXML
    private ComboBox<String> comboBox;
    ObservableList<String> list = FXCollections.observableArrayList(level);

    @FXML
    private Button startBtn;

    @FXML
    private Button exitBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.setItems(list);
    }

    public void buttonAction(javafx.event.ActionEvent event) {
        try {
            if(event.getSource() == startBtn) {
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("main.fxml").openStream());
                primaryStage.setTitle("Listen And Write");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }
            if(event.getSource() == exitBtn) {
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
