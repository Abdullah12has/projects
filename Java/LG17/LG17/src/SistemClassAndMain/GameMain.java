/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemClassAndMain;

import GUI.GameFrame;


/**
 *
 * @author Burcu
 */
public class GameMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameSys.readFromFile();
        GameFrame gf = new GameFrame();
        gf.setVisible(true);
       

    }

}
