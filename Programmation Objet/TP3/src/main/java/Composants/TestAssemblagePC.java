package Composants;

/**
 *
 * @author loant
 */
public class TestAssemblagePC {
    
    public static void main(String[] args){
        PC pc = new PC();
        
        Ram ram = new Ram(200,200,1,12);
        DisqueDur disque = new DisqueDur(200,1000,2,50);
        Processeur processeur = new Processeur(200,200,"socket",3,250);
        Alimentation alimentation = new Alimentation(1000,4,100);
        
        pc.ajoutComposant(ram);
        pc.ajoutComposant(disque);
        pc.ajoutComposant(processeur);
        pc.ajoutComposant(alimentation);
        
        System.out.println("Tests OK");
    }
}
