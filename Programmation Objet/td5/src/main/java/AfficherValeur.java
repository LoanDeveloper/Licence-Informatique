/**
 *
 * @author loant
 */
public class AfficherValeur extends Observateur{

    @Override
    public void miseAJour(Sujet s) {
        System.out.println("Nouvelle Valeur = " + ((Valeur)s).donneValeur());
    }
   
    
}
