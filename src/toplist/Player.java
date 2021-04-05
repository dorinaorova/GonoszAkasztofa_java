package toplist;

import java.io.Serializable;

public class Player  implements Serializable {
    private String name;
    private double points;
    private int wins;
    private int games;

    public Player(String n, double p, boolean w){
        name=n;
        points=p;
        if(w) wins=1;
        else wins=0;
        games=1;
    }

    public String getName() {
        return name;
    }


    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points += points;
    }

    public double getWins() {
        return Math.round((wins+0.0)/games*100.0);
    }

    public void setWins(boolean win) {
        if(win) wins+=1;
    }
    public void setGames(){
        games+=1;
    }
}
