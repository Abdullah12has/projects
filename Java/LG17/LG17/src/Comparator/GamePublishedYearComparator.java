/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparator;

import GameInheritance.Game;
import java.util.Comparator;

/**
 *
 * @author Burcu
 */
public class GamePublishedYearComparator implements Comparator<Game> {

    @Override
    public int compare(Game g1, Game g2) {
         if (g2.getPublishedYear() - g1.getPublishedYear() >= 0) {
            return 1;
        } else {
            return -1;
        }
   
    }

}
