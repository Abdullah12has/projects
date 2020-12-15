/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialMediaInheritance;
import SocialMediaHasA.Events;

import java.util.ArrayList;

/**
 *
 * @author Leyla
 */
public class FacebookAccount extends SocialMediaAccount{
    private int numOfFriends;
    private int numOfEventsOrganized;
    private ArrayList<Events> eventList = new ArrayList();

    public int getNumOfEventsOrganized() {
        return numOfEventsOrganized;
    }

    
    public FacebookAccount(String name, String url, int publishYear,int numOfFriends, int numOfEventsOrganized,ArrayList<Events> temp) {
        super(name, url, publishYear);
        this.numOfFriends = numOfFriends;
        this.numOfEventsOrganized = numOfEventsOrganized;
        this.eventList = temp;
    }

    @Override
    public String toString() {
        return "\nFacebookAccount" +super.toString()+ "\nNumber Of Friends=" + numOfFriends + "\nNumber Of Events Organized=" + numOfEventsOrganized + "\nEvent List=" + eventList ;
    }
    
    
    
}
