package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button backBtn;

    @FXML
    private Button startBtn;

    @FXML
    private Button pauseBtn;

    @FXML
    private MediaPlayer mediaPlayer;
    private Media media;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void buttonAction(javafx.event.ActionEvent event) {
        try {
            if(event.getSource() == backBtn) {
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                SplitPane root = loader.load(getClass().getResource("sample.fxml").openStream());
                primaryStage.setTitle("Listen And Write");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }
//            if(event.getSource() == exitBtn) {
//                System.exit(0);
//            }
            if(event.getSource() == startBtn) {
                String path = new File("src/level1.mp3").getAbsolutePath();
                media = new Media(new File(path).toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
            }
            if(event.getSource() == pauseBtn) {
                String path = new File("src/level1.mp3").getAbsolutePath();
                media = new Media(new File(path).toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.pause();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
