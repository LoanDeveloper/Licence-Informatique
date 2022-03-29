import java.nio.charset.CodingErrorAction;
import java.util.HashMap;

import static java.lang.Math.abs;

public class Panier {
    //attributs
    private HashMap<Ingredient, Integer> inventaire;

    //constructeurs
    public Panier(){
        this.inventaire = new HashMap<Ingredient, Integer>();
    }

    public Panier(HashMap<Ingredient, Integer> inventaire){
        this.inventaire = (HashMap<Ingredient, Integer>) inventaire.clone();
    }

    //getter
    public HashMap<Ingredient, Integer> getContenu() {
        return this.inventaire;
    }

    //toString
    public String toString() {
        String str = "";
        for (Ingredient i : this.inventaire.keySet()){
            Integer quantite = this.inventaire.get(i);
            str += i.getNom() + " : " + quantite + ", ";
        }
        if (!this.inventaire.isEmpty()){
            return str.substring(0, str.length()-2);
        }
        return "";
    }

    //méthodes
    public double getPoids(){
        double res = 0.0;
        for (Ingredient i : this.inventaire.keySet()){
            res += this.inventaire.get(i);
        }
        return res;
    }

    public boolean estPresent(Ingredient i){
        return this.inventaire.containsKey(i);
    }

    public boolean estPresentBis(Ingredient i){
        for (Ingredient ing : this.inventaire.keySet()){
            if (ing == i){
                return true;
            }
        }return false;
    }

    public void ajoute(Ingredient i, Integer qte){
        if (inventaire.containsKey(i)){
            this.inventaire.replace(i, this.inventaire.get(i) + qte);
        }else{
            this.inventaire.put(i,qte);
        }
    }

    public void retire(Ingredient i, Integer qte){
        if (this.inventaire.containsKey(i)){
            if (this.inventaire.get(i) > qte){
                this.inventaire.replace(i,this.inventaire.get(i)-qte);
            }else{
                this.inventaire.remove(i);
            }
        }
    }

    public Panier fusionne(Panier p){
        Panier res = new Panier();
        for (Ingredient i : this.inventaire.keySet()){
            res.ajoute(i,this.inventaire.get(i));
        }
        for (Ingredient i : p.inventaire.keySet()){
            res.ajoute(i,(p.inventaire.get(i)));
        }
        return res;
    }

    public boolean estCuisinable(Plat p){
        for (Ingredient i : p.getIngredients().keySet()){
            if (this.inventaire.containsKey(i)){
                if (p.getIngredients().get(i) > this.inventaire.get(i)){
                    return false;
                }
            }else{
                return false;
            }
        }return true;
    }

    public Panier cuisine(Plat p){
        Panier res = this;
        if (res.estCuisinable(p)){
            for (Ingredient i : p.getIngredients().keySet()){
                res.retire(i,p.getIngredients().get(i));
            }
        }else{
            for (Ingredient i : p.getIngredients().keySet()){
                if (res.getContenu().containsKey(i)){
                    res.retire(i,res.getContenu().get(i));
                }
            }
        }
        return res;
    }

    public Panier achete(Plat p){
        Panier res = new Panier();
        if (!this.estCuisinable(p)){
            for (Ingredient i : p.getIngredients().keySet()){
                if (!this.getContenu().containsKey(i)){
                    res.ajoute(i,p.getIngredients().get(i));
                }else{
                    if ((p.getIngredients().get(i)-this.getContenu().get(i)) != 0){
                        res.ajoute(i,(p.getIngredients().get(i)-this.getContenu().get(i)));
                    }
                }
            }
        }
        return res;
    }
}
