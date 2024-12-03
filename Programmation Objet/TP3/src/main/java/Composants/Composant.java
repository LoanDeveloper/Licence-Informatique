package Composants;

/**
 *
 * @author loant
 */
public abstract class Composant {
    private int id;
    private double prix;

    public Composant(int id, double prix) {
        this.id = id;
        this.prix = prix;
    }
    
    public abstract boolean donneEnergie();
}
