import java.util.ArrayList;

public class StatistiqueEmprunts {
    private ArrayList<FicheEmprunt> empruntsTotal;
    private int empruntsBluRay;
    private int empruntsCDAudio;
    private int empruntLivres;

    public StatistiqueEmprunts(ArrayList<FicheEmprunt> empruntsTotal, int empruntsBluRay, int empruntsCDAudio, int empruntLivres) {
        this.empruntsTotal = empruntsTotal;
        this.empruntsBluRay = empruntsBluRay;
        this.empruntsCDAudio = empruntsCDAudio;
        this.empruntLivres = empruntLivres;
    }

    public void addTotal(FicheEmprunt f){
        empruntsTotal.add(f);
    }

    public void addCDAudio(){
        empruntsCDAudio++;
    }

    public void addLivres(){
        empruntLivres++;
    }

    public int getEmpruntsTotal() {
        return empruntsTotal.size();
    }

    public int getEmpruntsBluRay() {
        return empruntsBluRay;
    }

    public int getEmpruntsCDAudio() {
        return empruntsCDAudio;
    }

    public int getEmpruntLivres() {
        return empruntLivres;
    }
}
