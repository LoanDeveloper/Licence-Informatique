package Conteneur;

/**
 *
 * @author loant
 */
public class ConteneurUrgent extends Conteneur{
    private int poidsMax;

    public ConteneurUrgent(int poidsMax, int distance, int volumeMax) {
        super(distance, volumeMax);
        this.poidsMax = poidsMax;
    }
    
    @Override
    public boolean conditionChargement(Colis c){
        return ((c.donneVolume() + this.volume) <= this.volumeMax) && c.donneDistance() == this.distance && (c.donnePoids() + this.poids) <= this.poidsMax;
    }
    
    @Override
    public int cout(){
        return (2 * super.cout());
    }
    
    public boolean ajout(Colis c){
        if (this.conditionChargement(c)){
            super.ajout(c);
            return true;
        }else{
            return false;
        }  
    }
}
