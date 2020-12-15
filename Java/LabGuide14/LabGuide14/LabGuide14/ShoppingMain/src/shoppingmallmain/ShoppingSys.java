package shoppingmallmain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShoppingSys {

    public static ArrayList<ShoppingMall> arr = new ArrayList();

    public static void readTxt(String fileName) {
        
        File file = new File(fileName);
        Scanner sc;
        try {
            sc = new Scanner(file);
            while (sc.hasNext()) {
                ArrayList shops = new ArrayList();
                String id = sc.next();
                String name = sc.next();
                String address = sc.next();
                int numOfPark = sc.nextInt();
                double closedHour = sc.nextDouble();
                for (int i = 0; i < 3; i++) {
                    shops.add(sc.next());
                }

                ShoppingMall sm = new ShoppingMall(id, name, address, numOfPark, closedHour, shops);
                arr.add(sm);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ShoppingSys.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean addShoppingMall(ShoppingMall sm) {
        for (int i = 0; i < arr.size(); i++) {
            ShoppingMall get = arr.get(i);
            if (sm.getId().equalsIgnoreCase(get.getId())) {
                return false;
            }
        }
        arr.add(sm);
        return true;
    }

    public static ShoppingMall searchShoppingMall(String id) {
        for (int i = 0; i < arr.size(); i++) {
            ShoppingMall get = arr.get(i);
            if (id == get.getId()) {
                return get;
            }
        }
        return null;
    }

    public static String display() {
        String output = "";
        for (int i = 0; i < arr.size(); i++) {
            ShoppingMall get = arr.get(i);
            output += get.toString() + "\n";
        }
        return output;
    }
}
