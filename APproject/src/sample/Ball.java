package sample;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class Ball extends GamePage {
    protected double speed;
    protected static double gravity = 140;
    protected Color ballColour;
    protected double X;
    protected double Y;

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    public Ball(double s)
    {
        this.speed = s;
    }
    public Color getBallColour() {
        return ballColour;
    }

    public void setBallColour(Color ballColour) {
        this.ballColour = ballColour;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public static double getGravity() {
        return gravity;
    }
    public void GoingUp()
    {

    }
    public void GoingDown()
    {

    }
    public abstract Shape drawShape();
    public void update(){}
}