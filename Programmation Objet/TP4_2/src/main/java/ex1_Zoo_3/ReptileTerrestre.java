package ex1_Zoo_3;

/**
 * Classe représentant un reptile terrestre caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le reptile est venimeux,
 * - un nom d'habitat (biotope).
 */
public class ReptileTerrestre implements Reptile, Terrestre{
   private String nomEspece;
   private boolean venimeux;
   private String habitat;

   public ReptileTerrestre(String nomEspece, boolean venimeux, String habitat) {
      this.nomEspece = nomEspece;
      this.venimeux = venimeux;
      this.habitat = habitat;
   }

    @Override
    public boolean estVenimeux() {
        return this.venimeux;
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
