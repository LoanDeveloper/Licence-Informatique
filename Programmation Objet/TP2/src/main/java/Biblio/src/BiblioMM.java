package Biblio.src;
import java.util.ArrayList;

/**
 * La classe BiblioMM fournit un moyen de stocker des objets
 * CD et DVD. Une liste de tous les CD et DVD peut etre affichee
 * en mode texte.
 * 
 */
public class BiblioMM
{
    private ArrayList<EltMM> elts;

    /**
     * Construit une bibliotheque vide.
     */
    public BiblioMM()
    {
        this.elts = new ArrayList<EltMM>();
    }

    public void ajouter(EltMM unElt)
    {
        this.elts.add(unElt);
    }

    /**
     * Affiche une liste de tous les CD et DVD actuellement dans
     * la bibliotheque.
     */
    public void affiche()
    {
        for(EltMM elt : this.elts) {
            System.out.println(elt);   
        }

    }
    
    public ArrayList<EltMM> rechercherTitre(String titre){
        ArrayList<EltMM> array = new ArrayList<EltMM>();
        for (EltMM elt : this.elts){
            if (elt.donneTitre().equals(titre)){
                array.add(elt);
            }
        }
        return array;
    }
    
    public EltMM emprunterTitre(String titre){
        ArrayList<EltMM> elts = this.rechercherTitre(titre);
        if (!elts.isEmpty()){
            this.elts.remove(elts.get(0));
            elts.get(0).emprunter();
            return elts.get(0);
        }else{
            return null;
        } 
    }
    
    public boolean rendreTitre(EltMM elt){
        if (this.rechercherTitre(elt.donneTitre()).isEmpty()){
            this.elts.add(elt);
            elt.restituer();
            return true;
        }else{
            return false;
        }
    }
}
