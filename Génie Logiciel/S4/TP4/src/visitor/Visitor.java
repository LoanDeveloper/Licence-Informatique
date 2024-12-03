package visitor;
import tp1.Catalogue;
import tp1.Article;

/**
 *
 * @author loant
 */
public interface Visitor {
    public void visit(Catalogue catalogue);
    public void visit(Article article);
}
