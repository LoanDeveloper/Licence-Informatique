package ex1_Zoo;

/**
 *
 * @author loant
 */
public interface Reptile implements Animal{
    private boolean venimeux;

    public Reptile(boolean venimeux, String nomEspece) {
        super(nomEspece);
        this.venimeux = venimeux;
    }
    
}
