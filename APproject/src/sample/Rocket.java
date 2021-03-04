package sample;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.io.FileNotFoundException;

public class Rocket extends Ball{

    public Rocket() throws FileNotFoundException {
        super(0);
        this.drawShape();
    }

    @Override
    public Polygon drawShape() {
        return null;
    }


}
