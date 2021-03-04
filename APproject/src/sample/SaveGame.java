package sample;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveGame implements Serializable {
    double ballY;
    //Color ballcolor;
    ArrayList<Double> YAxis = new ArrayList<>();
    ArrayList<Double> Angles = new ArrayList<>();
    ArrayList<Integer> id = new ArrayList<>();
    String n; int game_id;
    int highscore;
    int ballcolour;
    public SaveGame(double ballY, List<GamePage> gameObjects,int highscore,int ballcolour, String Name, int i) throws IOException {
        this.ballY=ballY;
        this.n = Name;
        this.game_id = i;
        this.highscore=highscore;
        this.ballcolour=ballcolour;
        // this.ballcolor=color;
        for(int h=0;h<gameObjects.size();h++){
            if(gameObjects.get(h) instanceof Ring){
                Ring r = (Ring) gameObjects.get(h);
                double Y = r.getY();
                double angle = r.rotate1.getAngle();
                YAxis.add(Y);
                Angles.add(angle);
                id.add(1);
            }
            else if(gameObjects.get(h) instanceof Cross){
                Cross r = (Cross) gameObjects.get(h);
                double Y = r.getY();
                double angle = r.rotate1.getAngle();
                YAxis.add(Y);
                Angles.add(angle);
                id.add(2);
            }
            else if(gameObjects.get(h) instanceof Box){
                Box r = (Box) gameObjects.get(h);
                double Y = r.getY();
                double angle = r.rotate1.getAngle();
                YAxis.add(Y);
                Angles.add(angle);
                id.add(3);
            }
            else if(gameObjects.get(h) instanceof DoubleRing){
                DoubleRing r = (DoubleRing) gameObjects.get(h);
                double Y = r.getY();
                //double angle = r.rotate1.getAngle();
                double angle = r.r1.rotate1.getAngle();
                YAxis.add(Y);
                Angles.add(angle);
                id.add(4);
            }
            else if(gameObjects.get(h) instanceof DoubleCross){
                DoubleCross r = (DoubleCross) gameObjects.get(h);
                double Y = r.getY();
                double angle = r.c1.rotate1.getAngle();
                YAxis.add(Y);
                Angles.add(angle);
                id.add(5);
            }
            else if(gameObjects.get(h) instanceof RunningLines){
                RunningLines r = (RunningLines) gameObjects.get(h);
                double Y = r.getY();
                double angle = -1;
                YAxis.add(Y);
                Angles.add(angle);
                id.add(6);
            }
        }
        this.save(Name, i);
    }

    void save(String name, int i ) throws IOException {
        int fileno = 1;
        int finalno=1;
        boolean flag=true;
//        for (fileno = 1; fileno <= 3; fileno++) {
//            File files = new File(""+name+"_"+i+".txt");
//            if (!files.exists()) {
//                finalno = fileno;
//                flag=true;
//                break;
//            }
//        }
        if(flag){
            File files = new File(""+name+"_"+i+".txt");
            FileOutputStream file = null;
            try {
                file = new FileOutputStream(files);
                ObjectOutputStream out = new ObjectOutputStream(file);
                out.writeObject(this);
                out.close();
                file.close();
                System.out.println("serialized");

            } catch (IOException ex) {
                System.out.println("IOException here");
            }
        }
        else{
            File f1 = new File( 1 + ".txt");
            f1.delete();
            File files = new File(1+".txt");
            FileOutputStream file = null;
            try {
                file = new FileOutputStream(files);
                ObjectOutputStream out = new ObjectOutputStream(file);
                out.writeObject(this);
                out.close();
                file.close();
                System.out.println("serialized");

            } catch (IOException ex) {
                System.out.println("IOException here");
            }
        }
    }
}




