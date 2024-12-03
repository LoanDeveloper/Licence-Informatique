
import jdk.incubator.foreign.ResourceScope;

import java.util.ArrayList;

public class AppTestQS {
    public static void main(String[] args) {
        Liste l = new ListeCons(10);
        l = new ListeCons(33,l);
        l = new ListeCons(33,l);
        ArrayList T = l.listeEnTab();
        for (Object o : T) {
            System.out.println(o.toString());
        }
        System.out.println("---");
        T = l.QS().listeEnTab();
        for (Object o : T) {
            System.out.println(o.toString());
        }

    }
}
