import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        Liste l = new ListeCons(10);
        l = l.QS();
        //l.afficher();

        System.out.println("***");

        ArrayList<Integer> T = new ArrayList<>();
        l.listeEnTab(T);

        for (int i : T){
            System.out.print(i+" ");
        }

        System.out.println("***");

        QStore q = new QStore();
        q.exec();
    }
}
