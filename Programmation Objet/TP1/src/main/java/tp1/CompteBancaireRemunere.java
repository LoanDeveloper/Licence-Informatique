package tp1;

/**
 *
 * @author loant
 */
public class CompteBancaireRemunere extends CompteBancaire{
    
    private static double interetParDefaut = 3;
    private double tauxInteret;
    
    public CompteBancaireRemunere(double soldeInitial, double tauxInteret, Client client) {
        super(soldeInitial, client);
        this.tauxInteret = tauxInteret;
    }

    public CompteBancaireRemunere(int numero, Client client) {
        super(numero, client);
        this.tauxInteret = interetParDefaut;
        this.solde = 0;
    }

    public CompteBancaireRemunere(int numero, double soldeInitial, Client client) {
        super(numero, client);
        this.tauxInteret = interetParDefaut;
        this.solde = soldeInitial;
    }
    
    public CompteBancaireRemunere(int numero, double soldeInitial, double tauxInteret, Client c){
        super(numero, soldeInitial, c);
        this.tauxInteret = tauxInteret;
    }
    
    public void crediterInteretMensuel(){
        this.solde += this.solde * ((this.tauxInteret / 100) / 12);
    }

    @Override
    public String toString() {
        return "CompteBancaireRemunere{" + "tauxInteret=" + tauxInteret + '}';
    }
    
    
}
