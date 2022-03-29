public class Compte {
    /**
     * Numero de compte.
     */
    private Integer numero;
    
    /**
     * Utilisateur principal.
     */
    private Utilisateur principal;
    /**
     * Utilisateur secondaire.
     */
    private Utilisateur secondaire;
    /**
     * Solde du compte.
     */
    private Double montant;
    
    /**
     * Constructeur minimal.
     */
    public Compte(Integer numero){
        this.numero = numero;
        this.montant = 0.0;
    }
    /**
     * Constructeur.
     */
    public Compte(Integer numero,Double montant,Utilisateur principal){
        this.numero = numero;
        this.montant = montant;
        this.principal = principal;
    }
    
    /**
     * Accesseurs.
     */
    public Integer getNumero(){
        return this.numero;
    }
    
    public Utilisateur getPrincipal(){
        return this.principal;
    }
    
    public Utilisateur getSecondaire(){
        return this.secondaire;
    }
    
    public Double consulte(){
        return this.montant;
    }
    
    /**
     * Mutateurs.
     */
    public void setPrincipal(Utilisateur principal){
        this.principal = principal;
    }
    
    public void setSecondaire(Utilisateur secondaire){
        this.secondaire = secondaire;
    }
    
    /**
     * Mutateurs du solde.
     * @param somme 
     */
    public void depot(Double somme){
        this.montant = this.montant + somme;
    }
    
    public void retrait(Double retrait){
        this.montant = this.montant - retrait;
    }
    
    /**
     * toString.
     * @return 
     */
    public String toString(){
        return this.numero + " " + this.montant;
    }
    
}
