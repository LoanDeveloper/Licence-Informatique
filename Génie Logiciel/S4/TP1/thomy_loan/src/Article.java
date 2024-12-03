package tp1;

/**
 *
 * @author loant
 */
public abstract class Article {
    protected String nom;
    protected int id;
    protected int prix;
    protected int stock;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

class Jardinage extends Article{
    private String saison;

    public Jardinage(String nom, int id, int prix, int stock, String saison) {
        this.nom = nom;
        this.id = id;
        this.prix = prix;
        this.stock = stock;
        this.saison = saison;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }
}