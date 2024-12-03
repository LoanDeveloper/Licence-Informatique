package ex1_Zoo;
/**
 * Classe représentant un mammifere aquatique caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le mammifere est carnivore,
 * - un indicateur booleen precisant si le mammifere evolue dans l'eau douce.
 */
public class MammifereAquatique extends Mammifere implements Aquatique
{
   private boolean eauDouce;

    public MammifereAquatique(boolean eauDouce, boolean carnivore, String nomEspece) {
        super(carnivore, nomEspece);
        this.eauDouce = eauDouce;
    }

   
}
