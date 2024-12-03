import java.util.ArrayList;

public class TestRepertoire {
    public static void main(String[] args) {
        Class classeRepertoire = Repertoire.class;
        Class classeNoeud = Noeud.class;
        // verification du type
        if (! classeNoeud.isAssignableFrom(classeRepertoire)) {
            throw new Error("Probleme avec TestRepertoire : une instance de la classe Repertoire doit avoir le type Noeud");
        }
        // Detection d'attributs non privés dans la classe Repertoire...
        int attributs = classeRepertoire.getFields().length;
        if (attributs != 0) {
            throw new Error("Probleme avec TestRepertoire : la classe Repertoire contient des attributs publics !...");
        }

        // creation d'un Repertoire
        Repertoire rep1 = new Repertoire("rep1");

        // test de l'acces au nom
        if (! rep1.donneNom().equals("rep1")) {
            throw new Error("Probleme avec TestRepertoire : pas d'acces au nom du repertoire rep1");
        }

        // test de l'ajout
        Fichier fic1 = new Fichier("fic1");
        if (! rep1.ajouteElt(fic1)) {
            throw new Error("Probleme avec TestRepertoire : l'ajout d'un fichier au repertoire rep1 a echou'e");
        }

        // test des elements fils
        ArrayList<Noeud> liste = rep1.donneElementsFils();
        Fichier fic1bis = new Fichier("fic1");
        if (! liste.contains(fic1bis)) {
            throw new Error("Probleme avec TestRepertoire : element fils fic1 introuvable...");
        }

        // test de l'ajout d'un element existant...
        if (rep1.ajouteElt(fic1)) {
            throw new Error("Probleme avec TestRepertoire : l'ajout d'un fichier deja existant doit echouer");
        }
        if (rep1.ajouteElt(rep1)) {
            throw new Error("Probleme avec TestRepertoire : l'ajout d'un repertoire a lui meme doit echouer");
        }

        // test de la suppression d'un fils existant
        if (! rep1.supprimeElt(fic1)) {
            throw new Error("Probleme avec TestRepertoire : la suppression du fichier fic1 a echou'e");
        }
        liste = rep1.donneElementsFils();
        if (liste.contains(fic1bis)) {
            throw new Error("Probleme avec TestRepertoire : le repertoire rep1 devrait etre vide...");
        }

        // test de la suppression d'un fils inexistant
        if (rep1.supprimeElt(new Fichier("inconnu"))) {
            throw new Error("Probleme avec TestRepertoire : la suppression d'un fichier inexistant a r'eussi");
        }

        System.out.println("Classe Repertoire OK...");
    }
}
