package decorateur;
import tp1.Catalogue;
/**
 *
 * @author loant
 */
public class DecorateurIHMVendeur extends DecorateurIHM{

    public DecorateurIHMVendeur(AbstractionIHM abstraction) {
        super(abstraction);
    }
    
    @Override 
    public void afficherMenu(){
        System.out.println("1 - Afficher les produits du catalogue");
        System.out.println("2 - Vendre un produit");
        System.out.println("3 - Retour à l'écran précedent");
    }
    
    public void afficherSousMenu(Catalogue cat){
        System.out.println("0- Retour");
        for (int i = 0; i < cat.getArticles().size(); i++){
            System.out.println((i+1) + "- Vendre" + cat.getArticle(i).getNom());
        }
    }
}
