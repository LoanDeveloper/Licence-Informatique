package Composants;

/**
 *
 * @author loant
 */
public class DisqueDur extends Composant{
    private int consommation;
    private int capacite;

    public DisqueDur(int consommation, int capacite, int id, double prix) {
        super(id, prix);
        this.consommation = consommation;
        this.capacite = capacite;
    }

    @Override
    public boolean donneEnergie() {
        return false;
    }
    
    
}
