package Composants;

/**
 *
 * @author loant
 */
public class Alimentation extends Composant{
    private int puissance;

    public Alimentation(int puissance, int id, double prix) {
        super(id, prix);
        this.puissance = puissance;
    }

    @Override
    public boolean donneEnergie() {
        return true;
    }
    
    
}
