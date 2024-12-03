/**
 *
 * @author loant
 */
public class Valeur extends Sujet{
    private int valeur;
    
    public Valeur(int init){
        this.valeur = init;
    }
    
    public void incremente(){
        this.valeur++;
        super.notifie();
    }
    
    public int donneValeur(){
        return this.valeur;
    }
}
