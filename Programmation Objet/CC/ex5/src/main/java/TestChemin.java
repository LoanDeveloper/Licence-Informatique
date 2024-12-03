import java.util.ArrayList;
import java.util.Collections;

public class TestChemin {
    public static void main(String[] args) {
        Repertoire racine = new Repertoire("racine");
        Repertoire rep1 = new Repertoire("rep1");
        Repertoire rep3 = new Repertoire("rep3");
        Fichier f2 = new Fichier("f2", 150);
        Fichier f3 = new Fichier("f3", 35);
        rep3.ajouteElt(f3);
        rep1.ajouteElt(rep3);
        racine.ajouteElt(rep1);
        racine.ajouteElt(f2);
        /*
                racine
              /        \
             rep1      f2
              |
             rep3
              |
             f3
         */

        // test d'un chemin absolu pour un fichier existant
        // le chemin absolu de f3 est : racine/rep1/rep3/f3
        ArrayList<Noeud> cheminF3absolu = f3.donneChemin();
        ArrayList<Noeud> resultatCheminf3 = new ArrayList<>();
        //System.out.println(f3.donneChemin());
        
        // ajout des elements a la liste representant le 'bon' resultat
        Collections.addAll(resultatCheminf3,racine,rep1,rep3,f3);
        if (! cheminF3absolu.equals(resultatCheminf3)) {
            System.err.println(cheminF3absolu);
            throw new Error("Probleme avec TestChemin : chemin absolu de " + f3 + " incorrect");
        }

        // test d'un chemin relatif pour un repertoire existant
        // le chemin relatif est : rep1/rep3
        ArrayList<Noeud> cheminRep3absolu = rep3.donneChemin(rep1);
        ArrayList<Noeud> resultatCheminRep3 = new ArrayList<>();
        Collections.addAll(resultatCheminRep3, rep1,rep3);
        System.out.println(resultatCheminRep3);
        if (! cheminRep3absolu.equals(resultatCheminRep3)) {
            System.err.println(cheminRep3absolu);
            throw new Error("Probleme avec TestChemin : chemin relatif de " + rep3 + " incorrect");
        }

        // test d'un chemin relatif pour un repertoire parent non present
        try {
            System.err.println(rep1.donneChemin(rep3)); // erreur volontaire car rep3.donneChemin(rep1) OK
            // une exception doit etre lanc'ee par donneChemin et on ne doit pas arriver a la ligne suivante
            throw new Error("Probleme avec TestChemin : le repertoire " + rep3 + " n'est pas un parent");
        } catch (IllegalArgumentException iae) {
            // OK
        }

        // test d'un chemin relatif d'un repertoire a lui-meme
        // le chemin relatif est : rep1
        ArrayList<Noeud> cheminRep1 = rep1.donneChemin(rep1);
        ArrayList<Noeud> resultatCheminRep1 = new ArrayList<>();
        Collections.addAll(resultatCheminRep1, rep1);
        
        if (! cheminRep1.equals(resultatCheminRep1)) {
            System.err.println(cheminRep1);
            throw new Error("Probleme avec TestChemin : le chemin relatif devrait contenir uniquement" + rep1);
        }

        System.out.println("TestChemin OK...");
    }
}
