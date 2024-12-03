package visitor;

/**
 *
 * @author loant
 */
public interface Element {
    public void accept(Visitor v);
}
