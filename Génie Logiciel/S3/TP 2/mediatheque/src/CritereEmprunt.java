public class CritereEmprunt implements Client {
    private int nbDocumentsEmpruntable;
    private String duréePrêt;
    private Tarifs tarifs;

    public CritereEmprunt(int nbDocumentsEmpruntable, String duréePrêt, Tarifs tarifs) {
        this.nbDocumentsEmpruntable = nbDocumentsEmpruntable;
        this.duréePrêt = duréePrêt;
        this.tarifs = tarifs;
    }
}
