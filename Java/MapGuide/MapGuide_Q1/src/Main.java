
import java.util.HashMap;

public class Main {

    public static void printMap(HashMap mapRef) {
        System.out.println(mapRef.toString());
        System.out.println("size: " + mapRef.size());
        System.out.println("isEmpty: " + mapRef.isEmpty());
        System.out.println("Key Set: " + mapRef.keySet());
        System.out.println("Values: " + mapRef.values());
    }

    public static void main(String[] args) {
        String names[] = {"ali", "veli", "ceren", "leyla", "hatice", "burcu", "neşe", "ceren", "ahmet", "leyla"};
        HashMap<Character, Integer> hm = new HashMap();

        for (int k = 0; k < names.length; k++) {
            for (int j = 0; j < names[k].length(); j++) {
                if (!hm.containsKey(names[k].charAt(j))) {
                    hm.put(names[k].charAt(j), 1);
                } else {
                    Integer mapEntry = hm.get(names[k].charAt(j));
                    hm.put(names[k].charAt(j), mapEntry + 1);
                }
            }
        }
        System.out.print("\nNumber of occurences of each letter: ");
        printMap(hm);
    }
}
