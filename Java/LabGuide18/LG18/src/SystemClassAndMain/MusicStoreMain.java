/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemClassAndMain;

import GUI.MusicStoreFrame;

/**
 *
 * @author Burcu
 */
public class MusicStoreMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MusicStoreSys.readToSet();
        MusicStoreFrame mf = new MusicStoreFrame();
        mf.setVisible(true);
    }

}
