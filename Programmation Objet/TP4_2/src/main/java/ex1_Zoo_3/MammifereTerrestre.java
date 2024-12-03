package ex1_Zoo_3;

/**
 * Classe représentant un mammifere terrestre caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le mammifere est carnivore
 * - un nom d'habitat (biotope).
 */
public class MammifereTerrestre implements Mammifere, Terrestre{
   private String nomEspece;
   private boolean carnivore;
   private String habitat;

   public MammifereTerrestre(String nomEspece, boolean carnivore, String habitat) {
      this.nomEspece = nomEspece;
      this.carnivore = carnivore;
      this.habitat = habitat;
   }

    @Override
    public boolean estCarnivore() {
        return this.carnivore;
    }

    @Override
    public String donneNom() {
        return this.nomEspece;
    }

    @Override
    public String habitat() {
        return this.habitat;
    }
}
