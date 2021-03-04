package sample;

import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;


public class TriangleObstacle extends Obstacles {
    double X,Y;
    Line tr1,tr2,tr3;
    Timeline timeline1;
    double angle=0;
    Rotate rotate1;
    public TriangleObstacle(double X,double Y){
        rotate1=new Rotate(0,X,Y);
        this.draw();

    }
    public TriangleObstacle(double X,double Y,double angle){
        this.draw();
        this.angle=angle;
        rotate1=new Rotate(angle,X,Y);
    }
    private void draw(){
        tr1 = new Line(380,300,520,300);{
            tr1.setStroke(Color.DEEPSKYBLUE);
            tr1.setStrokeWidth(12);
        }
        tr2 = new Line(380,300,450,178.76);{
            tr2.setStroke(Color.DARKVIOLET);
            tr2.setStrokeWidth(12);
        }
        tr3 = new Line(520,300,450,178.76);{
            tr3.setStroke(Color.YELLOW);
            tr3.setStrokeWidth(12);
        }
        rotateNode(tr1,450,260, rotate1,angle);
        rotateNode(tr2,450,260, rotate1,angle);
        rotateNode(tr3,450,260, rotate1,angle);
    }

    @Override
    public int spriteHit(Circle ball) {
        return 0;
    }
}
