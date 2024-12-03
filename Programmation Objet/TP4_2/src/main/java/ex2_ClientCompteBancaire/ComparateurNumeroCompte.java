package ex2_ClientCompteBancaire;

import java.util.Comparator;

/**
 *
 * @author loant
 */
public class ComparateurNumeroCompte implements Comparator<CompteBancaireInitial>{

    @Override
    public int compare(CompteBancaireInitial o1, CompteBancaireInitial o2) {
        if(o1.donneNumero() < o2.donneNumero()){
            return -1;
        } else if(o1.donneNumero() == o2.donneNumero()){
            return 0;
        } else{
            return 1;
        }
    }

  
}
