package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;

public class HitObstacle extends GamePage implements Serializable {
    Scene scene1;
    Stage stage3;
    Button Continue,restart,exit;
    Image image7 = new Image(new FileInputStream("/Users/aryantaneja/Downloads/stickhello.png"), 300, 900, true, false);
    Image image8 = new Image(new FileInputStream("/Users/aryantaneja/Downloads/CW.gif"), 200, 200, true, false);
   Image image9 = new Image(new FileInputStream("/Users/aryantaneja/Downloads/load.gif"), 400, 400, true, false);
    Image image10 = new Image(new FileInputStream("/Users/aryantaneja/Downloads/healthy.png"), 50, 50, true, false);
    Image image12 = new Image(new FileInputStream("/Users/aryantaneja/Downloads/restart.png"), 50, 50, true, false);
    Image image13 = new Image(new FileInputStream("/Users/aryantaneja/Downloads/exit.png"), 50, 50, true, false);
    AudioClip buttonclick3 = new AudioClip(Paths.get("/Users/aryantaneja/Downloads/smb_kick.wav").toUri().toString());

    Text t1 = new Text();{
        t1.setFont(Font.font("Verdana",20));
        t1.setStrokeWidth(10);
        t1.setX(390);
        t1.setY(185);
        t1.setFill(Color.LIGHTGREY);
    }
    Text t2 = new Text();{
        t2.setText("Better Luck \nNext Time!!");
        t2.setFont(Font.font("Times New Roman",25));
        t2.setStrokeWidth(10);
        t2.setX(240);
        t2.setY(590);
        t2.setFill(Color.LIGHTGREY);
    }
    Group vbox = new Group();
    private void addButtonEffect(Button btn, String enter, String exit){
        btn.setStyle(enter);
        btn.setOnMouseEntered(e -> btn.setStyle(exit));
        btn.setOnMouseExited(e -> btn.setStyle(enter));
    }

    public HitObstacle(Stage stage,String score1,String name,int game) throws FileNotFoundException {
        t1.setText("Your Score is : \n" + score1);
        scene1=new Scene(vbox, 600 ,800,Color.BLACK);
        stage3=stage;
        ImageView imageView7 = new ImageView(image7);
        imageView7.setX(200);
        imageView7.setY(20);

        ImageView imageView8 = new ImageView(image8);
        imageView8.setX(15);
        imageView8.setY(140);

       ImageView imageView9 = new ImageView(image9);
        imageView9.setX(100);
        imageView9.setY(400);


        //
        ImageView imageView10 = new ImageView(image10);
        imageView10.setFitHeight(50);
        imageView10.setFitWidth(50);
        imageView10.setPreserveRatio(true);
        //
        //
        ImageView imageView12 = new ImageView(image12);
        imageView12.setFitHeight(50);
        imageView12.setFitWidth(50);
        imageView12.setPreserveRatio(true);
        //
        ImageView imageView13 = new ImageView(image13);
        imageView13.setFitHeight(50);
        imageView13.setFitWidth(50);
        imageView13.setPreserveRatio(true);
        //
        restart = new Button("Restart",imageView12);
        restart.setFont(Font.font("Verdana",15));
        restart.setLayoutX(110);
        restart.setLayoutY(300);
        restart.wrapTextProperty();
        restart.setMaxSize(200,200);
        restart.setTextFill(Color.LIGHTGREY);
        restart.setStyle("-fx-background-color: #000000 ");
        addButtonEffect(restart,"-fx-background-color: transparent","-fx-background-color: DarkViolet");
        //
        //
        Continue = new Button("Continue \n(Use-Stars)",imageView10);
        Continue.setLayoutX(320);
        Continue.setFont(Font.font("Verdana",15));
        Continue.setLayoutY(300);
        Continue.setTextFill(Color.LIGHTGREY);
        Continue.setMaxSize(200,200);
        Continue.setStyle("-fx-background-color: #000000 ");
        addButtonEffect(Continue,"-fx-background-color: transparent","-fx-background-color: MediumSeaGreen");
        //
        exit = new Button("Exit",imageView13);
        exit.setLayoutX(10);
        exit.setFont(Font.font("Verdana",15));
        exit.setLayoutY(10);
        exit.setTextFill(Color.LIGHTGREY);
        exit.setMaxSize(200,200);
        exit.setStyle("-fx-background-color: #000000 ");
        addButtonEffect(exit,"-fx-background-color: transparent","-fx-background-color: Brown");
        //

        exit.setOnMouseClicked(event1 -> {
            buttonclick3.play();
            FXMLLoader l = new FXMLLoader();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene s = new Scene(root, 550, 700);
            stage.setTitle("COLOR SWITCH");
            stage.setScene(s);
            stage.show();

        });
       restart.setOnMouseClicked(event1 -> {
           buttonclick3.play();
           GamePage gamePage = null;
           try {
               gamePage = new GamePage(Main.getS1(),name,game);
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
           stage.setScene(gamePage.scene);
          stage.show();

        });
        vbox.getChildren().addAll(imageView7,imageView8);
        vbox.getChildren().addAll(imageView9);
        vbox.getChildren().addAll(restart,Continue,exit);
        vbox.getChildren().addAll(t1,t2);
    }
}
