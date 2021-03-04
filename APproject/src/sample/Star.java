package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;

import static javafx.scene.shape.Shape.intersect;

public class Star extends GamePage {
    double X;double Y;
    Image image4;
    ImageView imageView4;
    Rectangle rectangle;
    public Star(double X,double Y) throws FileNotFoundException {
        this.X=X;
        this.Y=Y;
        this.insert();
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    private void insert() throws FileNotFoundException {
        rectangle=new Rectangle();
        image4 = new Image(new FileInputStream("/Users/aryantaneja/Downloads/silver.gif"),100,100,true,false);
        rectangle.setFill(new ImagePattern(image4));
        rectangle.setX(X); rectangle.setY(Y);
        rectangle.setHeight(50); rectangle.setWidth(50);
    }

    public int spriteHit(Circle ball) {
        Shape intersect = intersect(ball,rectangle)  ;
        if (intersect.getBoundsInLocal().getWidth() != -1) {
            return 1;
        }
        return 0;
    }
    public void remove(){
    }
}

