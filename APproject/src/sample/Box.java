package sample;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

import static javafx.scene.shape.Shape.intersect;

public class Box extends Obstacles {
    double X;
    double Y;
    double side;
    Timeline timeline1;
    double angle=0;
    Rotate rotate1;
    Rectangle r11,r22,r33,r44;
    Group myBox = new Group();
    public Box(double X,double Y, double side){
        this.X=X;
        this.Y=Y;
        this.side=side;
        rotate1=new Rotate(0,X,Y);
        this.draw();

    }
    public Box(double X,double Y, double side,double angle){
        this.X=X;
        this.Y=Y;
        this.side=side;
        this.angle=angle;
        rotate1=new Rotate(angle,X,Y);
        this.draw();


    }
    public double getY(){
        return this.Y;
    }
    public void setY(double d){
        this.Y=d;
    }
    private void draw(){
        r11 = new Rectangle(X-(side/2),Y+(side/2),side+6,12);
        r22 = new Rectangle(X-(side/2),Y-(side/2),side+6,12);
        r33 = new Rectangle(X-(side/2),Y-(side/2),12,side+12);
        r44 = new Rectangle(X+(side/2),Y-(side/2),12,side+12);
        r11.setFill(Color.DEEPPINK);
        r22.setFill(Color.YELLOW);
        r33.setFill(Color.DARKVIOLET);
        r44.setFill(Color.DEEPSKYBLUE);
        r11.setArcHeight(10.0);  r22.setArcHeight(10.0);  r33.setArcHeight(10.0); r44.setArcHeight(10.0);
        r11.setArcWidth(10.0);  r22.setArcWidth(10.0);  r33.setArcWidth(10.0); r44.setArcWidth(10.0);
        rotateNode(r11,X,Y, rotate1,angle); rotateNode(r22,X,Y, rotate1,angle);
        rotateNode(r33,X,Y, rotate1,angle); rotateNode(r44,X,Y, rotate1,angle);
        myBox.getChildren().addAll(r11,r22,r33,r44);
    }
    @Override
    public int spriteHit(Circle ball) {
        Shape intersect = intersect(ball,(Shape) r11)  ;
        Shape intersect2 = intersect(ball, (Shape) r22);
        Shape intersect3 = intersect(ball, (Shape) r33);
        Shape intersect4 = intersect( ball, (Shape) r44);
        if (intersect.getBoundsInLocal().getWidth() != -1 && ball.getFill()!=Color.DEEPPINK) {
            return 1;
        }
        else if (intersect2.getBoundsInLocal().getWidth() != -1 && ball.getFill()!=Color.YELLOW) {
            return 1;
        }
        else if (intersect3.getBoundsInLocal().getWidth() != -1 && ball.getFill()!=Color.DARKVIOLET)
        {
            return 1;
        }
        else if (intersect4.getBoundsInLocal().getWidth() != -1 && ball.getFill()!=Color.DEEPSKYBLUE){
            return 1;
        }
        return 0;
    }

}

