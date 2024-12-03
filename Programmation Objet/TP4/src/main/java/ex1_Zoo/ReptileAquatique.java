package ex1_Zoo;
/**
 * Classe représentant un reptile aquatique caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le reptile est venimeux,
 * - un indicateur booleen precisant si le reptile evolue dans l'eau douce.
 */
public class ReptileAquatique extends Reptile implements Aquatique
{
   private boolean eauDouce;

    public ReptileAquatique(boolean eauDouce, boolean venimeux, String nomEspece) {
        super(venimeux, nomEspece);
        this.eauDouce = eauDouce;
    }
   
   
}
