

public abstract class Arbre 
{
	public abstract String getRacine(); 
	public abstract Arbre getAg(); 
	public abstract Arbre getAd(); 
	
	public abstract void setRacine(String s);
	public abstract void setAg(Arbre Ag);
	public abstract void setAd(Arbre Ad);
	
	
	public abstract boolean estVide();
	public abstract void afficherGRD();
        public abstract int nbFeuilles();
        public abstract boolean trouver (String element);
        public abstract String lePlusAGauche();
        public abstract Arbre supprimer(String valeur);
}   

class ArbreVide extends Arbre   
{
	ArbreVide ()
	{
	}
	
	public String getRacine() { return null; }
	public Arbre getAg() { return this; }
	public Arbre getAd() { return this; }
	
	public void setRacine(String s) {  }
	public void setAg(Arbre Ag) {  }
	public void setAd(Arbre Ad) {  }

	public boolean estVide(){return true;}
        
        public void afficherGRD(){}
        
        public int nbFeuilles(){return 0;}
        
        public boolean trouver (String element){return false;}
        public String lePlusAGauche(){return "";}
        public Arbre supprimer(String valeur){return new ArbreVide();}

}
class ArbreCons extends Arbre
{
	private String racine;
	private Arbre Ag;
	private Arbre Ad;
	
	public ArbreCons(String val, Arbre Ag, Arbre Ad)
	{
		this.racine = val; this.Ag = Ag; this.Ad = Ad;
	}
	
	public ArbreCons( String val)
	{
		this.racine = val; this.Ag = new ArbreVide(); this.Ad = new ArbreVide();
	}
        
        public ArbreCons(int niveau){
            if (niveau > 0){
                this.racine = null;
                this.Ag = new ArbreCons(niveau - 1);
                this.Ad = new ArbreCons(niveau - 1);
            }

        }
	
	
	public String getRacine() { return this.racine; }
	public Arbre getAg() { return this.Ag; }
	public Arbre getAd() { return this.Ad; }
	
	public void setRacine(String s) { this.racine = s; }
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
	
        public void afficherGRD(){
            this.getAg().afficherGRD();
            System.out.println(this.getRacine());
            this.getAd().afficherGRD();
        }
        
        public int nbFeuilles(){
            if (this.estFeuille()){
                return 1;
            }else{
                return this.getAg().nbFeuilles() + this.getAd().nbFeuilles();
            }
        }

        public boolean trouver(String element){
            if (this.getRacine().equals(element)){
                return true;
            }
            return this.getAd().trouver(element) || this.getAg().trouver(element);
        }
        
        public String lePlusAGauche(){
            if (this.estFeuille()){
                return this.getRacine();
            }
            return this.getAg().lePlusAGauche();
        }
        
        public Arbre supprimer(String valeur){
            if (this.getRacine().equals(valeur)){
                if (this.getAg().estVide()){
                    return this.Ad;
                }else{
                    return new ArbreCons(this.lePlusAGauche(), this.getAg().supprimer(this.lePlusAGauche()),this.getAd());
            }
            }
            return new ArbreCons(this.getRacine(), this.getAg().supprimer(valeur), this.getAd().supprimer(valeur));
        }

}
	

