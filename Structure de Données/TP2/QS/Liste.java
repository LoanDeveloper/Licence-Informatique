
import java.util.ArrayList;

public abstract class Liste {
    public abstract boolean estVide();
    public abstract Integer getPremier();
    public abstract Liste getReste();
    public abstract Liste inferieurs(int s);
    public abstract Liste superieurs(int s);
    public abstract Liste concat(Liste that);
    public abstract Liste QS();
    public abstract void listeEnTab(ArrayList T);
    public abstract ArrayList listeEnTab();
}

class ListeVide extends Liste {
    public ListeVide() {
    }

    public boolean estVide() {
        return true;
    }

    public Integer getPremier() {return null;}

    public Liste getReste() {return null; }

    public Liste inferieurs(int s) {
        return new ListeVide();
    }

    public Liste superieurs(int s) {
        return new ListeVide();
    }

    public Liste concat(Liste that) {
        return that;
    }
    
    public Liste QS() {
        return new ListeVide();
    }

    public void listeEnTab(ArrayList T) {
        T = new ArrayList();
    }

    public ArrayList listeEnTab() {
        return new ArrayList();
    }
}

class ListeCons extends Liste {
    private Integer valeur;
    private Liste suiv;

    public ListeCons(Integer valeur, Liste suiv) {
        this.valeur = valeur;
        this.suiv = suiv;
    }

    public ListeCons(Integer nbElements) {
        if (nbElements==1) {
            this.valeur = alea(0,1000);
            this.suiv = new ListeVide();
        } else {
            this.valeur = alea(0,1000);
            this.suiv = new ListeCons(nbElements - 1);
        }
    }

    public boolean estVide() {
        return false;
    }

    public Integer getPremier() {
        return this.valeur;
    }

    public Liste getReste() {
        return suiv;
    }

    public Liste inferieurs(int s) {
        if (this.getPremier() < s) {
            return new ListeCons(this.getPremier(),this.getReste().inferieurs(s));
        } else {
            return this.getReste().inferieurs(s);
        }
    }

    public Liste superieurs(int s) {
        if (this.getPremier() > s) {
            return new ListeCons(this.getPremier(),this.getReste().superieurs(s));
        } else {
            return this.getReste().superieurs(s);
        }
    }

    public Liste concat(Liste that) {
        return new ListeCons(this.getPremier(),this.getReste().concat(that));
    }

    public Liste QS() {
        Liste pivot = new ListeCons(this.getPremier(),new ListeVide());
        Liste inf = this.inferieurs(this.getPremier()).QS();
        Liste sup = this.superieurs(this.getPremier()).QS();
        return inf.concat(pivot).concat(sup);
    }
    
    public void listeEnTab(ArrayList T) {
        T.add(this.getPremier());
        this.getReste().listeEnTab(T);
    }

    public ArrayList listeEnTab() {
        ArrayList T = new ArrayList();
        T.add(this.getPremier());
        T.addAll(this.getReste().listeEnTab());
        return T;
    }
    
    private int alea(int min, int max ) {
        return (int) ((Math.random()*(max-min+1))+ min);
    }

}