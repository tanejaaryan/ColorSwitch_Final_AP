package sample;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import  javafx.scene.*;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.getS1;

public class Controller implements Initializable, Serializable {

    public Controller()
    {

    }
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView innerCircle;
    @FXML
    private AnchorPane pane1;

    @FXML
    private ImageView playSymbol;

    @FXML
    private ImageView middleCircle;

    @FXML
    private ImageView outerCircle;

    @FXML
    private TextField user;

    @FXML
    private ImageView helpButton;

    @FXML
    private ImageView settings;

    @FXML
    private ImageView lowerTitle;

    @FXML
    private ImageView upperTitle;

    @FXML
    private ImageView titleCirle1;

    @FXML
    private ImageView titleCircle2;

    @FXML
    private Button newGameButton;

    @FXML
    private ImageView star1;

    @FXML
    private ImageView star2;

    @FXML
    private Button resumeButton;

    @FXML
    private ImageView highScore;

    @FXML
    private Button EXIT;

    @FXML
    private ImageView social;
    private URL url;
    private ResourceBundle resourceBundle;


    @FXML
    private ImageView back2;

    @FXML
    private TextField game;


    @FXML
    public AnchorPane getRoot() {
        return root;
    }

    @FXML
    private AnchorPane paneRulels;

    @FXML
    private ImageView back;

    @FXML
    private AnchorPane paneSet;

    @FXML
    private TextField user1;

    @FXML
    private AnchorPane paneSave;

    @FXML
    private ImageView back3;

    @FXML
    private Circle playButton;


    @FXML
    private TableView table;

    @FXML
    private TableColumn<TableView, Integer> gameTable;

    @FXML
    private TableColumn<TableView, String> username;

    @FXML
    private ListView<String> list;
    ObservableList o = FXCollections.observableArrayList();




    @FXML
    private void play1()
    {

        rotateImg(innerCircle, 10, 360 , 0,3, true, new Point3D(0, 279 ,307));
        rotateImg(middleCircle, 10, 360, 0,3, true, new Point3D(279, 0 ,307));
        rotateImg(outerCircle,10 , 360 ,0,3, true, new Point3D(0,  279 ,307));
        rotateImg(titleCirle1, 10, 360, 0,3, true, Rotate.Z_AXIS);
        rotateImg(titleCircle2, 10, 360,0, 3, true, Rotate.Z_AXIS);
        rotateImg(social, 10, 360, 0, 3, false, Rotate.Z_AXIS);
        rotateImg(highScore, 10, 360, 0, 3, false, Rotate.Z_AXIS);
    }

    @FXML
    private void rotateImg(ImageView img, double time, double angStart,double angEnd,  int rate, boolean reverse, Point3D point)
    {
        RotateTransition rotate = new RotateTransition(Duration.INDEFINITE, img);
        rotate.setRate(rate);
        rotate.setDuration(Duration.seconds(time));
        rotate.setDelay(Duration.seconds(0));
        rotate.setAutoReverse(reverse);
        rotate.setFromAngle(angStart);
        rotate.setToAngle(angEnd);
        rotate.setCycleCount(100);
        rotate.setAxis(point);
        rotate.play();


    }
    @FXML
    void saveButton(ActionEvent event) throws IOException {
        FXMLLoader l = new FXMLLoader();
        AnchorPane save =  l.load(getClass().getResource("save.fxml"));
        root.getChildren().setAll(save);
    }

    @FXML
    void newButton(ActionEvent event) throws IOException {
        FXMLLoader l = new FXMLLoader();
        AnchorPane new1 =  l.load(getClass().getResource("hello.fxml"));
        root.getChildren().setAll(new1);
    }

    @FXML
    void getUsername(ActionEvent event) {
        String user1 = user.getText();
        System.out.println(user1);
    }

    @FXML
    private TextField gameno;

    @FXML
    void enterGameNo(ActionEvent event) {
    }



    @FXML
    private void exitButton(ActionEvent event)
    {
        System.exit(0);
    }

    @FXML
    void settings(MouseEvent event) throws IOException
    {
        FXMLLoader l = new FXMLLoader();
        Parent root = l.load(getClass().getResource("sett.fxml"));
        getS1().setTitle("SETTINGS");
        Scene s = new Scene(root, 550, 700);
        getS1().setScene(s);
        getS1().show();
    }

    @FXML
    void help(MouseEvent event) throws IOException
    {
        FXMLLoader l = new FXMLLoader();
        AnchorPane new1 =  l.load(getClass().getResource("rules.fxml"));
        root.getChildren().setAll(new1);
    }
    @FXML
    void gameno(ActionEvent event) {

    }
    @FXML
    void username(ActionEvent event) {

    }


    @FXML
    void playGame(MouseEvent event) throws FileNotFoundException, Exception  {
        String user1= null, a1= null;
        if(user.getText()!=null) {
            user1 = user.getText();
        }
        if(gameno.getText()!=null){
         a1 = gameno.getText();}

        if(user1.equals("")==true || a1.equals("") == true){
        }
        else
        {
            GamePage gamePage = new GamePage(getS1(), user1, Integer.parseInt(a1));
            gamePage.getPlayer().setName(user1);
            gamePage.getPlayer().setId(Integer.parseInt(a1));
            getS1().setScene(gamePage.scene);
            getS1().show();
        }
    }


    @FXML
    void goBack(MouseEvent event ) throws IOException
    {
        FXMLLoader l = new FXMLLoader();
        AnchorPane new1 =  l.load(getClass().getResource("sample.fxml"));
        pane1.getChildren().setAll(new1);
    }
    @FXML
    void displayLeader(MouseEvent event ) throws IOException
    {
        Stage primaryStage = new Stage(StageStyle.DECORATED);
        LeaderBoard gamePage = new LeaderBoard(primaryStage);
    }
    @FXML
    void playSave(MouseEvent event) throws FileNotFoundException, Exception  {

        SaveGame object1 = null;
        try
        {
            String user = user1.getText();
            System.out.println(user);
            String a1 = game.getText();
            System.out.println(a1);

            File file1 = new File(""+user+"_"+a1+".txt");
            FileInputStream file = new FileInputStream(file1);
            ObjectInputStream in = new ObjectInputStream(file);
            // Method for deserialization of object
            object1 = (SaveGame) in.readObject();
            System.out.println(object1.ballY);
            System.out.println(object1.highscore+"high");
            System.out.println(object1.ballcolour+"ball");
            for(int q=0;q<object1.YAxis.size();q++){
                System.out.println(object1.YAxis.get(q)+"posY");
                System.out.println(object1.Angles.get(q)+"angle");
                System.out.println(object1.id.get(q)+"obstacle type");
            }
            in.close();
            System.out.println(1);
            file.close();
            System.out.println(2);
            LoadGame gamePage = new LoadGame(Main.getS1(),object1.n,object1.game_id,object1.highscore, object1.YAxis, object1.Angles, object1.id,object1.ballcolour, object1.ballY);
            System.out.println(3);
           Main.getS1().setScene(gamePage.scene);
            Main.getS1().show();

        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    @FXML
    void goBack1(MouseEvent event) throws IOException {
        FXMLLoader l = new FXMLLoader();
        AnchorPane new1 =  l.load(getClass().getResource("sample.fxml"));
        paneRulels.getChildren().setAll(new1);
    }
    @FXML
    void goBack2(MouseEvent event) throws IOException {
        FXMLLoader l = new FXMLLoader();
        AnchorPane new1 =  l.load(getClass().getResource("sample.fxml"));
        paneSave.getChildren().setAll(new1);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        play1();
        list = new ListView();
        list.getItems().addAll("ok","ughbknjmk");
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }





}

