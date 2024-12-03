package tp1;

import java.util.ArrayList;

/**
 *
 * @author loant
 */
public class Client {
    private String nom;
    private String adresse;
    private ArrayList<CompteBancaire> comptes;
    
    public Client(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        comptes = new ArrayList<CompteBancaire>();
    }
    
    public String donneNom(){
        return this.nom;
    }
    
    public String donneAdresse(){
        return this.adresse;
    }
    
    public void changeAdresse(String adresse){
        this.adresse = adresse;
    }
    
    public boolean ajouteCompte(CompteBancaire compte){
        if (!this.comptes.contains(compte)){
            this.comptes.add(compte);
            return true;
        }
        return false;
    }
    
    public boolean supprimeCompte(int numCompte){
        for (CompteBancaire c : this.comptes){
            if (c.donneNumero() == numCompte){
                this.comptes.remove(c);
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<CompteBancaire> donneComptes(){
        return this.comptes;
    }

    @Override
    public String toString() {
        return "Client{" + "nom=" + nom + ", adresse=" + adresse + ", comptes=" + comptes + '}';
    }
    
    
}
