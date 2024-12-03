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
    
    public void addArticle(Article a){
        this.array.add(a);
    }

    public ArrayList<Article> getCatalogue() {
        return array;
    }

    public void setCatalogue(ArrayList<Article> array) {
        this.array = array;
    }
    
    
}
