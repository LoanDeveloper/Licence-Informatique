package licence.annee1.salaires;

import java.util.ArrayList;

public class CalculScientifiques {
    private ArrayList<Double> array;
    private ArrayList<Double> repartition;

    /*
    Constructeur
     */
    public CalculScientifiques(ArrayList<Double> a){
        this.array = new ArrayList<Double>();
        this.array = a;
        this.repartition = new ArrayList<Double>();
    }

    /*
    ToString
     */

    public String toString(ArrayList<Double> revenu) {
        return "Salaire minimum : " + Min(revenu) +
                "Salaire maximum : " + Max(revenu) +
                "\n\rNombre total de salaires : " + nbSalaires(revenu) +
                "\n\rSalaire moyen : " + Moyenne(revenu) +
                "\n\rSalaire médian : " + Median(revenu) +
                "\n\rRépartition sur 5 classes :" + Repartition(revenu,5);
    }

    /*
        Méthodes de calculs
         */
    public Double Min(ArrayList<Double> revenu){
        Double min = revenu.get(0);
        for (Double r : revenu){
            if (r<min){
                min = r;
            }
        }
        return min;
    }

    public Double Max(ArrayList<Double> revenu){
        Double max = revenu.get(0);
        for (Double r : revenu){
            if (r>max){
                max = r;
            }
        }
        return max;
    }

    public int nbSalaires(ArrayList<Double> revenu){
        return revenu.size();
    }

    public Double Moyenne(ArrayList<Double> revenu){
        Double add = 0.0;
        for (Double r : revenu){
            add+=r;
        }
        return add/revenu.size();
    }

    public ArrayList<Double> TriBulle(ArrayList<Double> collection){ //Correction algorithme du tri à bulle, je peux retirer le paramètre collection pour le remplacé ensuite par array dans la méthode
        ArrayList<Double> res = new ArrayList<Double>();
        res.addAll(collection); // On créée une copie de collection

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.size()-1; j++) {
                if (res.get(j) > res.get(j+1)){
                    // On échange
                    Double aux = res.get(j);
                    res.set(j, res.get(j + 1));
                    res.set(j + 1, aux);
                }
            }
        }
        return res;
    }

    public Double Median(ArrayList<Double> revenu){
        ArrayList<Double> array_tri = TriBulle(revenu);
        int moitie = array_tri.size()/2;

        if (revenu.size() % 2 != 0){
            moitie += 0.5;
            return (array_tri.get(moitie) + array_tri.get(moitie - 1)) / 2;
        }else {
            return (array_tri.get(moitie) + array_tri.get(moitie - 1)) / 2;
        }
    }

    /*
    Répartition en n classes, avec un intervalle de salaire pour chaque classe
     */

    public String Repartition(ArrayList<Double> revenu,int nb){
        Double max= Max(revenu);
        Double min= Min(revenu);
        Double ecart= (max-min)/nb;
        int cpt=0;
        int total=0;
        double pourcent=0.0;
        for(Double classmin=min;classmin<max; classmin+=ecart){
            for(Double i:revenu){
                if((classmin<=i) && (i<(classmin+ecart))){
                    cpt+=1;
                }else if(i.equals(max)){
                    cpt+=1;
                }
            }
            pourcent=Math.round((100.0*cpt/revenu.size()));
            System.out.println(cpt + " Salaires entre " +classmin+"€ et "+(classmin+ecart)+"€"+ " ("+pourcent+"%)");
            total += pourcent;
            cpt=0;
        }
        return("Total : " + total + " %");
    }
}
