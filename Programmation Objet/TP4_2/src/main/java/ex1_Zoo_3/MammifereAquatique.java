package ex1_Zoo_3;

/**
 * Classe représentant un mammifere aquatique caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le mammifere est carnivore,
 * - un indicateur booleen precisant si le mammifere evolue dans l'eau douce.
 */
public class MammifereAquatique implements Mammifere, Aquatique
{
   private String nomEspece;
   private boolean carnivore;
   private boolean eauDouce;

   public MammifereAquatique(String nomEspece, boolean carnivore, boolean eauDouce) {
      this.nomEspece = nomEspece;
      this.carnivore = carnivore;
      this.eauDouce = eauDouce;
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
    public boolean eauDouce() {
        return this.eauDouce;
    }
   
   
}
