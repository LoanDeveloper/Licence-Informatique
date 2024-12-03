import java.util.ArrayList;

public class TestRecherche {
    public static void main(String[] args) {
        Repertoire racine = new Repertoire("racine");
        Repertoire rep1 = new Repertoire("rep1");
        Repertoire rep3 = new Repertoire("rep3");
        rep1.ajouteElt(rep3);
        racine.ajouteElt(rep1);

        // test de la recherche d'un element ayant le nom 'rep3'
        // et se situant a un niveau quelconque du systeme de fichiers
        ArrayList<Noeud> recherche = racine.rechercheElt("rep3");
        // construction du resultat attendu
        ArrayList<Noeud> resultatRecherche = new ArrayList<>();
        resultatRecherche.add(rep3);
        if (!recherche.equals(resultatRecherche))
            throw new Error("Probleme avec TestRecherche : le fichier rep3 n'a pas ete trouv'e");

        // test de la recherche d'elements ayant le nom 'test'
        // et se situant a un niveau quelconque du systeme de fichiers

        // creation d'un repertoire et d'un ficher de meme nom
        Repertoire testRep = new Repertoire("test");
        Fichier testFic = new Fichier("test", 75);
        if (!rep3.ajouteElt(testRep))
            throw new Error("ajout element " + testRep + " impossible");
        if (!rep1.ajouteElt(testFic))
            throw new Error("ajout element " + testFic + " impossible");

        recherche = racine.rechercheElt("test");
        // construction du resultat attendu
        resultatRecherche.clear();
        resultatRecherche.add(testFic);
        resultatRecherche.add(testRep);
        // pour eviter qu'il y ait des problemes d'ordre dans le resultat
        if (!recherche.containsAll(resultatRecherche) ||
                !resultatRecherche.containsAll(recherche))
            throw new Error("Probleme avec TestRecherche : resultat incorrect de la recherche avec 'test'");

        System.out.println("TestRecherche OK...");
    }
}
