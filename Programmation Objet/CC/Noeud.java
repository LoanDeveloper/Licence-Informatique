
import java.util.ArrayList;

/**
 *
 * @author loant
 */
public abstract class Noeud {
    protected String nom;
    protected Noeud parent = null;
    
    public abstract boolean ajouteElt(Noeud nouveau);
    public abstract boolean supprimeElt(Noeud existant);
    public abstract ArrayList<Noeud> donneElementsFils();
    public abstract String donneNom();

    @Override
    public String toString() {
        return "Noeud{" + "nom=" + nom + '}';
    }
    
    public abstract int donneTaille();
    public abstract ArrayList<Noeud> rechercheElt(String nom);
    
    public Noeud donneParent(){
        return this.parent;
    };
    
    static ArrayList<Noeud> chemin = new ArrayList<Noeud>();
    
    public ArrayList<Noeud> donneChemin() {
        if (!chemin.contains(this)){
            chemin.add(0,this);
        }
        if (this.parent == null){
            return chemin;
        }else{
            return parent.donneChemin();
        }
    }

    static ArrayList<Noeud> chemin2 = new ArrayList<Noeud>();
    public ArrayList<Noeud> donneChemin(Repertoire r) throws IllegalArgumentException{
        chemin2.add(0,this);
        if (this.equals(r)){
            return chemin2;
        }else if (this.parent != null){
            return parent.donneChemin(r);
        }else{
            throw new IllegalArgumentException();
        }
    }
    
}
