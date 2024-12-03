
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author loant
 */
public abstract class Sujet {
    private List<Observateur> listObs;
    
    protected Sujet(){
        this.listObs = new ArrayList<>();
    }
    
    public void ajouter(Observateur o){
        if (!this.listObs.contains(o)){
            this.listObs.add(o);
        }
    }
    
    public void supprimer(Observateur o){
        if (this.listObs.contains(o)){
            this.listObs.remove(o); //utilise equals qui vérifie l'identité (comme ==)
        }
    }
    
    protected void notifie(){
        for (Observateur o : this.listObs){
            o.miseAJour(this);
        }
    }
}
