package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static String[] stringLevel = {"Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6", "Level 7", "Level 8", "Level 9", "Level 10"};

    @FXML
    private ComboBox<String> comboBox;
    ObservableList<String> list = FXCollections.observableArrayList(stringLevel);

    @FXML
    private Label caution;

    @FXML
    private Button startBtn;

    @FXML
    private Button aboutUsBtn;

    public Audio audio = new Audio();
    int level;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.setItems(list);
        comboBox.getValue();
        System.out.println(comboBox.getValue());
    }

    public void buttonAction(javafx.event.ActionEvent event) {
        try {
            System.out.println(comboBox.getValue());
            if (event.getSource() == startBtn) {
                if (comboBox.getValue() != null) {
                    String choice = comboBox.getValue();
                    level = Integer.parseInt(choice.substring(choice.indexOf(" ") + 1, choice.length()));
                    System.out.println(level);
                    audio.setLevel(level);

                    ((Node) event.getSource()).getScene().getWindow().hide();
                    Stage primaryStage = new Stage();
                    FXMLLoader loader = new FXMLLoader();
                    Pane root = loader.load(getClass().getResource("SceneBuilderFile/detail.fxml").openStream());

                    MainController mainController = (MainController) loader.getController();
                    mainController.getAudioFromController(audio);
                    mainController.getLevelFromController(level);

                    primaryStage.setTitle("Listen And Write");
                    primaryStage.setScene(new Scene(root));
                    primaryStage.show();
                }
                if (event.getSource() == startBtn && comboBox.getValue() == null) {
                    caution.setText("Please select level first!!!");
                }
            }
            if (event.getSource() == aboutUsBtn) {
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("SceneBuilderFile/aboutUs.fxml").openStream());
                primaryStage.setTitle("Listen And Write - About Us");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getLevelFromController(int level) {
        this.level = level;
    }

    public void getAudioFromController(Audio audio) {
        this.audio = audio;
    }
}
