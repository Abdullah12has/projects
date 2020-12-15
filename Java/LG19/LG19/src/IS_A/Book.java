/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IS_A;

import HAS_A.Author;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Burcu
 */
public class Book extends Document {

    private int totalPgNum;
    private Author author;

    public Book(int id, String name, double size, String extension, int totalPgNum, Author a) {
        super(id, name, size, extension);
        this.totalPgNum = totalPgNum;
        author = a;
    }

    @Override
    public void writeDataToFile() {
        File f = new File("documents.txt");
        PrintWriter pw = null;
        try {
            FileWriter fw = new FileWriter(f, true);
            pw = new PrintWriter(fw);

            String strWriteToFile = "Book " + getDocumentInfoToWrite() + " " + totalPgNum + "\n";

            strWriteToFile += author.getId() + " " + author.getName() + " " + author.getSurname() + "\n";

            pw.println(strWriteToFile.substring(0, strWriteToFile.length() - 1));
        } catch (IOException ex) {
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    @Override
    public String toString() {

        String res = "";

        res += "\nAuthor: \n" + author.toString();

        return super.toString() + "\nBook\n" + "Total Page= " + totalPgNum + res;
    }

    @Override
    public int compareTo(Document t) {
        return id - t.getId();
    }
}
