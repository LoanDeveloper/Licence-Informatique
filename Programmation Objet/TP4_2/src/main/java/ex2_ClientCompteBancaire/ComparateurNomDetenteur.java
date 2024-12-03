package ex2_ClientCompteBancaire;

import java.util.Comparator;

/**
 *
 * @author loant
 */
public class ComparateurNomDetenteur implements Comparator<CompteBancaireInitial>{

    @Override
    public int compare(CompteBancaireInitial o1, CompteBancaireInitial o2) {
        return o1.donneDetenteur().donneNom().compareTo(o2.donneDetenteur().donneNom());
    }
    
}
