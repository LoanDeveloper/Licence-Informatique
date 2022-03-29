package tp5;

import java.util.ArrayList;

import static java.lang.System.*;

public class App {

    public static void main(String[] args) {
        LigneDeCommande l1 = new LigneDeCommande(1,"Pizza saumon",2,10.5);
        LigneDeCommande l2 = new LigneDeCommande(1,"Pizza 4 fromages",1,9.50);
        LigneDeCommande l3 = new LigneDeCommande(2,"Pizza chorizo",1,11.50);

        ArrayList<LigneDeCommande> array = new ArrayList<LigneDeCommande>();
        array.add(l1);
        array.add(l2);

        for (LigneDeCommande l : array){
            System.out.println(l);
        }

        System.out.println("-----------------------------------");
        System.out.println(l1);

        TraitementCommande tc = new TraitementCommande();
        System.out.println("-----------------------------------");
        tc.afficherCommandes();
    }
}
