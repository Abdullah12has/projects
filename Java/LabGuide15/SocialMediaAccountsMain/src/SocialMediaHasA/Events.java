/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialMediaHasA;

/**
 *
 * @author Leyla
 */
public class Events {
    private int id;
    private String name;
    private String date;

    public Events(int id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "\nId=" + id + "\nName=" + name + "\nDate=" + date;
    }
    
    
    
}
