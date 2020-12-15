package shoppingmallmain;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingMall 
{
    protected String id;
    protected String name;
    protected String address;
    protected int numOfPark;
    protected double closedHour;
    protected ArrayList<String> shops = new ArrayList<>();

    public ShoppingMall() {
    }

    
   public ShoppingMall(String id, String name, String address,int park, double closedHour,ArrayList<String> arr) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.numOfPark = park;
        this.closedHour = closedHour;
        this.shops = arr;
    }
  
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getClosedHour() {
        return closedHour;
    }

    public void setClosedHour(double closedHour) {
        this.closedHour = closedHour;
    }

    public int getNumOfPark() {
        return numOfPark;
    }

    public void setNumOfPark(int numOfPark) {
        this.numOfPark = numOfPark;
    }

    
    public ArrayList<String> getShops() {
        return shops;
    }

    public void setShops(ArrayList<String> shops) {
        this.shops = shops;
    }

   
    
    @Override
    public String toString() {
        return "\nId=" + id + "\nName=" + name + "\nAddress=" + address + "\nNumber Of Park=" + numOfPark + "\nClosedHour=" + closedHour + "\nShops=" + shops ;
    }
    
  
    
}
