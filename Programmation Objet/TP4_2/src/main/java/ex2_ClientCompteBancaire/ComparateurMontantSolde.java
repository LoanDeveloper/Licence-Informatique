package ex2_ClientCompteBancaire;

import java.util.Comparator;

/**
 *
 * @author loant
 */
public class ComparateurMontantSolde implements Comparator<CompteBancaireInitial>{

    @Override
    public int compare(CompteBancaireInitial o1, CompteBancaireInitial o2) {
        if(o1.donneSolde() < o2.donneSolde()){
            return -1;
        } else if(o1.donneSolde() == o2.donneSolde()){
            return 0;
        } else{
            return 1;
        }
    }
    
}
