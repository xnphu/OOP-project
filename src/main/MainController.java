package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private Button playBtn;

    @FXML
    private Button stopBtn;

    @FXML
    private Button checkBtn;

    @FXML
    private TextArea typeAnswer;

    @FXML
    private Label yourAnswer;

    @FXML
    private Label correctAnswer;

    public Audio audio;
    int level;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeAnswer.setWrapText(true);
        yourAnswer.setWrapText(true);
        correctAnswer.setWrapText(true);
    }

    public void buttonAction(ActionEvent event) {
        try {
            if(event.getSource() == backBtn) {
                audio.getAudio().stop();
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                SplitPane root = loader.load(getClass().getResource("SceneBuilderFile/mainMenu.fxml").openStream());
                primaryStage.setTitle("Listen And Write");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }
//            if(event.getSource() == exitBtn) {
//                System.exit(0);
//            }
            if(event.getSource() == playBtn) {
                audio.getAudio().play();
            }
            if(event.getSource() == stopBtn) {
                audio.getAudio().stop();
            }
            if(event.getSource() == checkBtn) {
                if((typeAnswer.getText() != null)) {
                    if(!typeAnswer.getText().isEmpty()){
                        yourAnswer.setText(typeAnswer.getText());
                    } else {
                        yourAnswer.setText("");
                    }
                }
                correctAnswer.setText(audio.getAudioScript(level));
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
