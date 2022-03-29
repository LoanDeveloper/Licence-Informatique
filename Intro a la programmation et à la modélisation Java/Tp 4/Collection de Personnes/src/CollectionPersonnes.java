import java.io.IOException;
import java.util.ArrayList;

public class CollectionPersonnes {
    private ArrayList<Personne> groupe;
    
    public CollectionPersonnes() throws IOException {
        groupe = new ArrayList<Personne>();
        LecteurFichier lf = new LecteurFichier();
        lf.choisirFichier("desPersonnes.txt");
        groupe = lf.lecture();
    }
    
    public void afficher(){
        for (int i=0;i<groupe.size();i++){
          groupe.get(i).afficher();  
        }
    }
    
    public int effectifDeLAnnee(int annee){
        int cpt=0;
        for (Personne p : groupe){
            if (p.getAnneeNaiss()==annee){
                cpt +=1;
            }
        }return cpt;
    }
    
    public Personne laPlusProche(Personne p){
        int smax = 0;
        Personne proche = p;
        for (Personne pe : groupe){
            if (!p.equals(pe)){
                if (pe.matchScore(p)>smax){
                    smax=pe.matchScore(p);
                    proche = pe;
                }
            }
        }
        return proche;
    }
    
    public ArrayList lesPlusProches(Personne p){
        ArrayList<Personne> r = new ArrayList<Personne>();
        for (Personne pe : groupe){
            if (this.laPlusProche(p).matchScore(p) == p.matchScore(pe)){
                r.add(pe);
            }
        }return r;
    }
    
    public ArrayList personnesGroupe(String group){
        ArrayList<Personne> r = new ArrayList<Personne>();
        for (Personne pe : groupe){
            if (pe.getGroupe().equals(group)){
                r.add(pe);
            }
        }return r;
    }
}
