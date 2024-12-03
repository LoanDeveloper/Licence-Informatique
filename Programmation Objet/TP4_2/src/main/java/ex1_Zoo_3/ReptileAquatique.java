package ex1_Zoo_3;

/**
 * Classe représentant un reptile aquatique caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le reptile est venimeux,
 * - un indicateur booleen precisant si le reptile evolue dans l'eau douce.
 */
public class ReptileAquatique implements Reptile, Aquatique
{
   private String nomEspece;
   private boolean venimeux;
   private boolean eauDouce;

   public ReptileAquatique(String nomEspece, boolean venimeux, boolean eauDouce) {
      this.nomEspece = nomEspece;
      this.venimeux = venimeux;
      this.eauDouce = eauDouce;
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
    public boolean eauDouce() {
        return this.eauDouce;
    }
}
