
import java.util.ArrayList;

public abstract class Arbre 
{
	public abstract Integer getRacine(); 
	public abstract Arbre getAg(); 
	public abstract Arbre getAd(); 
	
	public abstract void setRacine(Integer s);
	public abstract void setAg(Arbre Ag);
	public abstract void setAd(Arbre Ad);
	
	
	public abstract boolean estVide();
        public abstract boolean estFeuille();
	public abstract Integer max();
        public abstract void plusCourtChemin(ArrayList<Integer> cheminLeMeilleur, ArrayList<Integer> cheminCourant);

}

class ArbreVide extends Arbre   
{
	ArbreVide ()
	{
	}
	
	public Integer getRacine() { return null; }
	public Arbre getAg() { return this; }
	public Arbre getAd() { return this; }
	
	public void setRacine(Integer s) {  }
	public void setAg(Arbre Ag) {  }
	public void setAd(Arbre Ad) {  }

	public boolean estVide(){
		return true;
	}
        
        public boolean estFeuille(){
            return false;
        }

	public Integer max(){
            return null;
        }
	
        public void plusCourtChemin(ArrayList<Integer> cheminLeMeilleur, ArrayList<Integer> cheminCourant){
            
        }

	
}

class ArbreCons extends Arbre
{
	private Integer racine;
	private Arbre Ag;
	private Arbre Ad;
	
	public ArbreCons(Integer val, Arbre Ag, Arbre Ad)
	{
		this.racine = val; this.Ag = Ag; this.Ad = Ad;
	}
	
	public ArbreCons( Integer val)
	{
		this.racine = val; this.Ag = new ArbreVide(); this.Ad = new ArbreVide();
	}
	
	public Integer getRacine() { return this.racine; }
	public Arbre getAg() { return this.Ag; }
	public Arbre getAd() { return this.Ad; }
	
	public void setRacine(Integer s) { this.racine = s; }
	public void setAg(Arbre Ag) { this.Ag = Ag; }
	public void setAd(Arbre Ad) { this.Ad = Ad; }
	
        public boolean estVide()
	{
		return false;
	}
		
	public boolean estFeuille()
	{
		return this.getAg().estVide() && this.getAd().estVide();
	}
	

        public Integer max(){
            Integer max = 0;
            if (this.getRacine() > max){
                max = this.getRacine();
            }
            this.getAd().max();
            this.getAg().max();
            return max;
        }

        public void plusCourtChemin(ArrayList<Integer> cheminLeMeilleur, ArrayList<Integer> cheminCourant){
           cheminCourant.add(this.getRacine());
           while (!this.getRacine().equals(10)){
               this.getAg().plusCourtChemin(cheminLeMeilleur, cheminCourant);
               this.getAd().plusCourtChemin(cheminLeMeilleur, cheminCourant);
           }
           if (cheminCourant.size() > cheminLeMeilleur.size()){
               cheminLeMeilleur = cheminCourant;
           }
           
        }
}

