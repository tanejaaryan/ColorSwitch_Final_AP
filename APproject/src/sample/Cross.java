package sample;
import javafx.animation.Timeline;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

import static javafx.scene.shape.Shape.intersect;

public class Cross extends Obstacles {
    double X;
    double Y;
    double side;
    Rectangle r1,r2,r3,r4;
    Group myCross = new Group();
    Timeline timeline1;
    double angle=0;
    Rotate rotate1;

    public Cross(double X,double Y, double side){
        this.X=X;
        this.Y=Y;
        this.side=side;
        rotate1=new Rotate(0,X,Y);
        this.draw();

    }
    public Cross(double X,double Y, double side,double angle){
        this.X=X;
        this.Y=Y;
        this.side=side;
        this.angle=angle;
        rotate1=new Rotate(angle,X,Y);
        this.draw();
    }

    public Cross(double X,double Y, double side,double angle,int bool){
        this.X=X;
        this.Y=Y;
        this.side=side;
        this.angle=angle;
        rotate1=new Rotate(angle,X,Y);
        rotate1.setAxis(new Point3D(0, 0, -1));
        this.draw();
    }

    public double getY(){
        return this.Y;
    }
    public void setY(double d){
        this.Y=d;
    }
    private void draw(){
        r1 = new Rectangle(X-side,Y-6,side,12);
        r2 = new Rectangle(X,Y-6,side,12);
        r3 = new Rectangle(X-6,Y-side,12,side);
        r4 = new Rectangle(X-6,Y,12,side);
        r1.setFill(Color.DEEPPINK);
        r2.setFill(Color.YELLOW);
        r3.setFill(Color.DARKVIOLET);
        r4.setFill(Color.DEEPSKYBLUE);
        r1.setArcHeight(10.0);  r2.setArcHeight(10.0);  r3.setArcHeight(10.0); r4.setArcHeight(10.0);
        r1.setArcWidth(10.0);  r2.setArcWidth(10.0);  r3.setArcWidth(10.0); r4.setArcWidth(10.0);
        rotateNode(r1,X,Y, rotate1,angle); rotateNode(r2,X,Y, rotate1,angle);
        rotateNode(r3,X,Y, rotate1,angle); rotateNode(r4,X,Y, rotate1,angle);
        myCross.getChildren().addAll(r1,r2,r3,r4);
    }


    @Override
    public int spriteHit(Circle ball) {
        Shape intersect = intersect(ball,r1)  ;
        Shape intersect2 = intersect(ball,  r2);
        Shape intersect3 = intersect(ball, r3);
        Shape intersect4 = intersect( ball, r4);
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
