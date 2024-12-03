package Biblio.test;
import Biblio.src.*;

public class TestEltMM {
    public static void main(String[] args) {
        Class classeEltMM = EltMM.class;
        // Detection d'attributs non privés dans la classe EltMM...
        int nbMethodes = classeEltMM.getFields().length;
        if (nbMethodes != 0) {
            throw new Error("Probleme : la classe EltMM contient des attributs publics !...");
        }

        // Verification des accesseurs devant etre presents dans EltMM
        try {
            classeEltMM.getDeclaredMethod("donneTitre", (Class[]) null);
            classeEltMM.getDeclaredMethod("donneDuree", (Class[]) null);
            classeEltMM.getDeclaredMethod("donneCommentaires", (Class[]) null);
            classeEltMM.getDeclaredMethod("toString", (Class[]) null);
        } catch (NoSuchMethodException nse) {
            throw new Error("Probleme : la classe EltMM n'a pas de méthode " + nse.getMessage());
        }
        System.out.println("Classe EltMM OK...");
    }
}
