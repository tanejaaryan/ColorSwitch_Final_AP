package sample;
import javafx.animation.Timeline;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

import static javafx.scene.shape.Shape.intersect;


public class Ring extends Obstacles {
    double X;
    double Y;
    Timeline timeline1;
    Rotate rotate1;
    Arc arc1;
    Arc arc2;
    Arc arc3;
    Arc arc4;
    double angle=0;
    double radius;
    Group myRing=new Group();

    public Ring(double X, double Y,double radius){
        this.X = X;
        this.Y=Y;
        this.radius=radius;
        rotate1=new Rotate(0,X,Y);
        this.draw();

    }

    public Ring(double X, double Y,double radius,double angle){
        this.X = X;
        this.Y=Y;
        this.radius=radius;
        this.angle=angle;
        rotate1=new Rotate(angle,X,Y);
        this.draw();
    }

    public Ring(double X,double Y, double radius,double angle,int bool){
        this.X=X;
        this.Y=Y;
        this.radius=radius;
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
        arc1= new Arc();arc2 = new Arc();arc3 = new Arc();arc4= new Arc();
        //
        arc1.setCenterX(X);arc1.setCenterY(Y);
        arc1.setRadiusX(radius);arc1.setRadiusY(radius);
        arc1.setStartAngle(45.0f);
        arc1.setLength(90.0f);
        arc1.setStroke(Color.DEEPPINK);arc1.setStrokeWidth(12);arc1.setFill(Color.TRANSPARENT);
        arc1.setStrokeType(StrokeType.CENTERED);
        arc1.setType(ArcType.OPEN);
        //
        arc2.setCenterX(X);arc2.setCenterY(Y);
        arc2.setRadiusX(radius);arc2.setRadiusY(radius);
        arc2.setStartAngle(135.0f);
        arc2.setLength(90.0f);
        arc2.setStroke(Color.YELLOW);arc2.setStrokeWidth(12);arc2.setFill(Color.TRANSPARENT);
        arc2.setType(ArcType.OPEN);
        arc2.setStrokeType(StrokeType.CENTERED);
        //
        arc3.setCenterX(X); arc3.setCenterY(Y);
        arc3.setRadiusX(radius); arc3.setRadiusY(radius);
        arc3.setStartAngle(225.0f);
        arc3.setLength(90.0f);
        arc3.setStroke(Color.DARKVIOLET); arc3.setStrokeWidth(12); arc3.setFill(Color.TRANSPARENT);
        arc3.setType(ArcType.OPEN);
        arc3.setStrokeType(StrokeType.CENTERED);
        //
        arc4.setCenterX(X); arc4.setCenterY(Y);
        arc4.setRadiusX(radius); arc4.setRadiusY(radius);
        arc4.setStartAngle(315.0f);
        arc4.setLength(90.0f);
        arc4.setStroke(Color.DEEPSKYBLUE); arc4.setStrokeWidth(12); arc4.setFill(Color.TRANSPARENT);
        arc4.setType(ArcType.OPEN);
        arc4.setStrokeType(StrokeType.CENTERED);
        rotateNode(arc1,X,Y, rotate1,angle); rotateNode(arc2,X,Y, rotate1,angle); rotateNode(arc3,X,Y, rotate1,angle); rotateNode(arc4,X,Y, rotate1,angle);
        myRing.getChildren().addAll(arc1,arc2,arc3,arc4);
    }

    @Override
    public int spriteHit(Circle ball) {
        Shape intersect = intersect(ball,(Shape) arc1)  ;
        Shape intersect2 = intersect(ball, (Shape) arc2);
        Shape intersect3 = intersect(ball, (Shape) arc3);
        Shape intersect4 = intersect( ball, (Shape) arc4);
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
