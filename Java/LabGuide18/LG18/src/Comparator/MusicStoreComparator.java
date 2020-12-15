/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparator;

import Inheritance.MusicStore;
import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Burcu
 */
public class MusicStoreComparator implements Comparator<MusicStore>, Serializable {

    @Override
    public int compare(MusicStore t, MusicStore t2) {
        if (t.getSoldProductType().compareTo(t2.getSoldProductType()) >= 0) {
            return 1;
        } else {
            return -1;
        }

    }

}
