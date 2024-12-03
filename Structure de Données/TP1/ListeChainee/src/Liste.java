import static java.lang.Integer.parseInt;

public abstract class Liste
{
    public abstract boolean estVide();
    public abstract String getPremier();
    public abstract Liste getReste();
    public abstract void afficheIt();
    public abstract boolean rechercherIt(String s);
    public abstract int size();
    public abstract String somme();
    public abstract void afficher();
    public abstract Liste copie();
    public abstract Liste placerFin(String val);
    public abstract boolean trouver( String val );
    public abstract Liste concat(Liste L1);
    public abstract Liste inverser();
    public abstract Liste inserer(String s , int rang );
    public abstract Liste intersection(Liste L);
    public abstract Liste union(Liste L);
    public abstract boolean inclus( Liste L);
    public abstract Liste inferieurs(int s);
    public abstract Liste superieurs(int s);
    public abstract Liste QS();
}

//************************************************************************************************************


class ListeVide extends Liste {
    ListeVide() {
    }

    public boolean estVide() {
        return true;
    }

    public String getPremier() {
        return null;
    }

    public Liste getReste() {
        return null;
    }

    public void afficheIt() {
    }

    public boolean rechercherIt(String s) {
        return false;
    }

    public int size(){ return 0;}

    public String somme(){ return "";}
    public void afficher(){System.out.print("");}
    public Liste copie(){return new ListeVide();}
    public Liste placerFin(String val){return new ListeCons(val,new ListeVide());}
    public boolean trouver( String val ){return false;}
    public Liste concat(Liste L1){
        return new ListeCons(L1.getPremier(),L1.getReste());
    }
    public Liste inverser(){ return new ListeVide();}
    public Liste inserer(String s , int rang) {return new ListeVide();}
    public Liste intersection(Liste L){return new ListeVide();}
    public Liste union(Liste L){return new ListeCons(L.getPremier(),L.getReste());}
    public boolean inclus(Liste L){return true;}
    public Liste inferieurs(int s){return new ListeVide();}
    public Liste superieurs(int s){return new ListeVide();}
    public Liste QS(){return new ListeVide();}

}
//************************************************************************************************************

class ListeCons extends Liste
{
    private String valeur;
    private Liste suiv;

    ListeCons(String val, Liste L)
    {
        this.valeur = val; this.suiv = L;
    }

    public boolean estVide()
    {
        return false;
    }

    public String getPremier() { return this.valeur; }

    public Liste getReste() { return this.suiv; }

    public void afficheIt(){
        Liste liste = this;
        while (!liste.estVide()){
            System.out.println(liste.getPremier() + " ");
            liste = liste.getReste();
        }
    }

    public boolean rechercherIt(String s){
        Liste liste = this;
        while (!liste.estVide()){
            if (liste.getPremier().equals(s)){
                return true;
            }
            liste = liste.getReste();
        }return false;
    }

    public int size(){return 1 + this.getReste().size();}
    public String somme(){return this.getPremier() + this.getReste().somme();}
    public void afficher(){
        System.out.print(this.getPremier() + " ");
        this.getReste().afficher();
    }

    public Liste copie(){return new ListeCons(this.getPremier(), this.getReste().copie());}

    public Liste placerFin(String val){return new ListeCons(this.getPremier(), this.getReste().placerFin(val));}

    public boolean trouver( String val ){
        if (this.getPremier().equals(val)){
            return true;
        }
        return this.getReste().trouver(val);
    }

    public Liste concat(Liste L1){
        return new ListeCons(this.getPremier(), this.getReste().concat(L1));
    }

    public Liste inverser(){
        return this.getReste().inverser().placerFin(this.getPremier());
    }

    public Liste inserer(String s , int rang ){
        if (rang == 0){
            return new ListeCons(s,this);
        }
        return new ListeCons(this.getPremier(), this.getReste().inserer(s, rang - 1));
    }

    public Liste intersection (Liste L){
        if (L.trouver(this.getPremier())){
            return new ListeCons(this.getPremier(),this.getReste().intersection(L));
        }
        return this.getReste().intersection(L);
    }

    public Liste union(Liste L){
        if (!L.trouver(this.getPremier())){
            return new ListeCons(this.getPremier(), this.getReste().union(L));
        }
        return this.getReste().union(L);
    }

    public boolean inclus( Liste L){
        if (L.trouver(this.getPremier())){
            return this.getReste().inclus(L);
        }
        return false;
    }

    //******************************* td2 / tp2 ************************************
    public Liste inferieurs(int s){
        if (parseInt(this.getPremier()) < s){
            return new ListeCons(this.getPremier(), this.getReste().inferieurs(s));
        }
        return this.getReste().inferieurs(s);
    }

    public Liste superieurs(int s){
        if (parseInt(this.getPremier()) > s){
            return new ListeCons(this.getPremier(), this.getReste().inferieurs(s));
        }
        return this.getReste().inferieurs(s);
    }

    public Liste QS(){
        Liste pivot = new ListeCons(this.getPremier(), new ListeVide());
        Liste inf = this.inferieurs(parseInt(this.getPremier())).QS();
        Liste sup = this.superieurs(parseInt(this.getPremier())).QS();
        return inf.concat(pivot).concat(sup);
    }
}