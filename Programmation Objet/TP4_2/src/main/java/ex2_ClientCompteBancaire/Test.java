package ex2_ClientCompteBancaire;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author loant
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client c1 = new Client("thomy","loan");
        
        CompteBancaireInitial comptes[] = {
            new CompteBancaireInitial(100,1,c1),
            new CompteBancaireInitial(20,2,c1)
        };

        Arrays.sort(comptes);
        
        for (CompteBancaireInitial c : comptes){
            System.out.println(c);
        }
    }
    
}
