package tp1;

import java.util.ArrayList;

/**
 *
 * @author loant
 */
public class Catalogue {
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
    
    public void addProd(Article a){
        this.array.add(a);
    }
    
    public void afficher(){
        for (Article a : array){
            System.err.println(a.toString());
        }
    }
    
}
