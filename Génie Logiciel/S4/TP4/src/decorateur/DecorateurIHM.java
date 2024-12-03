package decorateur;
/**
 *
 * @author loant
 */
public abstract class DecorateurIHM implements AbstractionIHM{
    protected AbstractionIHM abstraction;
     
    public DecorateurIHM(AbstractionIHM abstraction){
        this.abstraction = abstraction;
    }
}
