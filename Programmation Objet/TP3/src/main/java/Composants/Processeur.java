package Composants;

/**
 *
 * @author loant
 */
public class Processeur extends Composant{
    private int consommation;
    private int frequence;
    private String typeConnecteur;

    public Processeur(int consommation, int frequence, String typeConnecteur, int id, double prix) {
        super(id, prix);
        this.consommation = consommation;
        this.frequence = frequence;
        this.typeConnecteur = typeConnecteur;
    }

    @Override
    public boolean donneEnergie() {
        return false;
    }
    
    
}
