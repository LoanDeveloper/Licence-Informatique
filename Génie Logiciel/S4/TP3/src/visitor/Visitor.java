package visitor;
import tp1.Catalogue;
import tp1.Article;

/**
 *
 * @author loant
 */
public interface Visitor {
    public void visitCatalogue(Catalogue catalogue);
    public void visitArticle(Article article);
}
