package decorateur;

/**
 *
 * @author loant
 */
public class DecorateurIHMChoixUtilisateur extends DecorateurIHM{

    public DecorateurIHMChoixUtilisateur(AbstractionIHM abstraction) {
        super(abstraction);
    }
    
    @Override
    public void afficherMenu(){
        System.out.println("1 - Interface administrateur");
        System.out.println("2 - Interface gestionnaire de stock");
        System.out.println("3 - Interface vendeur");
    }
}
