package MainAndSystemClass;

import java.io.*;
import java.util.*;

public class MapSis {
    //key is section number, value is students' name and surname

    static HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
    private static final int MAXSECTIONNUMBERS = 5;

    public static HashMap<Integer, ArrayList<String>> getMap() {
        return map;
    }

    public static void readStudentsAccordingToSections() {
        for (int i = 1; i <= MAXSECTIONNUMBERS; i++) {
            String filename = "section" + i + ".txt";
            File f = new File(filename);
            if (!f.exists()) {
                return;
            }
            ArrayList<String> studentList = new ArrayList<String>();
            Scanner input = null;
            try {
                input = new Scanner(f);
                while (input.hasNextLine()) {
                    String studentInfo = input.nextLine();
                    studentList.add(studentInfo);
                }
                map.put(i, studentList);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (input != null) {
                    input.close();
                }
            }

        }
    }

    public static void addStudentToSection(int sec, String name) {
        ArrayList<String> studentList = null;

        if (map.containsKey(sec)) {
            studentList = map.get(sec);
            studentList.add(name + "\n");
            map.put(sec, studentList);
        } else {
            studentList = new ArrayList();

            studentList.add(name);
            map.put(sec, studentList);
        }
        writeStudentToSectionFile(sec, name);

    }

    public static void writeStudentToSectionFile(int sec, String name) {
        String filename = "section" + sec + ".txt";
        File f = new File(filename);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(f, true));
            pw.write("\n" + name);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (pw != null) {
            pw.close();
        }

    }

    public static String displayStudents() {
        Set<Integer> sectionNumbres = map.keySet();

        String res = "";
        for (Integer sectionNumber : sectionNumbres) {
            res += " Section " + sectionNumber + "\n___________________________\n";
            ArrayList<String> studentList = map.get(sectionNumber);

            for (String studentInfo : studentList) {
                res += studentInfo + "\n";
            }
            res += "\n";
        }

        return res;
    }

    public static String displaySectionStudents(String sectionNumber) {
        int key = Integer.parseInt(sectionNumber);

        String msg = "section number not available";

        if (map.containsKey(key)) {
            ArrayList<String> al = map.get(key);
            msg = "Section " + sectionNumber + "\n------------------\n";
            for (String names : al) {
                msg += names + "\n";
            }
        }
        return msg;
    }

    public static String[] getSections() {
        Set<Integer> sectionNumbers = map.keySet();

        String[] sections = new String[sectionNumbers.size()];
        int i = 0;
        for (Integer section : sectionNumbers) {
            sections[i] = section + "";
            i++;
        }
        return sections;

    }
}
