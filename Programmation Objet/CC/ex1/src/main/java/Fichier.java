
import java.util.ArrayList;

/**
 *
 * @author loant
 */
public class Fichier extends Noeud{

    public Fichier(String nom) {
        this.nom = nom;
    }
    
    @Override
    public boolean ajouteElt(Noeud nouveau) {
        throw new UnsupportedOperationException("Il n'est pas possible d'ajouter un élément.");
    }

    @Override
    public boolean supprimeElt(Noeud existant) {
        throw new UnsupportedOperationException("Il n'est pas possible de supprimer un élélment.");
    }

    @Override
    public ArrayList<Noeud> donneElementsFils() {
        return new ArrayList<Noeud>();
    }

    @Override
    public String donneNom() {
        return this.nom;
    }
    
}
