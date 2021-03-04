package sample;
import java.io.*;
import java.util.*;
public class Game {
        private Player UserPlayer;
        private int gameNo;
        private int finalScore;
        private long serialVersionUID;
        private HashMap<GameObjects, String> AllElements;

        public Game()
        {

        }

    public int getFinalScore() {
        return finalScore;
    }

    public int getGameNo() {
        return gameNo;
    }

    public Player getUserPlayer() {
        return UserPlayer;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

        public void pauseGame() {

        }



        public void saveGame() {

        }

        public void getAllElements() {

        }

}
