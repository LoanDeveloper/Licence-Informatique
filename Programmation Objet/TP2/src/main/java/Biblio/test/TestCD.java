package Biblio.test;
import Biblio.src.*;

public class TestCD {
    public static void main(String[] args) {
        Class classeCD = CD.class;
        // Detection d'attributs non privés dans la classe Personne...
        int nbMethodes = classeCD.getFields().length;
        if (nbMethodes != 0) {
            throw new Error("Probleme : la classe CD contient des attributs publics !...");
        }

        // Verification des accesseurs devant etre presents dans CD
        try {
            classeCD.getDeclaredMethod("donneArtiste", (Class[]) null);
            classeCD.getDeclaredMethod("donneNbPistes", (Class[]) null);
            classeCD.getDeclaredMethod("toString", (Class[]) null);
        } catch (NoSuchMethodException nse) {
            throw new Error("Probleme : la classe CD n'a pas de méthode " + nse.getMessage());
        }
        // Verification des accesseurs devant etre presents dans EltMM
        try {
            classeCD.getDeclaredMethod("donneTitre", (Class[]) null);
            throw new Error("Probleme : la classe CD ne doit pas contenir donneTitre " +
                    "(cette methode doit etre presente dans la classe EltMM)");
        } catch (NoSuchMethodException nse) {
        }
        try {
            classeCD.getDeclaredMethod("donneDuree", (Class[]) null);
            throw new Error("Probleme : la classe CD ne doit pas contenir donneDuree " +
                    "(cette methode doit etre presente dans la classe EltMM)");
        } catch (NoSuchMethodException nse) {
        }
        try {
            classeCD.getDeclaredMethod("donneCommentaires", (Class[]) null);
            throw new Error("Probleme : la classe CD ne doit pas contenir donneCommentaires " +
                    "(cette methode doit etre presente dans la classe EltMM)");
        } catch (NoSuchMethodException nse) {
        }
        System.out.println("Classe CD OK...");
    }
}
