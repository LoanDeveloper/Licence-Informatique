package tp1;

/**
 *
 * @author loant
 */
public class Animal extends Article{
    private String animal;
    private int poids;
    
    public Animal(String nom, String id, int prix, int stock, String animal, int poids){
        this.nom = nom;
        this.id = id;
        this.prix = prix;
        this.stock = stock;
        this.animal = animal;
        this.poids = poids;
    }
    
    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public int getPoids() {
        return poids;
    }
    
    public void setPoids(int poids) {
        this.poids = poids;
    }
}
