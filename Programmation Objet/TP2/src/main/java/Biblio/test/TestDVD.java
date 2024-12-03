package Biblio.test;
import Biblio.src.*;

public class TestDVD {
    public static void main(String[] args) {
        Class classDVD = DVD.class;
        // Detection d'attributs non privés dans la classe Personne...
        int nbMethodes = classDVD.getFields().length;
        if (nbMethodes != 0) {
            throw new Error("Probleme : la classe DVD contient des attributs publics !...");
        }

        // Verification des accesseurs devant etre presents dans CD
        try {
            classDVD.getDeclaredMethod("donneRealisateur", (Class[]) null);
            classDVD.getDeclaredMethod("toString", (Class[]) null);
        } catch (NoSuchMethodException nse) {
            throw new Error("Probleme : la classe CD n'a pas de méthode " + nse.getMessage());
        }
        // Verification des accesseurs devant etre presents dans EltMM
        try {
            classDVD.getDeclaredMethod("donneTitre", (Class[]) null);
            throw new Error("Probleme : la classe CD ne doit pas contenir donneTitre " +
                    "(cette methode doit etre presente dans la classe EltMM)");
        } catch (NoSuchMethodException nse) {
        }
        try {
            classDVD.getDeclaredMethod("donneDuree", (Class[]) null);
            throw new Error("Probleme : la classe CD ne doit pas contenir donneDuree " +
                    "(cette methode doit etre presente dans la classe EltMM)");
        } catch (NoSuchMethodException nse) {
        }
        try {
            classDVD.getDeclaredMethod("donneCommentaires", (Class[]) null);
            throw new Error("Probleme : la classe CD ne doit pas contenir donneCommentaires " +
                    "(cette methode doit etre presente dans la classe EltMM)");
        } catch (NoSuchMethodException nse) {
        }
        System.out.println("Classe DVD OK...");
    }
}
