/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IS_A;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Burcu
 */
public class CD extends Document {

    private String genre;

    public CD(int id, String name, double size, String extension, String genre) {
        super(id, name, size, extension);
        this.genre = genre;
    }

    @Override
    public void writeDataToFile() {
        File f = new File("documents.txt");
        PrintWriter pw = null;
        try {
            FileWriter fw = new FileWriter(f, true);
            pw = new PrintWriter(fw);

            String strWriteToFile = "CD " + getDocumentInfoToWrite() + " " + genre+"\n";
            pw.println(strWriteToFile);
        } catch (IOException ex) {
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    @Override
    public String toString() {

        return super.toString() + "\nDomestic\n"
                + "Genre= " + genre;
    }

    @Override
    public int compareTo(Document t) {
        return id - t.getId();

    }
}
