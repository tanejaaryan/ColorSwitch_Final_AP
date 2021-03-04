package sample;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.FileNotFoundException;

import static javafx.scene.shape.Shape.intersect;

public class RunningLines extends Obstacles {
    double Y;
    Line pl1,pl2,pl3,pl4,pl5,pl6,pl7,pl8;
    Line pl01,pl02,pl03,pl04,pl05,pl06,pl07,pl08;
    Group myRunningLines = new Group();
    public RunningLines(double Y) throws FileNotFoundException {
        this.Y=Y;
        this.draw();

    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    private void draw(){
        pl1 = new Line(0,Y,70,Y);{
            pl1.setStroke(Color.DEEPPINK);
            pl1.setStrokeWidth(12);
        }
        pl2 = new Line(80,Y-20,150,Y-20);{
            pl2.setStroke(Color.DEEPPINK);
            pl2.setStrokeWidth(12);
        }
        pl3 = new Line(160,Y,230,Y);{
            pl3.setStroke(Color.YELLOW);
            pl3.setStrokeWidth(12);
        }
        pl4 = new Line(240,Y-20,310,Y-20);{
            pl4.setStroke(Color.YELLOW);
            pl4.setStrokeWidth(12);
        }
        pl5 = new Line(320,Y,390,Y);{
            pl5.setStroke(Color.DEEPSKYBLUE);
            pl5.setStrokeWidth(12);
        }
        pl6 = new Line(400,Y-20,470,Y-20);{
            pl6.setStroke(Color.DEEPSKYBLUE);
            pl6.setStrokeWidth(12);
        }
        pl7 = new Line(480,Y,550,Y);{
            pl7.setStroke(Color.DARKVIOLET);
            pl7.setStrokeWidth(12);
        }
        pl8 = new Line(560,Y-20,630,Y-20);{
            pl8.setStroke(Color.DARKVIOLET);
            pl8.setStrokeWidth(12);
        }
        //
        pl01 = new Line(-80,Y-20,10,Y-20);{
            pl01.setStroke(Color.DARKVIOLET);
            pl01.setStrokeWidth(12);
        }
        pl02 = new Line(-160,Y,-230,Y);{
            pl02.setStroke(Color.DARKVIOLET);
            pl02.setStrokeWidth(12);
        }
        pl03 = new Line(-240,Y-20,-310,Y-20);{
            pl03.setStroke(Color.DEEPSKYBLUE);
            pl03.setStrokeWidth(12);
        }
        pl04 = new Line(-320,Y,-390,Y);{
            pl04.setStroke(Color.DEEPSKYBLUE);
            pl04.setStrokeWidth(12);
        }
        pl05 = new Line(-400,Y-20,-470,Y-20);{
            pl05.setStroke(Color.YELLOW);
            pl05.setStrokeWidth(12);
        }
        pl06 = new Line(-480,Y,-550,Y);{
            pl06.setStroke(Color.YELLOW);
            pl06.setStrokeWidth(12);
        }
        pl07 = new Line(-560,Y-20,-630,Y-20);{
            pl07.setStroke(Color.DEEPPINK);
            pl07.setStrokeWidth(12);
        }
        pl08 = new Line(-640,Y,-710,Y);{
            pl08.setStroke(Color.DEEPPINK);
            pl08.setStrokeWidth(12);
        }
        myRunningLines.getChildren().addAll(pl1,pl2,pl3,pl4,pl5,pl6,pl7,pl8);
        myRunningLines.getChildren().addAll(pl01,pl02,pl03,pl04,pl05,pl06,pl07,pl08);
        this.runline();
    }
    private void runline(){
        Line path1 = new Line(0,Y,700,Y);
        Line path2 = new Line(80,Y-20,780,Y-20);
        Line path3 = new Line(160,Y,860,Y);
        Line path4 = new Line(240,Y-20,940,Y-20);
        Line path5 = new Line(320,Y,1020,Y);
        Line path6 = new Line(400,Y-20,1100,Y-20);
        Line path7 = new Line(480,Y,1180,Y);
        Line path8 = new Line(560,Y-20,1260,Y-20);
        //
        Line path11 = new Line(-80,Y-20,620,Y-20);
        Line path12 = new Line(-160,Y,540,Y);
        Line path13 = new Line(-240,Y-20,460,Y-20);
        Line path14 = new Line(-320,Y,380,Y);
        Line path15 = new Line(-400,Y-20,300,Y-20);
        Line path16 = new Line(-480,Y,220,Y);
        Line path17 = new Line(-560,Y-20,140,Y-20);
        Line path18 = new Line(-640,Y,60,Y);
        //
        PathTransition p1 = new PathTransition();
        PathTransition p2 = new PathTransition();
        p1.setNode(pl1); p2.setNode(pl2);
        p1.setInterpolator(Interpolator.LINEAR);  p2.setInterpolator(Interpolator.LINEAR);
        p1.setPath(path1); p2.setPath(path2);
        p1.setDuration(Duration.millis(3000));  p2.setDuration(Duration.millis(3000));
        p1.setAutoReverse(true); p2.setAutoReverse(true);
        p1.setCycleCount(PathTransition.INDEFINITE);  p2.setCycleCount(PathTransition.INDEFINITE);
        p1.play();  p2.play();
        //
        PathTransition p3 = new PathTransition();
        PathTransition p4 = new PathTransition();
        p3.setNode(pl3); p4.setNode(pl4);
        p3.setInterpolator(Interpolator.LINEAR);  p4.setInterpolator(Interpolator.LINEAR);
        p3.setPath(path3); p4.setPath(path4);
        p3.setDuration(Duration.millis(3000));  p4.setDuration(Duration.millis(3000));
        p3.setAutoReverse(true); p4.setAutoReverse(true);
        p3.setCycleCount(PathTransition.INDEFINITE);  p4.setCycleCount(PathTransition.INDEFINITE);
        p3.play();  p4.play();
        //
        PathTransition p5 = new PathTransition();
        PathTransition p6 = new PathTransition();
        p5.setNode(pl5); p6.setNode(pl6);
        p5.setInterpolator(Interpolator.LINEAR);  p6.setInterpolator(Interpolator.LINEAR);
        p5.setPath(path5); p6.setPath(path6);
        p5.setAutoReverse(true); p6.setAutoReverse(true);
        p5.setDuration(Duration.millis(3000));  p6.setDuration(Duration.millis(3000));
        p5.setCycleCount(PathTransition.INDEFINITE);  p6.setCycleCount(PathTransition.INDEFINITE);
        p5.play();  p6.play();
        //
        PathTransition p7 = new PathTransition();
        PathTransition p8 = new PathTransition();
        p7.setNode(pl7); p8.setNode(pl8);
        p7.setInterpolator(Interpolator.LINEAR);  p8.setInterpolator(Interpolator.LINEAR);
        p7.setPath(path7); p8.setPath(path8);
        p7.setAutoReverse(true); p8.setAutoReverse(true);
        p7.setDuration(Duration.millis(3000));  p8.setDuration(Duration.millis(3000));
        p7.setCycleCount(PathTransition.INDEFINITE);  p8.setCycleCount(PathTransition.INDEFINITE);
        p7.play();  p8.play();
        //
        PathTransition p11 = new PathTransition();
        PathTransition p12 = new PathTransition();
        p11.setNode(pl01); p12.setNode(pl02);
        p11.setInterpolator(Interpolator.LINEAR);  p12.setInterpolator(Interpolator.LINEAR);
        p11.setPath(path11); p12.setPath(path12);
        p11.setAutoReverse(true); p12.setAutoReverse(true);
        p11.setDuration(Duration.millis(3000));  p12.setDuration(Duration.millis(3000));
        p11.setCycleCount(PathTransition.INDEFINITE);  p12.setCycleCount(PathTransition.INDEFINITE);
        p11.play();  p12.play();
        //
        PathTransition p13 = new PathTransition();
        PathTransition p14 = new PathTransition();
        p13.setNode(pl03); p14.setNode(pl04);
        p13.setInterpolator(Interpolator.LINEAR);  p14.setInterpolator(Interpolator.LINEAR);
        p13.setAutoReverse(true); p14.setAutoReverse(true);
        p13.setPath(path13); p14.setPath(path14);
        p13.setDuration(Duration.millis(3000));  p14.setDuration(Duration.millis(3000));
        p13.setCycleCount(PathTransition.INDEFINITE);  p14.setCycleCount(PathTransition.INDEFINITE);
        p13.play();  p14.play();
        //
        PathTransition p15 = new PathTransition();
        PathTransition p16 = new PathTransition();
        p15.setNode(pl05); p16.setNode(pl06);
        p15.setInterpolator(Interpolator.LINEAR);  p16.setInterpolator(Interpolator.LINEAR);
        p15.setPath(path15); p16.setPath(path16);
        p15.setAutoReverse(true); p16.setAutoReverse(true);
        p15.setDuration(Duration.millis(3000));  p16.setDuration(Duration.millis(3000));
        p15.setCycleCount(PathTransition.INDEFINITE);  p16.setCycleCount(PathTransition.INDEFINITE);
        p15.play();  p16.play();
        //
        PathTransition p17 = new PathTransition();
        PathTransition p18 = new PathTransition();
        p17.setNode(pl07); p18.setNode(pl08);
        p17.setInterpolator(Interpolator.LINEAR);  p18.setInterpolator(Interpolator.LINEAR);
        p17.setAutoReverse(true); p18.setAutoReverse(true);
        p17.setPath(path17); p18.setPath(path18);
        p17.setDuration(Duration.millis(3000));  p18.setDuration(Duration.millis(3000));
        p17.setCycleCount(PathTransition.INDEFINITE);  p18.setCycleCount(PathTransition.INDEFINITE);
        p17.play();  p18.play();
        //
    }

    @Override
    public int spriteHit(Circle ball) {
        Shape intersect = intersect(ball,pl1)  ;
        Shape intersect2 = intersect(ball,  pl2);
        Shape intersect3 = intersect(ball, pl3);
        Shape intersect4 = intersect( ball, pl4);
        Shape intersect5 = intersect(ball,pl5)  ;
        Shape intersect6 = intersect(ball,  pl6);
        Shape intersect7 = intersect(ball, pl7);
        Shape intersect8 = intersect( ball, pl8);
        Shape intersect9= intersect(ball,pl01)  ;
        Shape intersect10 = intersect(ball,  pl02);
        Shape intersect11 = intersect(ball, pl03);
        Shape intersect12 = intersect( ball, pl04);
        Shape intersect13 = intersect(ball,pl05)  ;
        Shape intersect14 = intersect(ball,  pl06);
        Shape intersect15 = intersect(ball, pl07);
        Shape intersect16 = intersect( ball, pl08);
        if (intersect.getBoundsInLocal().getWidth() != -1 || intersect2.getBoundsInLocal().getWidth() != -1 || intersect15.getBoundsInLocal().getWidth() != -1 || intersect16.getBoundsInLocal().getWidth() != -1 ){
            if(ball.getFill()!=Color.DEEPPINK) {
                return 1;
            }
        }
        else if (intersect3.getBoundsInLocal().getWidth() != -1 || intersect4.getBoundsInLocal().getWidth() != -1 || intersect13.getBoundsInLocal().getWidth() != -1 || intersect14.getBoundsInLocal().getWidth() != -1){
            if(ball.getFill()!=Color.YELLOW) {
                return 1;
            }
        }
        else if (intersect5.getBoundsInLocal().getWidth() != -1 || intersect6.getBoundsInLocal().getWidth() != -1 || intersect11.getBoundsInLocal().getWidth() != -1 || intersect12.getBoundsInLocal().getWidth() != -1){
            if(ball.getFill()!=Color.DEEPSKYBLUE) {
                return 1;
            }
        }
        else if (intersect7.getBoundsInLocal().getWidth() != -1 || intersect8.getBoundsInLocal().getWidth() != -1 || intersect9.getBoundsInLocal().getWidth() != -1 || intersect10.getBoundsInLocal().getWidth() != -1){
            if(ball.getFill()!=Color.DARKVIOLET) {
                return 1;
            }
        }
        return 0;
    }



}
