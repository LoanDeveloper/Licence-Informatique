package tp1;

/**
 *
 * @author loant
 */
public class Bricolage extends Article{
    private String rayon;
    private String electrique;
    
    public Bricolage(String nom, String id, int prix, int stock, String rayon, String electrique){
        this.nom = nom;
        this.id = id;
        this.prix = prix;
        this.stock = stock;
        this.rayon = rayon;
        this.electrique = electrique;
    }

    public String getRayon() {
        return rayon;
    }

    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    public String getElectrique() {
        return electrique;
    }
    
    public void setElectrique(String electrique) {
        this.electrique = electrique;
    }
}