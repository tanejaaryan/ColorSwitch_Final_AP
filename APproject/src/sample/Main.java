package sample;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.*;
import java.nio.file.Paths;


public class Main extends Application implements Serializable {

    private static Stage s1;
    private MainPageMenu main_menu;
    static int checker=1;
    static AudioClip clip= new AudioClip(Paths.get("/Users/aryantaneja/Desktop/pvz.mp3").toUri().toString());
    static AudioClip cliper=  new AudioClip(Paths.get("/Users/aryantaneja/Downloads/clipper.mp3").toUri().toString());

    private GamePage g;



    public void setG(GamePage g) {
        this.g = g;
    }

    public GamePage getG() {
        return g;
    }

    public static Stage getS1() {
        return s1;
    }

    public static void setS1(Stage s) {
        s1 = s;
    }

    public Main()
    {
        main_menu = new MainPageMenu();

    }
    @Override
    public void start(Stage primaryStage) throws Exception{

        clip.setCycleCount(Animation.INDEFINITE);
        clip.play(0.3);
        FXMLLoader l = new FXMLLoader();
        GamePage.EnterLeaderboard();
        Parent root = l.load(getClass().getResource("sample.fxml"));
        setS1(primaryStage);
        primaryStage.setTitle("COLOR SWITCH");
        Scene s = new Scene(root, 550, 700);
        primaryStage.setScene(s);
        primaryStage.show();

    }




    public static void main(String[] args) {
        launch(args);
    }
}
