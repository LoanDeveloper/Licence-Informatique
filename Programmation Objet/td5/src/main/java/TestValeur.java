/**
 *
 * @author loant
 */
public class TestValeur {

    public static void main(String[] args) {
        Valeur v = new Valeur(2);
        AfficherValeur a = new AfficherValeur();
        v.ajouter(a);
        v.incremente();
        
        v.supprimer(a);
        v.incremente();
    }
    
}
