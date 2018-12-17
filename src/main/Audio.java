package main;

import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Audio {

    private String[] audioStringArr = {"level1", "level2", "level3", "level4", "level5", "level6", "level7", "level8", "level9", "level10"};

    @FXML
    private MediaPlayer audio;
    private Media media;

    public void setLevel(int level) {
        String path = new File("src/data/audio/" + audioStringArr[level - 1] + ".wav").getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        audio = new MediaPlayer(media);
        audio.setCycleCount(MediaPlayer.INDEFINITE);
        setAudio(audio);
    }

    public String getAudioScript(int level) {
        String line;
        BufferedReader bufferedReader;
        FileReader fileReader;
        String input = "";
        try {
            fileReader = new FileReader("src/data/text/" + audioStringArr[level - 1] + ".txt");
            bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            while (line != null) {
                input += line;
                line = bufferedReader.readLine();
            }
            fileReader.close();

        } catch (Exception ex) {
        }
        return input;
    }

    public void setAudio(MediaPlayer audio) {
        this.audio = audio;
    }

    public MediaPlayer getAudio() {
        return audio;
    }
}
