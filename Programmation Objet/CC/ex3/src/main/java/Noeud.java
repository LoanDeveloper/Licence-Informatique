
import java.util.ArrayList;

/**
 *
 * @author loant
 */
public abstract class Noeud {
    protected String nom;
    
    
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
    
}
