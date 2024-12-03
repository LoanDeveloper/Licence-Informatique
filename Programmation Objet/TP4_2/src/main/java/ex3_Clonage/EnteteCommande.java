package ex3_Clonage;

public class EnteteCommande {
    // nom du client qui a passe la commande
    private StringBuffer nomClient;
    // numero de la commande
    private int numeroCommande;

    public EnteteCommande(String nomClient, int numero) {
        this.nomClient = new StringBuffer(nomClient);
        this.numeroCommande = numero;
    }

    public StringBuffer donneNomClient() {
        return this.nomClient;
    }

    public void changeNomClient(String nomClient) {
        this.nomClient.replace(0,this.nomClient.length(),nomClient);
       }

    public int donneNumeroCommande() {
        return this.numeroCommande;
    }

    public void changeNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public String toString() {
        return ("numero = " + this.numeroCommande
                + " effectu'ee par : " + this.nomClient);
    }
}
