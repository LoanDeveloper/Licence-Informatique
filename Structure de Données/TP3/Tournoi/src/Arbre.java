
import java.util.ArrayList;



public abstract class Arbre 
{
	public abstract String getRacine(); 
	public abstract Arbre getAg(); 
	public abstract Arbre getAd(); 
	
	public abstract void setRacine(String s);
	public abstract void setAg(Arbre Ag);
	public abstract void setAd(Arbre Ad);
	
	
	public abstract boolean estVide();
		
	public abstract void afficher();
	
	public abstract String lePlusAGauche();
	
	public abstract Arbre supprimer( String val );
	
	public abstract boolean trouver( String val );
	
	public abstract boolean estFeuille();
	
	public abstract int nbFeuilles();
	
	public abstract int nbNoeuds ();	
	
	public abstract int hauteur ();
	
	public abstract boolean insereFeuille(String valeur);  //specif tournoi
	
	public abstract void placerGagnant(String s);  // specif tournoi
        
        public abstract void adversaires(ArrayList adv);
	

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

	public boolean estVide()
	{
		return true;
	}

	
	public void afficher()
	{
		// System.out.print(" vide ");
	}	
	

	public boolean estFeuille()
	{
		return false;
	}
	
	
	public int nbNoeuds ()
	{
		return 0;	
	}

	public int hauteur () {
		return 0;
	}
	
        public int nbFeuilles(){return 0;}
        
        public boolean trouver (String element){return false;}
        public String lePlusAGauche(){return "";}
        public Arbre supprimer(String valeur){return new ArbreVide();}
	
        public boolean insereFeuille(String valeur){return false;}
        
        public void placerGagnant(String s){}
	
        public void adversaires(ArrayList adv){}
}

class ArbreCons extends Arbre
{
	private String racine;
	private Arbre Ag;
	private Arbre Ad;
	
	public boolean estVide()
	{
		return false;
	}

	ArbreCons(String val, Arbre Ag, Arbre Ad)
	{
		this.racine = val; this.Ag = Ag; this.Ad = Ad;
	}
	
	ArbreCons( String val)
	{
		this.racine = val; this.Ag = new ArbreVide(); this.Ad = new ArbreVide();
	}
	
        public ArbreCons(int niveau){
            if (niveau > 0){
                this.racine = null;
                this.Ag = new ArbreCons(niveau - 1);
                this.Ad = new ArbreCons(niveau - 1);
            }else{
                this.Ad = new ArbreVide();
                this.Ag = new ArbreVide();
            }
        }
	

	
	public String getRacine() { return this.racine; }
	public Arbre getAg() { return this.Ag; }
	public Arbre getAd() { return this.Ad; }
	
	public void setRacine(String s) { this.racine = s; }
	public void setAg(Arbre Ag) { this.Ag = Ag; }
	public void setAd(Arbre Ad) { this.Ad = Ad; }

	
		
	public boolean estFeuille()
	{
		return this.getAg().estVide() && this.getAd().estVide();
	}
	
	public void afficher()
	{
			System.out.print( this.getRacine()+" " );
			this.getAg().afficher();
			this.getAd().afficher();
	}
	
	
	public int nbNoeuds()	{
			int nfg = 0, nfd =0;
			nfg = getAg().nbNoeuds();
			nfd = getAd().nbNoeuds();
			return (1 + nfg + nfd) ;
	}

	public int hauteur () {
			int nfg = 0, nfd = 0;
			nfg = 1 + getAg().hauteur();
			nfd = 1 + getAd().hauteur();
			return Math.max(nfg, nfd) ;			
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
                    return this.getAd();
                }else{
                    return new ArbreCons(this.lePlusAGauche(), this.getAg().supprimer(this.lePlusAGauche()),this.getAd());
            }
            }else{
                return new ArbreCons(this.getRacine(), this.getAg().supprimer(valeur), this.getAd().supprimer(valeur));
            }
        }
        
        public boolean insereFeuille(String valeur){
            if (this.estFeuille() && this.getRacine() == null){
                this.setRacine(valeur);
                return true;
            }else{
                return this.getAg().insereFeuille(valeur) || this.getAd().insereFeuille(valeur);
            }
        }
        
        public void placerGagnant(String element){
            if (this.getRacine() == null && (this.getAd().getRacine() != null && this.getAg().getRacine() != null) && (element.equals(this.getAg().getRacine()) || element.equals(this.getAd().getRacine()))){
                this.setRacine(element);
            }else{
                this.getAg().placerGagnant(element);
                this.getAd().placerGagnant(element);
            }
          
        }
        
        public void adversaires(ArrayList adv){
            if (this.getRacine().equals(this.getAd())){
                adv.add(this.getAg());
                this.Ag.adversaires(adv);
            }else if(this.getRacine().equals(this.getAg())){
                adv.add(this.getAd());
                this.Ag.adversaires(adv);
            }
        }
        
}

