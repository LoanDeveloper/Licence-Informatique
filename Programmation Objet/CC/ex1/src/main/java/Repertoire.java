
import java.util.ArrayList;

/**
 *
 * @author loant
 */
public class Repertoire extends Noeud{
    private ArrayList<Noeud> elements;
            
    public Repertoire(String nom) {
        this.nom = nom;
        elements = new ArrayList<>();
    }
    
    @Override
    public boolean ajouteElt(Noeud nouveau) {
        for (Noeud n : this.elements){
            if (this.donneNom().equals(n.donneNom()) || this.elements.contains(nouveau)){ 
                return false;
            }
        }
        if (nouveau == this){
            return false;
        }
        this.elements.add(nouveau);
        return true;
    }

    @Override
    public boolean supprimeElt(Noeud existant) {
        if (this.elements.contains(existant)){
            this.elements.remove(existant);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Noeud> donneElementsFils() {
        return this.elements;
    }
    
    @Override
    public String donneNom() {
        return this.nom;
    }
}
