package sample;

import javafx.animation.*;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.ArrayList;

public abstract class Obstacles extends GamePage {
    static ArrayList<Timeline> timelines = new ArrayList<>();
    public void rotateNode(Node node, double X, double Y, Rotate rotate, double angle){
        rotate.setAngle(angle);
        node.getTransforms().add(rotate);
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), angle)),
                new KeyFrame(Duration.seconds(4), new KeyValue(rotate.angleProperty(), angle+360)));
        timelines.add(timeline);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.play();
    }

    public void rotateNode2(Node node, double X, double Y, Rotate rotate, double angle){
        rotate.setAngle(angle);
        node.getTransforms().add(rotate);
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), angle)),
                new KeyFrame(Duration.seconds(2), new KeyValue(rotate.angleProperty(), angle-360)));
        timelines.add(timeline1);
        timeline1.setAutoReverse(false);
        timeline1.play();
    }
    public abstract int spriteHit(Circle ball);
}
