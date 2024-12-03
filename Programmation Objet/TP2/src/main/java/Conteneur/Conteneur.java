package Conteneur;

import Conteneur.Colis;
import java.util.ArrayList;

/**
 *
 * @author loant
 */
public class Conteneur {
    protected int distance;
    protected int volume;
    protected int volumeMax;
    protected int poids;
    protected ArrayList<Colis> colis;
    
    public Conteneur(int distance, int volumeMax) {
        this.distance = distance;
        this.volumeMax = volumeMax;
        this.poids = 0;
        this.volume = 0;
        this.colis = new ArrayList<Colis>();
    }
    
    public boolean conditionChargement(Colis c){
        return ((c.donneVolume() + this.volume) <= this.volumeMax) && (c.donneDistance() == this.distance);
    }
            
    public boolean ajout(Colis c){
        if (this.conditionChargement(c)){
            this.poids += c.donnePoids();
            this.volume += c.donneVolume();
            this.colis.add(c);
            return true;
        }else{
            return false;
        }  
    }
    
    public int cout(){
        return this.poids * this.distance;
    }
    
    public int donneDistance(){
        return this.distance;
    }
    
    public int donnePoids(){
        return this.poids;
    }

    @Override
    public String toString() {
        return "Conteneur{" + "distance=" + distance + ", volume=" + volume + ", volumeMax=" + volumeMax + ", poids=" + poids + ", colis=" + colis + '}';
    }
}
