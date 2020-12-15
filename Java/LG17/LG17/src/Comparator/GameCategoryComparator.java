package Comparator;

import GameInheritance.Game;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Burcu
 */
public class GameCategoryComparator implements Comparator<Game> {

    @Override
    public int compare(Game g1, Game g2) {
        if (g1.getGameCategory().compareTo(g2.getGameCategory()) >= 0) {
            return 1;
        } else {
            return -1;
        }
     //return g1.getGameCategory().compareTo(g2.getGameCategory());
    }

}
