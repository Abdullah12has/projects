/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemClassAndMain;

import Comparator.MusicStoreComparator;
import Inheritance.MusicStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Burcu
 */
public class MusicStoreSys {

    private static HashSet<MusicStore> storeSet = new HashSet();
    private static TreeSet<MusicStore> storeSortedSet;

    public static void readToSet() {
        try {
            Scanner s = new Scanner(new File("store.txt"));
            while (s.hasNextLine()) {
                String[] arr = s.nextLine().split(":");
                MusicStore st = new MusicStore(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]);
                storeSet.add(st);
            }
            s.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public static boolean addMusicStore(int id, String storeName, String soldProductType, String storeAddress) {//not sorted
        MusicStore m = new MusicStore(id, storeName, soldProductType, storeAddress);
        for (MusicStore mu : storeSet) {
            if (mu.getId() == id) {
                return false;
            }
        }
        storeSet.add(m);

        return true;
    }

    public static HashSet<MusicStore> getStoreSet() {
        return storeSet;
    }

    public static void readFromBinary() {
        ObjectInputStream obji;
        try {

            obji = new ObjectInputStream(new FileInputStream("output.bin"));

            storeSortedSet = new TreeSet<MusicStore>(new MusicStoreComparator());
            storeSortedSet.addAll((HashSet<MusicStore>) obji.readObject());
            
            
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ClassNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

    }

    public static void writeToBin() {
        ObjectOutputStream objo;
        try {
            objo = new ObjectOutputStream(new FileOutputStream("output.bin"));

            objo.writeObject(storeSet);

            objo.close();
        } catch (FileNotFoundException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        } catch (IOException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();

        }
    }

    public static String displaySet() {//not sorted
        String res = "";
        for (MusicStore musicStore : storeSet) {
            res += musicStore.toString() + "\n";
        }

        return res;
    }

    public static String displayTreeSetByMusicStoreId() {//sorted by store Id
        TreeSet<MusicStore> ts= new TreeSet<MusicStore>();

        ts.addAll(storeSet);
        String res = "";
        for (MusicStore a : ts) {
            res += a.toString() + "\n";
        }
        return res;
    }

    public static String displayTreeSetByProductType() {//sorted by product type

        String res = "";
        for (MusicStore a : storeSortedSet) {
            res += a.toString() + "\n";
        }
        return res;
    }

}
