
package Classes_Sort;

import IS_A.Document;
import java.util.Comparator;

public class DocumentNameComparator implements Comparator<Document> {

    @Override
    public int compare(Document t, Document t1) {
        return t.getName().compareTo(t1.getName());
    }

}
