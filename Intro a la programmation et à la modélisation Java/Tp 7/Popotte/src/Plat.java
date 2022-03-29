import java.util.ArrayList;
import java.util.HashMap;

public class Plat {
    //attributs
    private String nom;
    private HashMap<Ingredient, Integer> ingredients;

    //constructeurs
    public Plat(String nom){
        this.nom = nom;
        this.ingredients = new HashMap<Ingredient, Integer>();
    }

    public Plat(String nom,HashMap<Ingredient, Integer> ingredients){
        this.nom = nom;
        this.ingredients = (HashMap<Ingredient, Integer>)ingredients.clone();
    }

    //getters
    public String getNom(){
        return this.nom;
    }

    public double getGlucide(){
        double res=0.0;
        for (Ingredient i : this.ingredients.keySet()){
            res += this.ingredients.get(i) * (i.getGlucide());
        }
        return res;
    }

    public double getLipide(){
        double res=0.0;
        for (Ingredient i : this.ingredients.keySet()){
            res += this.ingredients.get(i) * (i.getLipide());
        }
        return res;
    }

    public double getProteine(){
        double res=0.0;
        for (Ingredient i : this.ingredients.keySet()){
            res += this.ingredients.get(i) * (i.getProteine());
        }
        return res;
    }

    public long getCalories(){
        long res = 0;
        for (Ingredient i : this.ingredients.keySet()){
            res += this.ingredients.get(i) * (i.getCalories());
        }
        return res;
    }

    public HashMap<Ingredient, Integer> getIngredients() {
        return this.ingredients;
    }

    //méthodes
    public void ajoute(Ingredient i, Integer qte){
        if (ingredients.containsKey(i)){
            this.ingredients.replace(i, this.ingredients.get(i) + qte);
        }else{
            this.ingredients.put(i,qte);
        }
    }

    public Ingredient maxCalories(){
        if (!this.ingredients.isEmpty()){
            Ingredient i_max = new Ingredient("",0,0,0,0);
            for (Ingredient i : this.ingredients.keySet()){
                if (i.getProteine() > i_max.getProteine()){
                    i_max = i;
                }
            }
            return i_max;
        }else{
            Ingredient i_null = new Ingredient("NULL",0,0.0,0.0,0);
            return i_null;
        }
    }

    public ArrayList<Ingredient> richeProteine(double seuil){
        ArrayList<Ingredient> res = new ArrayList<Ingredient>();
        for (Ingredient i : ingredients.keySet()){
            if (i.getProteine()>=seuil){
                res.add(i);
            }
        }
        return res;
    }
    //tostring
    public String toString(){
        String str = "";
        for (Ingredient i : this.ingredients.keySet()){
            String nom = i.getNom();
            String quantite = this.ingredients.get(i)+"g de ";
            str += quantite + nom + ", ";
        }
        return this.nom + " : " + str.substring(0, str.length()-2);
    }
}
