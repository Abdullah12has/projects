/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lg12_q1b;

/**
 *
 * @author Burcu
 */
public class Student {

    private int id;
    private String name;
    private String surname;
    private double cgpa;

    public Student(int id, String name, String surname, double cgpa) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cgpa = cgpa;
    }

    public boolean findId(int id) {
        if (this.id == id) {
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }
   

    @Override
    public String toString() {
        return "Student\n"
                + "\nId= " + id
                + "\nName= " + name
                + "\nSurname= " + surname
                + "\nCgpa= " + cgpa;
    }

}
