package tp1;

import java.util.ArrayList;
import observer.Observer;
import observer.Observable;
import visitor.Element;
import visitor.Visitor;
/**
 *
 * @author loant
 */
public class Catalogue implements Observer, Element{
    private ArrayList<Article> array;
    
    public Catalogue(){
        array = new ArrayList<>();
    }

    public ArrayList<Article> getCatalogue() {
        return array;
    }

    public void setCatalogue(ArrayList<Article> array) {
        this.array = array;
    }
    
    public void accept(Visitor v){
        v.visit(this);
    }
    public void addProd(Article a){
        this.array.add(a);
        a.addObserver(this);    
    }
    
    public void afficher(){
        for (Article a : array){
            System.err.println(a.toString());
        }
    }
    
    public void sauvegarderCatalogue(String nomfichier){
        System.out.println("catalogue sauvegardé");
    }
    
    public ArrayList<Article> getArticles(){
        return this.array;
    }
    
    public Article getArticle(int num){
        Article result = null;
        for (Article a : array){
            if (a.getId().equals(num)){
                return a;
            }
        }
        return result;
    }
    
    @Override
    public void update(Observable obs, Object arg){
        System.out.println("update" + obs);
        this.sauvegarderCatalogue("catalogue.txt");
    }
}
