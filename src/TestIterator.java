import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class TestIterator {
    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<>();
        test.add("Red");
        test.add("Green");
        Iterator <String> it = test.iterator();
        while(it.hasNext()){
            if (it.next().equals("Red")){
                it.remove();
            }
        }
        System.out.println(test.toString());
    }




 }
