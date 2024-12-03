package tp1;

import java.util.ArrayList;

/**
 *
 * @author loant
 */
public class Banque {
    private String nomBanque;
    private ArrayList<CompteBancaire> comptes;
    private ArrayList<Client> clients;
    private int coutTransfert = 5;
    
    
    public Banque(String nomBanque) {
        this.nomBanque = nomBanque;
        this.comptes = new ArrayList<CompteBancaire>();
        this.clients = new ArrayList<Client>();
    }
    
    public Particulier creerParticulier(String nomParticulier, String prenom, String adresse){
        for (Client c : this.clients){
            if (c.donneNom().equals(nomParticulier)){
                return null;
            }
        }
        Particulier p = new Particulier(nomParticulier, prenom, adresse);
        this.clients.add(p);
        return p;
    }
     
    public Entreprise creerEntreprise(String nomEntreprise, int numSIRET, String adresse){
        for (Client c : this.clients){
            if (c.donneNom().equals(nomEntreprise)){
                return null;
            }
        }
        Entreprise e = new Entreprise(nomEntreprise, numSIRET, adresse);
        this.clients.add(e);
        return e;
    }
    
    public CompteBancaire creerCompteBancaire(double soldeInitial, String nomClient){
        for (Client c : this.clients){
            if (c.donneNom().equals(nomClient) && c.donneComptes().size() < 3){
                CompteBancaire compte_bancaire = new CompteBancaire(soldeInitial, c);
                this.comptes.add(compte_bancaire);
                c.ajouteCompte(compte_bancaire);
                return compte_bancaire;
            }
        }
        return null;
    }
    
    public CompteBancaireRemunere creerCompteRemunere(double soldeInitial, double tauxInteret, String nomClient){
        for (Client c : this.clients){
            if (c.donneNom().equals(nomClient)){
                CompteBancaireRemunere compte_bancaire = new CompteBancaireRemunere(soldeInitial, tauxInteret, c);
                this.comptes.add(compte_bancaire);
                c.ajouteCompte(compte_bancaire);
                return compte_bancaire;
            }
        }
        return null;
    }
    
    public ArrayList<CompteBancaire> rechercheCompte(String nomClient){
        ArrayList<CompteBancaire> result = new ArrayList<CompteBancaire>();
        for (CompteBancaire c : this.comptes){
            if (c.donneDetenteur().donneNom().equals(nomClient)){
                result.add(c);
            }
        }
        return result;
    }
    
    public CompteBancaire rechercheCompte(int numeroCpte){
        for (CompteBancaire c : this.comptes){
            if (c.donneNumero() == numeroCpte){
                return c;
            }
        }
        return null;
    }
    
    public boolean supprimerCompte(int numeroCpte){
        for (CompteBancaire c : this.comptes){
            if (c.donneNumero() == numeroCpte){
                this.comptes.remove(c);
                c.donneDetenteur().donneComptes().remove(c);
                return true;
            }
        }
        return false;
    }
    
    public Client rechercheClient(String nom){
        for (Client c : this.clients){
            if (c.donneNom().equals(nom)){
                return c;
            }
        }
        return null;
    }
    
    public boolean supprimerClient(String nomClient){
        for (Client c : this.clients){
            if (c.donneNom().equals(nomClient) && c.donneComptes().size() == 0){
                this.clients.remove(c);
                return true;
            }
        }
        return false;
    }
    
    public boolean transfertInterBancaire(int numeroCpteDebiteur, Banque banqueCrediteur, int numeroCpteCrediteur, double montant){
        CompteBancaire compte_debiteur = this.rechercheCompte(numeroCpteDebiteur);
        CompteBancaire compte_crediteur = banqueCrediteur.rechercheCompte(numeroCpteCrediteur);
        if (compte_debiteur != null && compte_crediteur != null){
            compte_debiteur.debiter(montant + this.coutTransfert);
            compte_crediteur.crediter(montant);
            return true;
        }
        return false;
    }
    
    public int getCoutTransfert(){
        return this.coutTransfert;
    }

    @Override
    public String toString() {
        return "Banque{" + "nomBanque=" + nomBanque + ", comptes=" + comptes + ", clients=" + clients + ", coutTransfert=" + coutTransfert + '}';
    }
}
