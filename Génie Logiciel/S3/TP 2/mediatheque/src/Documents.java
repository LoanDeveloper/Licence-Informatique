public class Documents {
    protected int code;
    protected String localisation;
    protected String titre;
    protected String auteur;
    protected int annéeSortie;
    protected boolean emprunt;

    public Documents(int code, String localisation, String titre, String auteur, int annéeSortie, boolean emprunt) {
        this.code = code;
        this.localisation = localisation;
        this.titre = titre;
        this.auteur = auteur;
        this.annéeSortie = annéeSortie;
        this.emprunt = emprunt;
    }
}
