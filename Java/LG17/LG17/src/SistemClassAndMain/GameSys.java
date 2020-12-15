package SistemClassAndMain;

import Comparator.GameCategoryComparator;
import Comparator.GamePublishedYearComparator;
import GameInheritance.Game;
import GameInheritance.KinectGame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Burcu
 */
public class GameSys {

    private static HashSet<Game> gameSet = new HashSet<Game>();

    public static void readFromFile() {
        Scanner sc = null;
        try {
            File file1 = new File("games.txt");

            sc = new Scanner(file1);
            while (sc.hasNext()) {
                int gameId, publishYear;
                String category;
                double point, calorie;
                gameId = sc.nextInt();
                publishYear = sc.nextInt();
                category = sc.next();
                calorie = sc.nextDouble();
                point = sc.nextDouble();
                KinectGame kg = new KinectGame(gameId, publishYear, category, calorie, point);
                gameSet.add(kg);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameSys.class.getName()).log(Level.SEVERE, null, ex);
        }
        sc.close();
    }

    public static boolean addToGameSet(int gameId, int publishedYear, String gameCategory, double burnedCalorie, double point) {
        Game g = new KinectGame(gameId, publishedYear, gameCategory, burnedCalorie, point);
        for (Game gm : gameSet) {
            if (gm.getGameId() == gameId) {
                return false;
            }
        }
        gameSet.add(g);
        return true;

    }

    public static Set<Game> getGame() {
        return gameSet;
    }

    public static Game search(int gameId) {
        //With the iterator
        Iterator<Game> i = gameSet.iterator();
        while (i.hasNext()) {
            Game g = i.next();
            if (g.getGameId() == gameId) {
                return g;
            }
        }
        //With for loop
        /*
        for (Game g : gameSet) {
            if (g.getGameId() == gameId) {
                return g;
            }
        }*/

        return null;
    }

    public static String[] getGameId() {
        //With for loop
        int i = 0;

        TreeSet<Game> gt = new TreeSet<>();
        gt.addAll(gameSet);
        String[] gameId = new String[gt.size()];
        for (Game g : gt) {
            gameId[i] = g.getGameId() + "";
            i++;
        }
        //with the iterator
        /*
        int j = 0;
        Iterator<Game> it = gt.iterator();
        while (it.hasNext()) {
            gameId[j] = it.next().getGameId() + "";
            j++;
        }
         */
        return gameId;
    }

    public static String displayAll() {

        TreeSet<Game> ts = new TreeSet();
        ts.addAll(gameSet);
        String res = "";
        for (Game g : ts) {
            res += g.toString() + "\n\n";
        }
        return res;
    }

    public static String displayGamesByCategory() {
        GameCategoryComparator gcc = new GameCategoryComparator();
        TreeSet<Game> ts = new TreeSet(gcc);// compare according to the category by using comparator
        ts.addAll(gameSet);
        String res = "";
        for (Game g : ts) {
            res += g.toString() + "\n";
        }

        return res;
    }

    public static String displayGamesByPublishedYear() {
        GamePublishedYearComparator gpc = new GamePublishedYearComparator();
        TreeSet<Game> ts = new TreeSet(gpc);// compare according to the published year by using comparable
        ts.addAll(gameSet);
        String res = "";
        for (Game g : ts) {
            res += g.toString() + "\n";
        }
        return res;
    }
}
