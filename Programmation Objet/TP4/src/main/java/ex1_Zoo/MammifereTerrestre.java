package ex1_Zoo;
/**
 * Classe représentant un mammifere terrestre caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le mammifere est carnivore
 * - un nom d'habitat (biotope).
 */
public class MammifereTerrestre extends Mammifere
{
   private String habitat;

    public MammifereTerrestre(String habitat, boolean carnivore, String nomEspece) {
        super(carnivore, nomEspece);
        this.habitat = habitat;
    }

}
