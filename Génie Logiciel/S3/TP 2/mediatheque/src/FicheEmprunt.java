public class FicheEmprunt {
    private Client clientEmprunteur;
    private String date_debut;
    private String date_limite;
    private Documents document;

    public FicheEmprunt(Client clientEmprunteur, String date_debut, String date_limite, Documents document) {
        this.clientEmprunteur = clientEmprunteur;
        this.date_debut = date_debut;
        this.date_limite = date_limite;
        this.document = document;
    }
}
