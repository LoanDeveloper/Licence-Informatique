package Composants;

import java.util.ArrayList;

/**
 *
 * @author loant
 */
public class PC {
    private ArrayList<Composant> composants;

    public PC() {
        this.composants = new ArrayList<Composant>();
    }
    
    public void ajoutComposant(Composant c){
        this.composants.add(c);
    }
}
