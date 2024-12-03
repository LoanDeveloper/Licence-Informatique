package Composants;

/**
 *
 * @author loant
 */
public class Ram extends Composant{
    private int frequence;
    private int consommation;

    public Ram(int frequence, int consommation, int id, double prix) {
        super(id, prix);
        this.frequence = frequence;
        this.consommation = consommation;
    }

    @Override
    public boolean donneEnergie() {
        return false;
    }
    
    
}
