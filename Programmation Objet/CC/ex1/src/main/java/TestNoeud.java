import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestNoeud {
    public static void main(String[] args) {

        Class classeNoeud = Noeud.class;
        // Verification que la classe Noeud est bien abstraite...
        if (!(Modifier.isAbstract(classeNoeud.getModifiers()))) {
            throw new Error("Probleme : la classe Noeud est concrete !...");
        }

        // Detection d'attributs publics
        for (Field attribut : classeNoeud.getDeclaredFields()) {
            if (! Modifier.isPrivate(attribut.getModifiers()) &&
                ! Modifier.isProtected(attribut.getModifiers())) {
                throw new Error("Probleme avec TestNoeud : l'attribut " + attribut + " de "
                        + classeNoeud + " doit etre d'eclar'e private ou protected");
            }
        }

        // Verification des methodes devant etre presentes dans Noeud
        try {
            classeNoeud.getMethod("ajouteElt", Noeud.class);
            classeNoeud.getMethod("supprimeElt", Noeud.class);
            classeNoeud.getMethod("donneElementsFils", (Class<?>[]) null);
            classeNoeud.getMethod("donneNom", (Class<?>[]) null);
        } catch (NoSuchMethodException nse) {
            throw new Error("Probleme avec TestNoeud : la classe Noeud n'a pas de m'ethode " + nse.getMessage());
        }

        System.out.println("Classe Noeud OK...");
    }
}
