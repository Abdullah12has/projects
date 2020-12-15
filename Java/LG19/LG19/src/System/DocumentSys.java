/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import Classes_Sort.DocumentNameComparator;
import HAS_A.Author;
import IS_A.Book;
import IS_A.CD;
import IS_A.Document;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Burcu
 */
public class DocumentSys {

    private static Set<Document> documents = new HashSet();
    private static String DOCUMENT_FILENAME = "documents.txt";

    public static void readDocumentsFromFile() {
        File fileDocument = new File(DOCUMENT_FILENAME);
        Scanner inputDocument = null;
        String type, name, extention, aName, aSurname, gnre;
        int id, page, aId;
        double size;
        Author a;
        Book b;
        try {
            inputDocument = new Scanner(fileDocument);
            while (inputDocument.hasNext()) {
                type = inputDocument.next();
                id = inputDocument.nextInt();
                name = inputDocument.next();
                size = inputDocument.nextDouble();
                extention = inputDocument.next();

                if (type.equalsIgnoreCase("Book")) {
                    page = inputDocument.nextInt();
                    aId = inputDocument.nextInt();
                    aName = inputDocument.next();
                    aSurname = inputDocument.next();
                    a = new Author(aId, aName, aSurname);
                    b = new Book(id, name, size, extention, page, a);

                    documents.add(b);
                } else {
                    gnre = inputDocument.next();
                    CD c = new CD(id, name, size, extention, gnre);
                    documents.add(c);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (inputDocument != null) {
                inputDocument.close();
            }
        }
    }

    public static boolean addBook(int id, String name, double size, String extension,
            int pagenum, int authorİd, String Aname, String Asurname) {
        for (Document d : documents) {
            if (d.getId() == id) {
                return false;
            }
        }
        Author c = new Author(authorİd, Aname, Asurname);
        Book b = new Book(id, name, size, extension, pagenum, c);

        b.writeDataToFile();
        return documents.add(b);
    }

    public static boolean addCD(int id, String name, double size, String extension, String genre) {
        for (Document d : documents) {
            if (d.getId() == id) {
                return false;
            }
        }
        CD cd = new CD(id, name, size, extension, genre);
        cd.writeDataToFile();
        return documents.add(cd);
    }

    public static void writeToBin() {
        ObjectOutputStream objo;
        try {
            objo = new ObjectOutputStream(new FileOutputStream("binary.bin"));
            objo.writeObject(documents);
            objo.close();
        } catch (FileNotFoundException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        } catch (IOException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();

        }
    }

    public static Document search(int id) {
        //With the iterator
        Iterator<Document> i = documents.iterator();
        while (i.hasNext()) {
            Document d = i.next();
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public static String[] getIds() {
        TreeSet<Document> ts = new TreeSet();
        ts.addAll(documents);
        String res[] = new String[ts.size()];
        int i = 0;
        for (Document d : ts) {
            res[i] = d.getId() + "";
            i++;
        }
        return res;
    }

    public static String displayByName() {
        TreeSet<Document> ts = new TreeSet(new DocumentNameComparator());
        ts.addAll(documents);
        String res = "";
        for (Document d : ts) {
            res += d.toString();
        }
        return res;

    }
}
