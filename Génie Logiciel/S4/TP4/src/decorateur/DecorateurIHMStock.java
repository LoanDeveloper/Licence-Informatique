package decorateur;

/**
 *
 * @author loant
 */
public class DecorateurIHMStock extends DecorateurIHM{

    public DecorateurIHMStock(AbstractionIHM abstraction) {
        super(abstraction);
    }
    
    @Override 
    public void afficherMenu(){
        System.out.println("1 - Afficher les produits du catalogue");
        System.out.println("2 - Calculer la valeur du stock");
        System.out.println("3 - Générer le catalogue au format HTML");
        System.out.println("4 - Retour au menu précedent");
    }
}
