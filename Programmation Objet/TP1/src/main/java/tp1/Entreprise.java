package tp1;

/**
 *
 * @author loant
 */
public class Entreprise extends Client{
    private long numSIRET;

    public Entreprise(String nom, long numSIRET, String adresse) {
        super(nom, adresse);
        this.numSIRET = numSIRET;
    }
    
    public long donneNumSIRET(){
        return this.numSIRET;
    }

    @Override
    public String toString() {
        return "Entreprise{" + "numSIRET=" + numSIRET + '}';
    }
    
}
