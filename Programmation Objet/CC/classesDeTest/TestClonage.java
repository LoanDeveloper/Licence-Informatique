import java.util.ArrayList;

public class TestClonage {

    private static boolean verifieClonage(ArrayList<Noeud> l1, ArrayList<Noeud> l2) {
        int taille1 = l1.size();
        int taille2 = l2.size();
        if (taille1 != taille2) {
            return false;
        } else {
            for(int i=0; i < taille1; i++) {
                Noeud n1 = l1.get(i);
                Noeud n2 = l2.get(i);
                // ce ne doit pas etre les memes objets mais ils doivent egaux...
                if (n1 == n2 || !n1.equals(n2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Repertoire racine = new Repertoire("racine");
        Repertoire rep1 = new Repertoire("rep1");
        Repertoire rep3 = new Repertoire("rep3");
        rep1.ajouteElt(rep3);
        racine.ajouteElt(rep1);
        Fichier f1 = new Fichier("f1", 100);
        racine.ajouteElt(f1);

        // test le clonage d'un systeme de fichiers
        Repertoire racineClonee = (Repertoire) racine.clone();
        // recuperation des deux arborescences
        ArrayList<Noeud> fils = racine.donneElementsFils();
        ArrayList<Noeud> filsClone = racineClonee.donneElementsFils();
        if (!verifieClonage(fils,filsClone)) {
            throw new Error("Probleme avec TestClonage : mauvaise gestion du clonage");
        }

        System.out.println("TestClonage OK...");
    }
}
