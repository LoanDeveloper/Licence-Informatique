import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFichier {
    public static void main(String[] args) {
        Class classeFichier = Fichier.class;
        Class classeNoeud = Noeud.class;
        // verification du type
        if (! classeNoeud.isAssignableFrom(classeFichier)) {
            throw new Error("Probleme avec TestFichier : une instance de la classe Fichier doit avoir le type Noeud");
        }
        // Detection d'attributs non privés dans la classe Fichier...
        int attributs = classeFichier.getFields().length;
        if (attributs != 0) {
            throw new Error("Probleme avec TestFichier : la classe Fichier contient des attributs publics !...");
        }

        // creation d'un fichier
        Fichier fic1 = new Fichier("fic1");

        // test de l'acces au nom
        if (! fic1.donneNom().equals("fic1")) {
            throw new Error("Probleme avec TestFichier : pas d'acces au nom du fichier fic1");
        }

        // @TODO verification de l'egalite
       /* Fichier fic1bis = new Fichier("fic1");

        List<Noeud> clients = new ArrayList<>();
        clients.add(fic1);

        if (! clients.contains(fic1bis)) {
            throw new Error("Probleme avec TestFichier : le fichier fic1bis n'a pas e'te' trouv'e.");
        }*/

        // test de l'ajout (normalement impossible)
        try {
            fic1.ajouteElt(new Fichier("fic2"));
            // normalement on ne doit pas passer ici...
            throw new Error("Probleme avec TestFichier : l'exception UnsupportedOperationException doit etre lanc'ee");
        } catch (UnsupportedOperationException uoe) {
            // OK si on passe ici...
        }

        // test des elements fils
        ArrayList<Noeud> liste = fic1.donneElementsFils();
        // un fichier n'a pas de fils
        if (! liste.isEmpty()) {
            throw new Error("Probleme avec TestFichier : liste non vide");
        }

        System.out.println("Classe Fichier OK...");
    }
}
