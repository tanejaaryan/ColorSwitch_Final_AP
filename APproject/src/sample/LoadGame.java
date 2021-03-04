package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class LoadGame implements Serializable {
    private static final long serialVersionUID=42L;
    private static int id = 0;
    private int gameID;

    Timeline bground;
    Scene temp;
    Timeline timeline5;
    AnimationTimer time1;
    AnimationTimer time;
    boolean space = false;
    private Player player;
    Text t1;
    String score;
    int myScore=0;
    int start1 = 0;
    Stage stage;
    int o = 0 ;
    volatile List<GamePage> gameObjects;
    public LoadGame()  {}
    Group vbox = new Group();
    public Scene scene;
    AudioClip gameover1;
    Ball b;
    Circle ball;
    private int hit=0;
    final Timeline[] timeline6 = {null};
    final int[] moveUp = {0};
    PathTransition pathTransition = new PathTransition();
    PathTransition p1 = new PathTransition();
    final double[] y = {0};
    private int maxScore = 0;

    public int getMaxScore() {
        return maxScore;
    }


    public LoadGame(Stage PrimaryStage, String name, int game, int highscore, ArrayList<Double> YAxis, ArrayList<Double> Angles, ArrayList<Integer> id, int ballcolor, double ballY) throws IOException {
        stage=PrimaryStage;
        scene=new Scene(vbox, 600 ,800, Color.BLACK);
        player = new Player(name,myScore, game);
        GamePage.EnterLeaderboard();
        AudioClip clip1 = new AudioClip(Paths.get("/Users/aryantaneja/Downloads/smb_coin.wav").toUri().toString());
        AudioClip pause1 = new AudioClip(Paths.get("/Users/aryantaneja/Downloads/smb_pause.wav").toUri().toString());
        AudioClip buttonclick2 = new AudioClip(Paths.get("/Users/aryantaneja/Downloads/smb_kick.wav").toUri().toString());
        gameover1 = new AudioClip(Paths.get("/Users/aryantaneja/Downloads/smb_gameover.wav").toUri().toString());
        myScore=highscore;
        score = Integer.toString(myScore);
        gameObjects = new ArrayList<>();
        Random r2 = new Random();
        final int[] r1 = {r2.nextInt(8) + 1};
        int gap = 400;
        final int[] y1 = {400-(3*gap)};
        for(int g=0;g<YAxis.size();g++){
            if(id.get(g)==1){
                Ring ring = new Ring(300,YAxis.get(g),80,Angles.get(g));
                stopObjects();
                ring.rotate1.setAngle(Angles.get(g));
                //startObjects();
                gameObjects.add(ring);
                createStar(300-30, YAxis.get(g)-20);
                createColorChanger(285,YAxis.get(g)-80-90);
                vbox.getChildren().addAll(ring.myRing);
            }
            else if(id.get(g)==2){
                Cross ring = new Cross(350,YAxis.get(g),100,Angles.get(g));
                stopObjects();
                ring.rotate1.setAngle(Angles.get(g));
                //  startObjects();
                gameObjects.add(ring);
                createStar(285, YAxis.get(g)+70);
                createColorChanger(285,YAxis.get(g)-100-90);
                vbox.getChildren().addAll(ring.myCross);
            }
            else if(id.get(g)==3){
                Box ring = new Box(300,YAxis.get(g),150,Angles.get(g));
                stopObjects();
                gameObjects.add(ring);
                ring.rotate1.setAngle(Angles.get(g));
                createStar(285, YAxis.get(g)-20);
                createColorChanger(285,YAxis.get(g)-150-20);
                vbox.getChildren().addAll(ring.myBox);
            }
            else if(id.get(g)==4){
                DoubleRing ring = new DoubleRing(300,YAxis.get(g),80);
                System.out.println(Angles.get(g)+"myangle");
                stopObjects();
                gameObjects.add(ring);
                createStar(285, YAxis.get(g)+80+30);
                createColorChanger(285,YAxis.get(g)-80-90);
                vbox.getChildren().addAll(ring.myDoubleRing);
            }
            else if(id.get(g)==5){
                DoubleCross ring = new DoubleCross(300,YAxis.get(g),100,Angles.get(g));
                stopObjects();
                gameObjects.add(ring);
                ring.c1.rotate1.setAngle(Angles.get(g));
                ring.c2.rotate1.setAngle(Angles.get(g));
                createStar(285, YAxis.get(g)-70);
                createColorChanger(285,YAxis.get(g)-100-90);
                vbox.getChildren().addAll(ring.myDoubleCross);
            }
            else if(id.get(g)==6){
                RunningLines ring = new RunningLines(YAxis.get(g));
                stopObjects();
                gameObjects.add(ring);
                createStar(285, YAxis.get(g)+70);
                createColorChanger(285,YAxis.get(g)-80);
                vbox.getChildren().addAll(ring.myRunningLines);
            }
        }

        o = 10;
        moveUp[0] = 0;
        b = new CircleBall(ballY);
        ball = (Circle) b.drawShape();
        b.setY(ballY);
        ball.setCenterY(ballY);
        // System.out.println(ball.getBoundsInParent().getMaxY()+ "pointttt"+ballY+" "+b.getY());
        ball.setFill(Color.DEEPSKYBLUE);
        ball.setStroke(Color.TRANSPARENT);

        int n = ballcolor;
        Color c;
        if(n == 1)
            c = Color.DEEPPINK;
        else if(n == 2) c = Color.YELLOW;
        else if(n == 3) c = Color.DARKVIOLET;
        else if(n==4) c= Color.DEEPSKYBLUE;
        else c = Color.DEEPPINK;
        ball.setFill(c);

        vbox.getChildren().addAll(ball);
        final double[] y = {ball.getCenterY()};
        final double[] d = {b.getSpeed()};
        final double[] x = {ball.getCenterX()};
        final double[] t = {0};
        b.setY(ball.getBoundsInParent().getMaxY()); b.setX(x[0]);
        Random r = new Random();

        timeline5 = new Timeline(
                new KeyFrame(Duration.millis(100),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                for(int i=0;i<gameObjects.size();i++) {
                                    if(gameObjects.get(i)!=null){
                                        if(gameObjects.get(i) instanceof Ring){
                                            Ring r = (Ring) gameObjects.get(i);
                                            if(r.spriteHit(ball)==1){
                                                System.out.println("game over");
                                                try {
                                                    hit++;
                                                    hitObstacle();
                                                } catch (FileNotFoundException e) {
                                                    e.printStackTrace();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        else if(gameObjects.get(i) instanceof DoubleRing){
                                            DoubleRing r = (DoubleRing) gameObjects.get(i);
                                            if(r.spriteHit(ball)==1){
                                                System.out.println("game over");
                                                try {
                                                    hit++;
                                                    hitObstacle();
                                                } catch (FileNotFoundException e) {
                                                    e.printStackTrace();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        else if(gameObjects.get(i) instanceof Cross){
                                            Cross r = (Cross) gameObjects.get(i);
                                            if(r.spriteHit(ball)==1){
                                                System.out.println("game over");
                                                try {
                                                    hit++;
                                                    hitObstacle();
                                                } catch (FileNotFoundException e) {
                                                    e.printStackTrace();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        else if(gameObjects.get(i) instanceof DoubleCross){
                                            DoubleCross r = (DoubleCross) gameObjects.get(i);
                                            if(r.spriteHit(ball)==1){
                                                System.out.println("game over");
                                                try {
                                                    hit++;
                                                    hitObstacle();
                                                } catch (FileNotFoundException e) {
                                                    e.printStackTrace();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        else if(gameObjects.get(i) instanceof Box){
                                            Box r = (Box) gameObjects.get(i);
                                            if(r.spriteHit(ball)==1){
                                                System.out.println("game over");
                                                try {hit++;
                                                    hitObstacle();
                                                } catch (FileNotFoundException e) {
                                                    e.printStackTrace();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        else if(gameObjects.get(i) instanceof RunningLines){
                                            RunningLines r = (RunningLines) gameObjects.get(i);
                                            if(r.spriteHit(ball)==1){
                                                System.out.println("game over");
                                                try {
                                                    hit++;
                                                    hitObstacle();
                                                } catch (FileNotFoundException e) {
                                                    e.printStackTrace();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        else if(gameObjects.get(i) instanceof TriangleObstacle)
                                        {
                                            TriangleObstacle r = (TriangleObstacle) gameObjects.get(i);
                                            if(r.spriteHit(ball)==1){
                                                System.out.println("game over");
                                            }
                                        }
                                        else if(gameObjects.get(i) instanceof Star){
                                            Star s = (Star) gameObjects.get(i);
                                            if(s.spriteHit(ball)==1){
                                                vbox.getChildren().remove(s.rectangle);
                                                gameObjects.remove(i);
                                                myScore++;
                                                clip1.play();
                                                maxScore++;
                                                score = Integer.toString(myScore);
                                                t1.setText(score);
                                                System.out.println("plus 1");
                                            }
                                        }
                                        else if(gameObjects.get(i) instanceof ColorChanger){
                                            ColorChanger c = (ColorChanger) gameObjects.get(i);
                                            if(c.spriteHit(ball)==1){
                                                vbox.getChildren().remove(c.rectangle);
                                                gameObjects.remove(i);
                                                changeBallColor(ball);
                                                System.out.println("color changed");
                                            }
                                        }
                                    }
                                }
                            }
                        },

                        new javafx.animation.KeyValue[]{}));
        {
            timeline5.setCycleCount(Timeline.INDEFINITE);
            timeline5.play();
        }

        vbox.setFocusTraversable(true);
        vbox.requestFocus();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.SPACE)
                {
                    moveUp[0]++;
                    start1++;
                    if(hit==1)
                    {
                        space = true;
                    }
                    if(start1 == 1)
                    { time.start();
                        startObjects();
                        System.out.println("ok");}
                    if(chk == true)
                    {
                        gameStart();
                        startObjects();
                        time.start(); chk = false;
                    }
                    System.out.println(hit);
                    if(hit == 1 && space == true)
                    {
                        gameStart();
                        startObjects();
                        timeline5.setDelay(Duration.seconds(1));
                        time.start();
                        hit = 0;
                        space = false;
                    }
                }
            }
        });


        time1 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                y[0] = ball.getCenterY();
                d[0] = b.getSpeed();
                x[0] = ball.getCenterX();
                if(moveUp[0]>0)
                {
                    double hitTrial = 2;
                     timeline6[0] = new Timeline(
                            new KeyFrame(Duration.millis(2),
                                    new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            //System.out.println("hello1");
                                            b.setSpeed(b.getSpeed()-hitTrial);
                                            moveUp[0] = 0;
                                        }
                                    }));
                    timeline6[0].setCycleCount(35);
                    timeline6[0].play();
                }

                pathTransition.setNode(ball);
                Path p = new Path();
                p.getElements().add (new MoveTo (x[0],y[0]));
                p.getElements().add(new LineTo(x[0], y[0]+b.getSpeed()));
                b.setY(ball.getBoundsInParent().getMaxY());
                pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                pathTransition.setPath(p);
                pathTransition.setDuration(Duration.millis(2500));
                pathTransition.setCycleCount(50);
                pathTransition.play();

                if(ball.getBoundsInParent().getMaxY()>900)
                {
                    this.stop();
                    System.out.println("You lost");
                    try {
                        hitObstacle();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                t[0] = t[0]+0.001;

            }
        };
        time = new AnimationTimer() {
            double tw = 0;
            @Override
            public void handle(long l) {
                double y = ball.getCenterY();
//                double d = b.getSpeed();
                double x = ball.getCenterX();
                if(moveUp[0]>0)
                {
                    time1.start();
                    tw = 0.1;
                }
                increaseLevel();
                ball.relocate(x, y+b.getSpeed());
                // b.setY(ball.getCenterY());
                b.setY(ball.getBoundsInParent().getMaxY());
                b.setSpeed(b.getSpeed()+1.5*Ball.getGravity()*Math.pow(tw, 2));

                if(ball.getBoundsInParent().getMaxY()>900)
                {
                    this.stop();
                    System.out.println("You lost");
                    try {
                        hitObstacle();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                t[0] = t[0]+0.001;
                tw = tw+0.001;
            }

        };

        Image image = new Image(new FileInputStream("/Users/aryantaneja/Downloads/giphy.gif"),100,100,true,false);
        ImageView imageView = new ImageView(image);
        imageView.setX(260);
        imageView.setY(710);
        //
        Image image2 = new Image(new FileInputStream("/Users/aryantaneja/Downloads/hello7.gif"),150,150,true,false);
        ImageView imageView2 = new ImageView(image2);
        imageView2.setX(0);
        imageView2.setY(690);
        //
        Image image3 = new Image(new FileInputStream("/Users/aryantaneja/Downloads/hello2.gif"),80,80,true,false);
        ImageView imageView3 = new ImageView(image3);
        imageView3.setX(490);
        imageView3.setY(710);
        //
        Image image5 = new Image(new FileInputStream("/Users/aryantaneja/Downloads/hello9.gif"),600,20,false,false);
        ImageView imageView5 = new ImageView(image5);
        imageView5.setX(0);
        imageView5.setY(0);
        //
        Image image6 = new Image(new FileInputStream("/Users/aryantaneja/Downloads/hello9.gif"),600,20,false,false);
        ImageView imageView6 = new ImageView(image6);
        imageView6.setX(0);
        imageView6.setY(790);
        //
        t1 = new Text();
        t1.setText(score);
        t1.setFont(Font.font("Verdana",40));
        t1.setStrokeWidth(10);
        t1.setX(520);
        t1.setY(700);
        t1.setFill(Color.LIGHTGREY);


        Button pause = new Button("pause",imageView2);
        pause.setLayoutX(0);
        pause.setLayoutY(690);
        pause.setMaxSize(100,100);
        pause.setStyle("-fx-background-color: #000000 ");
        pause.setOnMouseClicked(event -> {
            pause1.play();
            gameStop();
            stopObjects();
            temp = this.scene;
            PauseGame p = null;
            try {
                p = new PauseGame(this.stage);
                System.out.println(gameObjects.size()+"gamesize");
                System.out.println(b.getY());
                p.back.setOnMouseClicked(event1 -> {
                    buttonclick2.play();
                    vbox.setFocusTraversable(true);
                    vbox.requestFocus();
                    stage.setScene(temp);
                    stage.show();
                });

                p.SaveGame.setOnMouseClicked(event1 -> {
                    buttonclick2.play();
                    SaveGame saved = null;
                    try {
                        int ballco = checkColor(ball);
                        this.Write(score);
                        GamePage.EnterLeaderboard();
                        saved = new SaveGame(b.getY(),gameObjects,myScore,ballco, name,game );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            stage.setScene(p.scene1);
            stage.show();
        });

        vbox.getChildren().addAll(imageView,imageView3,imageView5,imageView6);
        vbox.getChildren().add(pause);
        vbox.getChildren().add(t1);
        stage.setScene(this.scene);
        stage.show();

        System.out.println(y1[0]);
        final double[] q = {0};
        bground = new Timeline(new KeyFrame(Duration.millis(15),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        while (gameObjects.size() <= 27 && o<10) {
                            r1[0] = r2.nextInt(8) + 1;
                            System.out.println(r1[0] + " " + y1[0]);
                            if (r1[0] == 1) {
                                try {
                                    createBox(300, q[0] - (10* gap), 150);
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                            } else if (r1[0] == 2) {
                                try {
                                    createRunningLines(q[0] - (10* gap));
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                            } else if (r1[0] == 3) {
                                try {
                                    createRing(300, q[0] - (10* gap), 80);
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                            } else if (r1[0] == 4) {
                                try {
                                    createCross(350, q[0] - (10* gap), 100);
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                            } else if (r1[0] == 5) {
                                try {
                                    createDoubleCross(300, q[0] - (10 * gap), 100);
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                            } else if (r1[0] == 6) {
                                try {
                                    createBox(300, q[0] - (10* gap), 150);
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                            } else if (r1[0] == 7) {
                                try {
                                    createDoubleRing(300, q[0] - (10 * gap), 80);
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                            } else if (r1[0] == 8) {
                                try {
                                    createRunningLines(q[0] - (10* gap));
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                            o++;
                        }

                        double x = 2;
                        Iterator i1 = gameObjects.iterator();
                        while (i1.hasNext()) {
                            GamePage g = (GamePage) i1.next();
                            if (g != null) {
                                if (g instanceof Ring) {
                                    Ring r = (Ring) g;
                                    if (750 - ball.getBoundsInParent().getMaxY() > 150) {
                                        r.myRing.setTranslateY(r.myRing.getTranslateY() + x);
                                        r.setY(r.getY()+x);
                                    }

                                    if (r.myRing.getBoundsInParent().getCenterY() > 1200) {
                                        {
                                            i1.remove();o--;

                                            q[0] = r.myRing.getBoundsInParent().getCenterY();
                                            System.out.println(q[0]);
                                        }
                                    }

                                } else if (g instanceof DoubleRing) {
                                    DoubleRing r = (DoubleRing) g;
                                    if (750 - ball.getBoundsInParent().getMaxY() > 150) {
                                        r.myDoubleRing.setTranslateY(r.myDoubleRing.getTranslateY() + x);
                                        r.setY(r.getY()+x);
                                    }
                                    if (r.myDoubleRing.getBoundsInParent().getCenterY() > 1200) {
                                        i1.remove();o--;
                                        q[0] = r.myDoubleRing.getBoundsInParent().getCenterY();
                                    }
                                    //System.out.println(r.myDoubleRing.getLayoutY()+"  doublering "+r.myDoubleRing.getTranslateY()+" "+r.myDoubleRing.getScaleY());

                                } else if (g instanceof Cross) {
                                    Cross r = (Cross) g;
                                    if (750 - ball.getBoundsInParent().getMaxY() > 150) {
                                        r.myCross.setTranslateY(r.myCross.getTranslateY() + x);
                                        r.setY(r.getY() + x);
                                    }
                                    if (r.myCross.getBoundsInParent().getCenterY() > 1200) {
                                        i1.remove();o--;

                                        q[0] = r.myCross.getBoundsInParent().getCenterY();
                                    }
                                    //System.out.println(r.myCross.getBoundsInParent().getCenterY()+"cross "+r.myCross.getTranslateY()+" "+r.myCross.getScaleY());

                                } else if (g instanceof DoubleCross) {
                                    DoubleCross r = (DoubleCross) g;
                                    if (750 - ball.getBoundsInParent().getMaxY() > 150){
                                        r.myDoubleCross.setTranslateY(r.myDoubleCross.getTranslateY() + x);
                                        r.setY(r.getY()+x);}
                                    if (r.myDoubleCross.getBoundsInParent().getCenterY() > 1200) {
                                        i1.remove();o--;

                                        q[0] = r.myDoubleCross.getBoundsInParent().getCenterY();
                                    }
                                    //System.out.println(r.myDoubleCross.getBoundsInParent()+"double cross "+r.myDoubleCross.getTranslateY()+" "+r.myDoubleCross.getScaleY());

                                } else if (g instanceof Box) {
                                    Box r = (Box) g;
                                    if (750 - ball.getBoundsInParent().getMaxY() > 150)
                                    {r.myBox.setTranslateY(r.myBox.getTranslateY() + x);
                                        r.setY(r.getY()+x);}
                                    if (r.myBox.getBoundsInParent().getMaxY() > 1200) {
                                        i1.remove();o--;

                                        q[0] = r.myBox.getBoundsInParent().getCenterY();
                                    }
                                    // System.out.println(r.myBox.getBoundsInParent().getMaxY()+"  okkk "+r.myBox.getBoundsInParent().getCenterY()+" "+r.myBox.getBoundsInParent().getHeight());

                                } else if (g instanceof RunningLines) {
                                    RunningLines r = (RunningLines) g;
                                    if (750 - ball.getBoundsInParent().getMaxY() > 150){
                                        r.myRunningLines.setTranslateY(r.myRunningLines.getTranslateY() + x);
                                        r.setY(r.getY()+x);}
                                    if (r.myRunningLines.getBoundsInParent().getCenterY() > 1200) {
                                        i1.remove();o--;
                                        q[0] = r.myRunningLines.getBoundsInParent().getCenterY();
                                        System.out.println(q[0]);
                                    }
//                                        System.out.println(r.myRunningLines.getBoundsInParent().getMaxY()+"  okkk "+r.myRunningLines.getBoundsInParent().getCenterY()+" "+r.myRunningLines.getBoundsInParent().getHeight());

                                } else if (g instanceof TriangleObstacle) {
                                    TriangleObstacle r = (TriangleObstacle) g;

                                    r.tr1.setTranslateY(r.tr1.getTranslateY() + x);
                                    r.tr2.setTranslateY(r.tr2.getTranslateY() + x);
                                    r.tr3.setTranslateY(r.tr3.getTranslateY() + x);
                                } else if (g instanceof Star) {
                                    Star s = (Star) g;
                                    s.setY(s.getY()+x);
                                    if (750 - ball.getBoundsInParent().getMaxY() > 150)
                                        s.rectangle.setTranslateY(s.rectangle.getTranslateY() + x);

                                } else if (g instanceof ColorChanger) {
                                    ColorChanger s = (ColorChanger) g;
                                    s.setY(s.getY()+x);
                                    if (750 - ball.getBoundsInParent().getMaxY() > 150)
                                        s.rectangle.setTranslateY(s.rectangle.getTranslateY() + x);
                                }
                            }
                        }
                        if (750 - ball.getBoundsInParent().getMaxY() > 150)
                            imageView.setTranslateY(imageView.getTranslateY() + x);


                    }
                }
        ));
        bground.setCycleCount(Timeline.INDEFINITE);
        bground.play();
        stopObjects();
    }


    private void changeBallColor(Circle ball) {
        Color c ;
        Random r = new Random();
        int n = r.nextInt(4)+1;
        if(n == 1)
            c = Color.DEEPPINK;
        else if(n == 2) c = Color.YELLOW;
        else if(n == 3) c = Color.DARKVIOLET;
        else c = Color.DEEPSKYBLUE;
        ball.setFill(c);
        ball.setStroke(Color.TRANSPARENT);

    }

    private void hitObstacle() throws IOException {
        gameover1.play();
        gameStop();
        stopObjects();
        ball.relocate(ball.getCenterX(),ball.getCenterY()+100);

        temp = this.scene;
        moveUp[0] = 0;

        this.Write(score);
        GamePage.EnterLeaderboard();

        HitObstacle p = null;

        try {
            p = new HitObstacle(stage, score, player.getName(), player.getId());
            if(myScore >=3 ){
                p.Continue.setOnMouseClicked(event1 -> {
                    myScore = myScore - 3;
                    score =String.valueOf(myScore);
                    t1.setText(score);
                    vbox.setFocusTraversable(true);
                    vbox.requestFocus();
                    stage.setScene(temp);
                    stage.show();


                });}}
        catch (FileNotFoundException e) {
        }
        stage.setScene(p.scene1);
        stage.show();

    }



    private void startObjects() {
        int i=0;
        while(i<gameObjects.size()){
            if(gameObjects.get(i) instanceof Ring){
                Ring r = (Ring) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).play();
                }
                // r.getTimeline().play();
            }
            else if(gameObjects.get(i) instanceof Cross){
                Cross r = (Cross) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).play();
                }
                //getTimeline().play();
            }
            else if(gameObjects.get(i) instanceof DoubleRing){
                DoubleRing r = (DoubleRing) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).play();
                }
                //  r.getTimeline().play();
            }
            else if(gameObjects.get(i) instanceof DoubleCross){
                DoubleCross r = (DoubleCross) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).play();
                }
                //r.getTimeline().play();
            }
            else if(gameObjects.get(i) instanceof Box){
                Box r = (Box) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).play();
                }
            }
            else if(gameObjects.get(i) instanceof TriangleObstacle){
                TriangleObstacle r = (TriangleObstacle) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).play();
                }
                //r.getTimeline().play();
            }
            i++;
        }
    }

    private void stopObjects() {
        int i=0;
        while(i<gameObjects.size()){
            if(gameObjects.get(i) instanceof Ring){
                Ring r = (Ring) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).pause();
                }
            }
            else if(gameObjects.get(i) instanceof Cross){
                Cross r = (Cross) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).pause();
                }
            }
            else if(gameObjects.get(i) instanceof DoubleRing){
                DoubleRing r = (DoubleRing) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).pause();
                }
            }
            else if(gameObjects.get(i) instanceof DoubleCross){
                DoubleCross r = (DoubleCross) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).pause();
                }
            }
            else if(gameObjects.get(i) instanceof Box){
                Box r = (Box) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).pause();
                }
            }
            i++;
        }
    }

    public  void changeScene(Scene scene)
    {
        stage.setScene(scene);
        stage.show();
    }
    private void createRing(double X,double Y,double radius) throws FileNotFoundException {
        Ring r1 = new Ring(X,Y,radius);
        gameObjects.add(r1);
        createStar(X-30,Y-20);
        createColorChanger(285,Y-radius-90);
        vbox.getChildren().addAll(r1.myRing);
    }
    private synchronized void createDoubleRing(double X,double Y,double radius) throws FileNotFoundException {
        DoubleRing dr = new DoubleRing(X,Y,radius);
        gameObjects.add(dr);
        createStar(X-30,Y+radius+30);
        createColorChanger(285,Y-radius-90);

        vbox.getChildren().addAll(dr.myDoubleRing);
    }
    private synchronized void createCross(double X,double Y,double side) throws FileNotFoundException {
        Cross c = new Cross(X,Y,side);
        gameObjects.add(c);
        createStar(285,Y+70);
        createColorChanger(285,Y-side-90);

        vbox.getChildren().addAll(c.myCross);

    }
    private synchronized void createDoubleCross(double X,double Y,double side) throws FileNotFoundException {
        DoubleCross dc = new DoubleCross(X,Y,side);
        gameObjects.add(dc);
        createStar(285,Y-70);
        createColorChanger(285,Y-90-side);

        vbox.getChildren().addAll(dc.myDoubleCross);
    }
    private synchronized void createBox(double X,double Y,double side) throws FileNotFoundException {
        Box b1=new Box(X,Y,side);
        gameObjects.add(b1);

        createStar(285,Y-20);
        createColorChanger(285,Y-side-20);

        vbox.getChildren().add(b1.myBox);
    }
    private synchronized void createRunningLines(double Y) throws FileNotFoundException {
        RunningLines rl = new RunningLines(Y);
        gameObjects.add(rl);
        createStar(285,Y+70);
        createColorChanger(285,Y-80);
        vbox.getChildren().addAll(rl.myRunningLines);
    }
    private void createTriangleObstacle(double X,double Y){
        TriangleObstacle TriObs = new TriangleObstacle(X,Y);
        gameObjects.add(TriObs);
        vbox.getChildren().addAll(TriObs.tr1,TriObs.tr2,TriObs.tr3);
    }
    private void createStar(double X,double Y) throws FileNotFoundException {
        Star star = new Star(X,Y);
        gameObjects.add(star);
        vbox.getChildren().add(star.rectangle);
    }
    private void createColorChanger(double X,double Y) throws FileNotFoundException {
        ColorChanger colorChanger = new ColorChanger(X,Y);
        gameObjects.add(colorChanger);
        vbox.getChildren().add(colorChanger.rectangle);
    }
    int pause = 0; boolean chk = false;
    private void gameStop(){

        if(timeline6[0]!=null)
            System.out.println(timeline6[0].getStatus());

        pathTransition.pause();
        time1.stop();
        bground.stop();
        timeline5.stop();
        time.stop();
        chk = true;
        pause = 0;

    }
    private void gameStart(){
        bground.play();
        timeline5.play();

    }

    public String getScore() {
        return score;
    }

    public void increaseLevel()
    {
        int c = maxScore/3;
        int i=0;
        while(i<gameObjects.size()){
            if(gameObjects.get(i) instanceof Ring){
                Ring r = (Ring) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).setRate(1+0.2*c);
                }
            }
            else if(gameObjects.get(i) instanceof Cross){
                Cross r = (Cross) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).setRate(1+c*0.2);
                }
            }
            else if(gameObjects.get(i) instanceof DoubleRing){
                DoubleRing r = (DoubleRing) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    r.timelines.get(q).setRate(1+c*0.2);
                }

            }
            else if(gameObjects.get(i) instanceof DoubleCross){
                DoubleCross r = (DoubleCross) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    Rotate rotate = new Rotate(0, 0,0 );
                    r.timelines.get(q).setRate(1+c*0.2);
                }
            }
            else if(gameObjects.get(i) instanceof Box){
                Box r = (Box) gameObjects.get(i);
                for(int q=0;q<r.timelines.size();q++){
                    Rotate rotate = new Rotate(0, 0,0 );
                    r.timelines.get(q).setRate(1+c*0.2);

                }
            }
            i++;
        }
    }
    public static void EnterLeaderboard() throws IOException {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("leaderboard.txt"));
            String s;
            while ((s = in.readLine()) != null )  {
                s = s.replaceAll(" ", "");
                if(s.equals("")==false) {
                    int a = Integer.parseInt(s);

                    GamePage.arr.add(a);
                    System.out.println(a);
                }
            }
            Collections.sort(GamePage.arr);
            Set<Integer> s1 = new LinkedHashSet<Integer>(GamePage.arr);
            GamePage.finalList = new ArrayList<>(s1);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

            if (in != null)
                in.close();
        }
    }
    private int checkColor(Circle b){
        int n=1;
       Color c;
        if(b.getFill()==Color.DEEPPINK)
            return 1;
        else if(b.getFill()==Color.YELLOW) return 2;
        else if(b.getFill()==Color.DARKVIOLET) return 3;
        else if(b.getFill()==Color.DEEPSKYBLUE) return 4;
        else return 1;
    }
    public void Write(String score1) throws IOException{
        BufferedWriter out = null;
        try{
            out = new BufferedWriter(( new FileWriter("leaderboard.txt", true)));
            out.append("\n");
            out.append(score1);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();}
        finally {
            if (out != null)
                out.close();
        }
    }


}