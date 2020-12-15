/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialMediaInheritance;

public abstract class SocialMediaAccount {
    protected String name;
    protected String url;
    protected int publishYear;

    public SocialMediaAccount(String name, String url, int publishYear) {
        this.name = name;
        this.url = url;
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return  "\nName=" + name + "\nUrl=" + url + "\nPublishYear=" + publishYear ;
    }
}
