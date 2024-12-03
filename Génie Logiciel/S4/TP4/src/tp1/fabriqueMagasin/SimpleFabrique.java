package tp1.fabriqueMagasin;

import tp1.Article;
import tp1.Jardinage;
import tp1.Bricolage;
import tp1.Animal;

/**
 *
 * @author loant
 */
public class SimpleFabrique {
    
    public Article creerProduit(String ligne){
        String[] split = ligne.split(";");
        if (split[0].equals("Jardinage")){
            return new Jardinage(split[3], split[1], Integer.parseInt(split[4]), Integer.parseInt(split[2]), split[5]);
        }else if(split[0].equals("Bricolage")){
            return new Bricolage(split[3], split[1], Integer.parseInt(split[4]), Integer.parseInt(split[2]), split[5], split[6]);
        }else if(split[0].equals("Animal")){
            return new Animal(split[3], split[1], Integer.parseInt(split[4]), Integer.parseInt(split[2]), split[5], Integer.parseInt(split[6]));
        }else{
            return null;
        }
        }
}
