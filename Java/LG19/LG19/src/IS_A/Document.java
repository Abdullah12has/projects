/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IS_A;


import Interface.WriteInterface;
import java.io.Serializable;


/**
 *
 * @author Burcu
 */
public abstract class Document implements Comparable<Document>, Serializable, WriteInterface {

    protected int id;
    protected String name;
    protected double size;
    protected String extension;

    public Document(int id, String name, double size, String extension) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.extension = extension;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocumentInfoToWrite() {
        return id + " " + name + " " + size + " " + extension;
    }

    @Override
    public String toString() {
        return "\n**************\nDocument\n" + "Id= " + id
                + "\nName= " + name
                + "\nSize= " + size
                + "\nExtension= " + extension;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Document other = (Document) obj;
        return true;
    }

    

}
