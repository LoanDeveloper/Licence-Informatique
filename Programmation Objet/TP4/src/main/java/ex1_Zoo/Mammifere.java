package ex1_Zoo;

/**
 *
 * @author loant
 */
public interface Mammifere implements Animal{
   private boolean carnivore;

    public Mammifere(boolean carnivore, String nomEspece) {
        super(nomEspece);
        this.carnivore = carnivore;
    }
    
    
   
   
}
