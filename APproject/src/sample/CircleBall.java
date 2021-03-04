package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class CircleBall extends Ball{
    Circle ball;
    Color c ;
    private double y1;
    public CircleBall()
    {
        super(0);
        this.drawShape();
        this.y1 = 650;
    }
    public CircleBall(double y)
    {
        super(0);
        this.y1 = y1;
        this.drawShape();


    }


    public Circle drawShape()
    {
        ball = new Circle(295,y1,10);
        Random r = new Random();
        int n = r.nextInt(4)+1;
        if(n == 1)
            c = Color.DEEPPINK;
        else if(n == 2) c = Color.YELLOW;
        else if(n == 3) c = Color.DARKVIOLET;
        else c = Color.DEEPSKYBLUE;
        ball.setFill(c);
        ball.setStroke(Color.TRANSPARENT);
        return ball;
    }
    public Color getColor(){
        return c;
    }

}