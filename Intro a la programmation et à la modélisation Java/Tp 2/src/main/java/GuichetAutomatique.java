public class GuichetAutomatique {
    /**
     * Reserve du Guichet
     */
    public Double reserve = 0.0;
    
    /**
     * Méthode virement
     */
    public void virement(Compte debit, Compte credit, Double montant){
        debit.retrait(montant);
        credit.depot(montant);
    }
    
    public void virement(Utilisateur debit, Utilisateur credit, Double montant){
        debit.getCourant().retrait(montant);
        credit.getCourant().depot(montant);
    }
    
    public void virement(Utilisateur p, Double montant){
        p.getEpargne().retrait(montant);
        p.getCourant().depot(montant);
    }
    
    public void virementEpargne(Utilisateur p, Double montant){
        p.getCourant().retrait(montant);
        p.getEpargne().depot(montant);
    }
    
    /**
     * Méthode retrait.
     */
    
    public void retrait(Compte c, Utilisateur p, Double montant){
        c.retrait(montant);
        p.empoche(montant);
        this.reserve = this.reserve - montant;
    }
    
    public void retrait(Utilisateur p, Double montant){
        p.getCourant().retrait(montant);
        p.empoche(montant);
        this.reserve = this.reserve - montant;
    }
    
    /**
     * Méthode dépot.
     */
    
    public void depot(Compte c, Utilisateur p, Double montant){
        c.depot(montant);
        p.depense(montant);
        this.reserve = this.reserve + montant;
    }
    
    public void depot(Utilisateur p, Double montant){
        p.depense(montant);
        p.getCourant().depot(montant);
        this.reserve = this.reserve + montant;
    }
}