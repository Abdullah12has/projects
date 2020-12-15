/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lg12_q1b;

import java.util.ArrayList;

/**
 *
 * @author Burcu
 */
public class StudentSys {

    public static ArrayList<Student> students = new ArrayList<Student>();

    public static boolean checkId(int id) {
        for (Student s : students) {
            if (s.findId(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean addStudent(int id, String name, String surname, double cgpa) {
        if (checkId(id)) {
            return true;
        } else {
            students.add(new Student(id, name, surname, cgpa));
            return false;
        }
        
        /* OR
         for (Student s : students) 
            if (s.findId(id)) {
                return true;
            } else {
                students.add(new Student(id, name, surname, cgpa));
                return false;
            }
          return false; 
        */
    }

    public static String displayStudent() {
        String res = "";

        for (Student s : students) {
            res += s.toString() + "\n";
        }

        return res;
    }

}
