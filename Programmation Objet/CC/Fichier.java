
import java.util.ArrayList;

/**
 *
 * @author loant
 */
public class Fichier extends Noeud{
    private int taille;
    
    public Fichier(String nom, int taille) {
        this.nom = nom;
        this.taille = taille;
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
    
    public int donneTaille(){
        return this.taille;
    }

    @Override
    public ArrayList<Noeud> rechercheElt(String nom) {
        ArrayList<Noeud> result = new ArrayList<>();
        if (this.donneNom().equals(nom)){
            result.add(this);
        }
        return result;
    }
    
}
