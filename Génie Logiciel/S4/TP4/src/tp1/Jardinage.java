package tp1;

/**
 *
 * @author loant
 */
public class Jardinage extends Article{
    private String saison;

    public Jardinage(String nom, String id, int prix, int stock, String saison) {
        this.nom = nom;
        this.id = id;
        this.prix = prix;
        this.stock = stock;
        this.saison = saison;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }
}
