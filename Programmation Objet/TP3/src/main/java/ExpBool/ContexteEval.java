package ExpBool;

import java.util.HashMap;

/**
 *
 * @author loant
 */
public class ContexteEval {
    private HashMap<Character, Boolean> hashmap;

    public ContexteEval() {
        hashmap = new HashMap<Character, Boolean>();
    }
    
    public void affecte(Character c, Boolean b){
        hashmap.put(c, b);
    }

    public HashMap<Character, Boolean> getHashmap() {
        return hashmap;
    }
    
    
}
