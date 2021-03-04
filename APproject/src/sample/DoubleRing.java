package sample;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

import static javafx.scene.shape.Shape.intersect;

public class DoubleRing extends Obstacles {
    double X,Y,radius;
    Timeline timeline1;
    Rotate rotate1;
    double angle1=360;
    Ring r1,r2;
    Group myDoubleRing = new Group();
    public DoubleRing(double X,double Y, double radius){
        this.X=X;
        this.Y=Y;
        this.radius=radius;
        // rotate1=new Rotate(0,X,Y);
        this.draw();

    }
    public DoubleRing(double X,double Y, double radius,double angle1){
        this.X=X;
        this.Y=Y;
        this.radius=radius;
        this.angle1=angle1;
        //rotate1=new Rotate(angle1,X,Y);
        this.draw();
    }


    public double getY(){
        return this.Y;
    }
    public void setY(double d){
        this.Y=d;
    }

    private void draw(){
        r1=new Ring(X+radius+6,Y,radius);
        r2=new Ring(X-radius-6,Y,radius,angle1,1);
        r1.arc4.setStroke(Color.YELLOW);
        r1.arc2.setStroke(Color.DEEPSKYBLUE);
//        rotateNode2(r1.arc1,X+radius+6,Y, rotate1,angle1);
//        rotateNode2(r1.arc2,X+radius+6,Y, rotate1,angle1);
//        rotateNode2(r1.arc3,X+radius+6,Y, rotate1,angle1);
//        rotateNode2(r1.arc4,X+radius+6,Y, rotate1,angle1);
        //
        myDoubleRing.getChildren().addAll(r1.arc1,r1.arc2,r1.arc3,r1.arc4);
        myDoubleRing.getChildren().addAll(r2.arc1,r2.arc2,r2.arc3,r2.arc4);
    }
    @Override
    public int spriteHit(Circle ball) {
        Shape intersect = intersect(ball,(Shape) r2.arc1)  ;
        Shape intersect2 = intersect(ball, (Shape) r2.arc2);
        Shape intersect3 = intersect(ball, (Shape) r2.arc3);
        Shape intersect4 = intersect( ball, (Shape) r2.arc4);
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
