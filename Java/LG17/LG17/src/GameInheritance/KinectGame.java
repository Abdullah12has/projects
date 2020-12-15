package GameInheritance;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Burcu
 */
public class KinectGame extends Game {

    private double burnedCalorie;
    private double point;

    public KinectGame(int gameId, int publishedYear, String gameCategory, double burnedCalorie, double point) {
        super(gameId, publishedYear, gameCategory);
        this.burnedCalorie = burnedCalorie;
        this.point = point;
    }

    public double getBurnedCalorie() {
        return burnedCalorie;
    }

    @Override
    public String toString() {
        return "Kinect " + super.toString()
                + "\nBurned Calorie= " + burnedCalorie
                + "\nPoint= " + point + "\n";
    }

    @Override
    public int compareTo(Game g) {
        int res = this.gameId - g.getGameId();
        return (res);
    }
}
