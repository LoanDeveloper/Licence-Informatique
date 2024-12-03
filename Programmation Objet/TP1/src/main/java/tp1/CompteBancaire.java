package tp1;

/**
 *
 * @author loant
 */
public class CompteBancaire {
    private int numero;
    protected double solde;
    private Client client;
    private static int cpt = 0;
    
    public CompteBancaire(double soldeInitial, Client client) {
        this.solde = soldeInitial;
        this.client = client;
        this.numero = cpt+1;
        cpt++;
    }

    public CompteBancaire(int numero, Client client) {
        this.numero = numero;
        this.client = client;
    }

    public CompteBancaire(int numero, double soldeInitial, Client client) {
        this.numero = numero;
        this.solde = soldeInitial;
        this.client = client;
    }
    
    public int donneNumero(){
        return this.numero;
    }
    
    public Client donneDetenteur(){
        return this.client;
    }
    
    public double crediter(double montant){
        this.solde += montant;
        return this.solde;
    }
    
    public double debiter(double montant){
        this.solde -= montant;
        return this.solde;
    }
    
    public double consulter(){
        return this.solde;
    }
    
    public boolean transferer(CompteBancaire unCompte, double montantATransferer){
        if ((this.solde - montantATransferer) < 0){
            return false;
        }else{
            unCompte.crediter(montantATransferer);
            this.debiter(montantATransferer);
            return true;
        }
    }

    @Override
    public String toString() {
        return "CompteBancaire{" + "numero=" + numero + ", solde=" + solde + ", client=" + client + '}';
    }
}
