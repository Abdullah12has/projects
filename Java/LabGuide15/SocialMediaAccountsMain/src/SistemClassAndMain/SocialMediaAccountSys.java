/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemClassAndMain;
import SocialMediaHasA.Events;
import SocialMediaHasA.Posts;
import SocialMediaInheritance.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leyla
 */
public class SocialMediaAccountSys {
    public static ArrayList<SocialMediaAccount> accountList = new ArrayList();
    
    public static String createUrl(String name,String surname,String type)
    {
        String output = "";
        if(type.equalsIgnoreCase("instagram"))
            output += "https://www.instagram.com/";
        else
            output += "https://www.facebook.com/";
        output += name+"."+surname+".";
        int num = (int) ((Math.random()*((1000-100)+1))+100); ;
        output += num+"";
        return output;
                   
    }
    public static boolean addAccount(SocialMediaAccount socialAcc)
    {
         accountList.add(socialAcc);
         return true;
    }
    public static String readFromFile()
    {
        
        try {
            File file1 = new File("accounts.txt");
            
            Scanner sc = new Scanner(file1);
            while(sc.hasNext())
            {
                ArrayList<Posts> arr1 = new ArrayList<>();
                ArrayList<Events> arr2 = new ArrayList<>();
                String accountName = sc.next();
                String url = sc.next();
                int year = sc.nextInt();
                //System.out.println(accountName+" "+url+" "+year+" ");
                if(accountName.equalsIgnoreCase("Instagram"))
                {
                    int numOfFollow = sc.nextInt();
                    int numOfFollower = sc.nextInt();
                    int numOfPosts = sc.nextInt();
                    //System.out.println(numOfFollow+" "+numOfFollower+" "+numOfPosts+" ");
                    for (int i = 1; i <= numOfPosts; i++) {
                        int postID = sc.nextInt();
                        String topic = sc.next();
                        int imgeID = sc.nextInt();
                        //System.out.println(postID+" "+topic+" "+imgeID+" ");
                        Posts post = new Posts(postID, topic, imgeID);
                        arr1.add(post);
                    }
                    InstagramAccount instAcc = new InstagramAccount(accountName, url, year, numOfFollow, numOfFollower, numOfPosts, arr1);
                    accountList.add(instAcc);   
                }
                else if(accountName.equalsIgnoreCase("Facebook"))
                {
                    int numOfFriends = sc.nextInt();
                    int numOfEventsOrganized = sc.nextInt();
                    //System.out.println(numOfFriends+" "+numOfEventsOrganized);
                    for (int i = 1; i <= numOfEventsOrganized; i++) {
                        int eventID = sc.nextInt();
                        String eventName = sc.next();
                        String date = sc.next();
                        //System.out.println(eventID+" "+eventName+" "+date);
                        Events event = new Events(eventID, date, date);
                        arr2.add(event);
                    }
                    FacebookAccount faceAcc = new FacebookAccount(accountName, url, year, numOfFriends, numOfEventsOrganized,arr2);
                    accountList.add(faceAcc);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SocialMediaAccountSys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "File is read successfully";
    }
    
    public static String display()
    {
        String output = "";
        for (int i = 0; i < accountList.size(); i++) {
            SocialMediaAccount get = accountList.get(i);
            output += get.toString();
            
        }
        return output;
    }
    public static int findTotalNumberOfEvents()
    {
        int totalEvents = 0;
        for (int i = 0; i < accountList.size(); i++) {
            SocialMediaAccount get = accountList.get(i);
            if (get instanceof FacebookAccount)
                totalEvents += ((FacebookAccount) get).getNumOfEventsOrganized();
        }
        return totalEvents;
    }
    public static int findTotalNumberOfPosts()
    {
        int totalPosts = 0;
        for (int i = 0; i < accountList.size(); i++) {
            SocialMediaAccount get = accountList.get(i);
            if (get instanceof InstagramAccount)
                totalPosts += ((InstagramAccount) get).getNumOfPosts();
        }
        return totalPosts;
    }
}
