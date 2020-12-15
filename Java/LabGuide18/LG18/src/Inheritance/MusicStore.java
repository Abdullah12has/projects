/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inheritance;

import java.io.Serializable;

/**
 *
 * @author Burcu
 */
public class MusicStore implements Comparable<MusicStore>, Serializable {

    private int id;
    private String storeName;
    private String soldProductType;
    private String storeAddress;

    public MusicStore(int id, String storeName, String soldProductType, String storeAddress) {
        this.id = id;
        this.storeName = storeName;
        this.soldProductType = soldProductType;
        this.storeAddress = storeAddress;
    }

    public int getId() {
        return id;
    }


    public String getSoldProductType() {
        return soldProductType;
    }

    @Override
    public String toString() {
        return "\nMusicStore\n"
                + "\nId= " + id
                + "\nSold Product Type= " + soldProductType
                + "\nStore Name= " + storeName
                + "\nSore Address= " + storeAddress;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MusicStore other = (MusicStore) obj;
        if (this.id != other.id) {
            return false;
        }

        return true;
    }

    @Override
    public int compareTo(MusicStore t) {
        return id - t.getId();

    }

}
