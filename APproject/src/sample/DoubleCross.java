package sample;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

import static javafx.scene.shape.Shape.intersect;

public class DoubleCross extends Obstacles {
    double X,Y ,side;
    Cross c1,c2;
    Timeline timeline1;
    Timeline timeline2;
    Rotate rotate1=new Rotate();
    double angle1=0;
    Group myDoubleCross = new Group();
    public DoubleCross(double X,double Y,double side){
        this.X=X;
        this.Y=Y;
        this.side=side;
        this.draw();

    }
    public DoubleCross(double X,double Y,double side,double angle1){
        this.angle1=angle1;
        this.X=X;
        this.Y=Y;
        this.side=side;
        this.draw();
    }
    public double getY(){
        return this.Y;
    }
    public void setY(double d){
        this.Y=d;
    }
    private void draw(){
        c1 = new Cross(X+side,Y,side,angle1);
        c2= new Cross(X-side,Y,side,angle1,1);
        c1.r1.setFill(Color.YELLOW);
        c1.r2.setFill(Color.DEEPPINK);
        // rotateNode2(c1.r1,X+side,Y, c1.rotate1,angle1); rotateNode2(c1.r2,X+side,Y, c1.rotate1,angle1); rotateNode2(c1.r3,X+side,Y, c1.rotate1,angle1); rotateNode2(c1.r4,X+side,Y, c1.rotate1,angle1);
        myDoubleCross.getChildren().addAll(c1.r1,c1.r2,c1.r3,c1.r4,c2.r1,c2.r2,c2.r3,c2.r4);
    }

    @Override
    public int spriteHit(Circle ball) {
        Shape intersect = intersect(ball,(Shape) c2.r1)  ;
        Shape intersect2 = intersect(ball, (Shape) c2.r2);
        Shape intersect3 = intersect(ball, (Shape) c2.r3);
        Shape intersect4 = intersect( ball, (Shape) c2.r4);
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
