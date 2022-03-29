public class Utilisateur {
    /**
     * Nom de l'utilisateur.
     */
    private final String nom;
    
    /**
     * Compte courant de l'utilisateur.
     */
    
    private Compte courant;
    
    /**
     * Compte épargne de l'utilisateur.
     */
    
    private Compte epargne;
    
    /**
     * Portefeuille de l'utilisateur.
     */
    
    private Double portefeuille;
    
    /**
     * Constructeur.
     */
    
    public Utilisateur(String nom){
        this.nom = nom;
        this.portefeuille = 0.0;
    }
    
    /**
     * toString
     */
    public String toString(){
        return this.nom + " " + this.portefeuille + " " + this.courant.toString() + " " + this.epargne.toString();
    }
    
    /**
     * Mutateurs des comptes Courant et Epargnes.
     */
    
    public void setCompteCourantPrincipal(Compte c){
        this.courant = c;
        this.courant.setPrincipal(this);
    }
    
    public void setCompteCourantSecondaire(Compte c){
        this.courant = c;
        this.courant.setSecondaire(this);
    }
    
    public void setCompteEpargnePrincipal(Compte c){
        this.epargne = c;
        this.epargne.setPrincipal(this);
    }
    
    public void setCompteEpargneSecondaire(Compte c){
        this.epargne = c;
        this.epargne.setSecondaire(this);
    }
    /**
     * Accesseurs.
     */
    
    public Compte getCourant(){
        return this.courant;
    }
    
    public Compte getEpargne(){
        return this.epargne;
    }
    
    /**
     * Méthodes pour le portefeuille.
     */
    
    public void depense(Double montant){
        this.portefeuille = this.portefeuille - montant;
    }
    
    public void empoche(Double montant){
        this.portefeuille = this.portefeuille + montant;
    }
}
