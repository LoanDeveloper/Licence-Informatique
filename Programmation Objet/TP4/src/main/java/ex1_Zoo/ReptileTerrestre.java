package ex1_Zoo;
/**
 * Classe représentant un reptile terrestre caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le reptile est venimeux,
 * - un nom d'habitat (biotope).
 */
public class ReptileTerrestre extends Reptile implements Terrestre
{
   private String habitat;

    public ReptileTerrestre(String habitat, boolean venimeux, String nomEspece) {
        super(venimeux, nomEspece);
        this.habitat = habitat;
    }
}
