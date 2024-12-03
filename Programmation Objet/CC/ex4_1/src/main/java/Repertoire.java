
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
        nouveau.parent = this;
        return true;
    }

    @Override
    public boolean supprimeElt(Noeud existant) {
        if (this.elements.contains(existant)){
            this.elements.remove(existant);
            existant.parent = null;
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
    
    public int donneTaille(){
        int taille = 0;
        for (Noeud n : this.elements){
            taille+=n.donneTaille();
        }
        return taille;
    }

    static ArrayList<Noeud> result = new ArrayList<>();
    @Override
    public ArrayList<Noeud> rechercheElt(String nom) {
        if (this.donneNom().equals(nom)){
            result.add(this);
        }
        for (Noeud n : this.elements){
            if (n instanceof Fichier && !n.rechercheElt(nom).isEmpty()){
                result.add(n.rechercheElt(nom).get(0));
            }else{
                return n.rechercheElt(nom);
            }
        }
        return result;
    }
}
