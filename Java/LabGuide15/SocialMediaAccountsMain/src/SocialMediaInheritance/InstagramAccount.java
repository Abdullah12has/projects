/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialMediaInheritance;

import java.util.ArrayList;
import SocialMediaHasA.Posts;
/**
 *
 * @author Leyla
 */
public class InstagramAccount extends SocialMediaAccount{
    private int numOfFollow;
    private int numOfFollower;
    private int numOfPosts;
    private ArrayList<Posts> postList = new ArrayList();

    public InstagramAccount(String name, String url, int publishYear,int numOfFollow, 
            int numOfFollower, int numOfPosts,ArrayList<Posts> temp) {
        super(name, url, publishYear);
        this.numOfFollow = numOfFollow;
        this.numOfFollower = numOfFollower;
        this.numOfPosts = numOfPosts;
        this.postList = temp;
    }

    public int getNumOfPosts() {
        return numOfPosts;
    }

    
    @Override
    public String toString() {
        return "\nInstagramAccount" +super.toString()+ "\nNumber Of Follow=" + numOfFollow + "\nNumber Of Follower=" 
                + numOfFollower + "\nNumber Of Posts=" + numOfPosts + "\nPosts" + postList;
    }
    
    
    
}
