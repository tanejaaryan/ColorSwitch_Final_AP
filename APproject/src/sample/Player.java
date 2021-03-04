package sample;

import java.io.Serializable;

public class Player implements Serializable {
    String name;
    int highscore;
    int id;
    public Player(String name,int highscore, int game){
        this.name = name;
        this.highscore=highscore;
        this.id = game;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
