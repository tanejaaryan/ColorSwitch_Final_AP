package sample;

import javafx.animation.Animation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import static sample.Main.checker;
import static sample.Main.getS1;

public class Settings{

    @FXML
    void Display_Settings() throws IOException
    {
        EventHandler<MouseEvent> eventHandler = null;
        this.settings((MouseEvent) eventHandler);
    }

    private void settings(MouseEvent event) throws IOException
    {
        FXMLLoader l = new FXMLLoader();
        Parent root = l.load(getClass().getResource("sett.fxml"));
        getS1().setTitle("SETTINGS");
        Scene s = new Scene(root, 550, 700);
        getS1().setScene(s);
        getS1().show();
    }

    //GUI method
    @FXML
    void goBack3(MouseEvent event) throws IOException {
        FXMLLoader l = new FXMLLoader();
        Parent root = l.load(getClass().getResource("sample.fxml"));
        Main.getS1().setTitle("COLOUR SWITCH");
       // Scene s = new Scene(root, 550, 700);
        Main.getS1().setScene( new Scene(root, 550, 700));
        Main.getS1().show();
    }

    public void change_settings(){

    }

    @FXML
    public void startMusic(ActionEvent actionEvent) {
        if(Main.checker == 1){
            Main.clip.stop();
            Main.clip.setCycleCount(Animation.INDEFINITE);
            Main.clip.play(0.3);
        }
        else if(Main.checker==2)
        {
            Main.cliper.stop();
            Main.cliper.setCycleCount(Animation.INDEFINITE);
            Main.cliper.play(0.3);
        }

    }

    @FXML
    public void stopMusic(ActionEvent actionEvent) {
        if(Main.checker==1)
                 Main.clip.stop();
        else if(checker==2)
        {
            Main.cliper.stop();
        }

    }
    @FXML
    public void changeMusic(ActionEvent actionEvent) {
        if(Main.checker==1){
        Main.clip.stop();
        Main.cliper.setCycleCount(Animation.INDEFINITE);
        Main.cliper.play(0.3);
        Main.checker=2;
        }
        else if(Main.checker==2){
            Main.cliper.stop();
            Main.clip.setCycleCount(Animation.INDEFINITE);
            Main.clip.play(0.3);
            Main.checker=1;

        }
    }
}