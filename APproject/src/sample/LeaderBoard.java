

package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class LeaderBoard implements Serializable {
    private TableView table = new TableView();
    Stage window;
    Scene menu, playGame;
    Group vbox = new Group();

    {
    }

    public LeaderBoard(Stage primaryStage) throws FileNotFoundException {

        window = primaryStage;
        menu = new Scene(vbox, 500, 600, Color.BLACK);
        window.setScene(menu);
        window.setTitle("Leaderboard Helper");


        Image imagenew = new Image(new FileInputStream("/Users/aryantaneja/Downloads/trophy1.png"), 400, 80, false, false);
        ImageView imageViewnew = new ImageView(imagenew);
        imageViewnew.setFitHeight(50);
        imageViewnew.setFitWidth(50);


        Image imagenew1 = new Image(new FileInputStream("/Users/aryantaneja/Downloads/load.gif"), 0, 70, false, false );
        ImageView imageViewnew1 = new ImageView(imagenew1);
        imageViewnew1.setFitHeight(75);
        imageViewnew1.setFitWidth(75);


        Text t1 = new Text("LEADERBOARD");
        t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
        t1.setStrokeWidth(100);
        t1.setFill(Color.DARKGRAY);
        t1.setX(80);
        t1.setY(120);
        int fontGap = 3;
        Text t2, t3, t4, t5, t6;
        if(GamePage.getFinalList().size()>=1) {
            t2 = new Text("HIGHSCORE 1 : " + GamePage.getFinalList().get(GamePage.getFinalList().size() - 1));
        }
        else {
            t2 = new Text("HIGHSCORE 1 : NIL");
        }
        t2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 42));
        t2.setStrokeWidth(100);
        t2.setFill(Color.PALETURQUOISE);
        t2.setX(60);
        t2.setY(190);

        if(GamePage.getFinalList().size()>=2) {
            t3 = new Text("HIGHSCORE 2 : " + GamePage.getFinalList().get(GamePage.getFinalList().size() - 2));
        }
        else {
            t3 = new Text("HIGHSCORE 2 : NIL");
        }
        t3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 42-fontGap));
        t3.setStrokeWidth(100);
        t3.setFill(Color.MEDIUMVIOLETRED);
        t3.setX(60);
        t3.setY(260);


        if(GamePage.getFinalList().size()>=3) {
            t4 = new Text("HIGHSCORE 3 : " + GamePage.getFinalList().get(GamePage.getFinalList().size() - 3));
        }
        else {
            t4 = new Text("HIGHSCORE 3 : NIL");
        }
        t4.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 42-2*fontGap));
        t4.setStrokeWidth(100);
        t4.setFill(Color.AQUA);
        t4.setX(60);
        t4.setY(330);

        if(GamePage.getFinalList().size()>=4) {
            t5 = new Text("HIGHSCORE 4 : " + GamePage.getFinalList().get(GamePage.getFinalList().size() - 4));
        }
        else {
            t5 = new Text("HIGHSCORE 4 : NIL");
        }
        t5.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 42-3*fontGap));
        t5.setStrokeWidth(100);
        t5.setFill(Color.LIGHTPINK);
        t5.setX(60);
        t5.setY(410);

        if(GamePage.getFinalList().size()>=5) {
            t6 = new Text("HIGHSCORE 5 : " + GamePage.getFinalList().get(GamePage.getFinalList().size() - 5));
        }
        else {
            t6 = new Text("HIGHSCORE 5 : NIL");
        }
        t6.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 42-4*fontGap));
        t6.setStrokeWidth(100);
        t6.setFill(Color.GREENYELLOW);
        t6.setX(60);
        t6.setY(480);

        final VBox vbox = new VBox();
        vbox.getChildren().addAll(t2, t3, t4, t5, t6);
        ((Group) menu.getRoot()).getChildren().addAll( vbox, imageViewnew, t1, imageViewnew1);
        ((Group) menu.getRoot()).getChildren().addAll( t2, t3, t4, t5, t6 );

        window.show();

    }
}

