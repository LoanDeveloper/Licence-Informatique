package licence.annee1.salaires;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author prodriguez
 */
public class App {
   
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // Déclaration d'un lecteur de fichiers
        LecteurFichier monLecteur;
        // Création du lecteur
	    monLecteur = new LecteurFichier() ;
        // Choix du fichier manipulé par le lecteur
	    monLecteur.choisirFichier("revenus.txt") ;

        ArrayList<Double> revenus; // Déclaration d'un arraylist pour récupérer les salaires.
	    revenus = monLecteur.lectureReels(); // Lecture des noms dans le fichier et stockage dans le tableau
	    // Vérification du nombre de revenus lus : 46.
        System.out.println("taille ArrayList revenus : " + revenus.size());
        
        ArrayList<String> resultats = new ArrayList<String>();
        String unResultat = "Premier résultat : " + 1.0;
        resultats.add(unResultat);
        System.out.println("ArrayList resultats : " + resultats);

        System.out.println("------------------------------------");

        CalculScientifiques c = new CalculScientifiques(revenus);
        System.out.println(c.Repartition(revenus,8));
    }
}