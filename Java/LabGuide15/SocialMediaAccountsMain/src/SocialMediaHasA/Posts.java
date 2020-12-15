/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialMediaHasA;

import SocialInterface.PostInterface;

/**
 *
 * @author Leyla
 */
public class Posts implements PostInterface{
    private int id;
    private String topic;
    private int imageID;

    public Posts(int id, String topic, int imageID) {
        this.id = id;
        this.topic = topic;
        this.imageID = imageID;
    }

    @Override
    public String toString() {
        return "\nId=" + id + "\nTopic=" + topic + "\nImage ID=" + imageID+"\nAdded Feature is "+addFeatureToPost();
    }

    @Override
    public String addFeatureToPost() {
        if(topic.equalsIgnoreCase("Politics") && imageID>=1 && imageID<=10)
            return "Popular Post";
        else if(topic.equalsIgnoreCase("Health") && imageID>10 && imageID<=20)
             return "High Important Post";
        else if(topic.equalsIgnoreCase("Personal") && imageID>20 && imageID<=30)
             return "Personal Post";
        else
            return "Normal Post";
    }
    
    
    
}
