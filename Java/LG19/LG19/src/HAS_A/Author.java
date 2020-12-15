/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HAS_A;

import java.io.Serializable;

/**
 *
 * @author Burcu
 */
public class Author implements Serializable {

    private int id;
    private String name;
    private String surname;

    public Author(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "Id= " + id
                + "\nName= " + name
                + "\nSurname= " + surname;

    }
}
