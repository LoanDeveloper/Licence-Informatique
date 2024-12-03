package arbrebrentier;

import java.util.ArrayList;

public abstract class ArbreBR 
{
	public abstract Integer getRacine(); 
	public abstract ArbreBR getAg(); 
	public abstract ArbreBR getAd(); 
	
	public abstract void setRacine(Integer s);
	public abstract void setAg(ArbreBR Ag);
	public abstract void setAd(ArbreBR Ad);
	
	public abstract ArbreBR insereTo( Integer val );		// nouveau, equivalent à un constructeur
	
	public abstract boolean rechercherABR (Integer val );
	
	public abstract boolean estVide();
		
	public abstract void afficher();
	
	public abstract Integer lePlusAGauche();
	
	public abstract ArbreBR supprimer( Integer val );
	
	public abstract boolean trouver( Integer val );
	
	public abstract boolean estFeuille();
	
	public abstract int nbFeuilles();
	
	public abstract int nbNoeuds ();	
	
	public abstract int hauteur ();
	
	public abstract void arbreBREnTab (ArrayList t);

	
}
//----------------------------------------------------------------------
class ArbreBRVide extends ArbreBR   
{
	public ArbreBRVide ()
	{
	}
	
	public Integer getRacine() { return null; }
	public ArbreBR getAg() { return this; }
	public ArbreBR getAd() { return this; }
	
	public void setRacine(Integer s) {  }
	public void setAg(ArbreBR Ag) {  }
	public void setAd(ArbreBR Ad) {  }

	public ArbreBR insereTo( Integer val )
	{
		return new ArbreBRCons(val);
	}
	
	
	
	public boolean estVide()
	{
		return true;
	}

	
	public void afficher()
	{
		// System.out.print(" vide ");
	}	
	
	public Integer lePlusAGauche()
	{
	  return null;
	}
	
	public ArbreBR supprimer( Integer val )
	{
		return this;
	}
	
	public boolean trouver( Integer val )
	{
		return false;
	}

	public boolean estFeuille()
	{
		return false;
	}
	
	public int nbFeuilles()
	{
		return 0;
	}
	
	public int nbNoeuds ()
	{
		return 0;	
	}

	public int hauteur () {
		return 0;
	}
        
	public boolean rechercherABR (Integer val ){
            return false;
        }
	
	public void arbreBREnTab (ArrayList t) {

	}

}

//----------------------------------------------------------------------

class ArbreBRCons extends ArbreBR
{
	private Integer racine;
	private ArbreBR Ag;
	private ArbreBR Ad;

	public boolean estVide()
	{
		return false;
	}

	protected ArbreBRCons(Integer val, ArbreBR Ag, ArbreBR Ad)
	{
		this.racine = val; this.Ag = Ag; this.Ad = Ad;
	}
	
	protected ArbreBRCons( Integer val)
	{
		this.racine = val; this.Ag = new ArbreBRVide(); this.Ad = new ArbreBRVide();
	}

	
	
	public ArbreBR insereTo( Integer val )
	{
		if(!this.trouver(val)){
			if(val.compareTo(getRacine())<0){
				return new ArbreBRCons(this.getRacine(), this.getAg().insereTo(val), this.getAd());
			}
			else{
				return new ArbreBRCons(this.getRacine(),this.getAg(),this.getAd().insereTo(val));
			}
		}
		return this;
	}
	
	public Integer getRacine() { return this.racine; }
	public ArbreBR getAg() { return this.Ag; }
	public ArbreBR getAd() { return this.Ad; }
	
	public void setRacine(Integer s) { this.racine = s; }
	public void setAg(ArbreBR Ag) { this.Ag = Ag; }
	public void setAd(ArbreBR Ad) { this.Ad = Ad; }


	

		
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
	
	public Integer lePlusAGauche()
	{
		if (this.getAg().estVide()) return this.getRacine();
		else return this.getAg().lePlusAGauche();	
	}

	

	public boolean trouver( Integer val )						//recherche dans tout l'arbre
	{
		if (val.intValue() == this.getRacine().intValue() )
					return true;
		else
			return this.getAg().trouver(val) || this.getAd().trouver(val);	
	
	}

	public int nbFeuilles()
	{
		if (this.estFeuille()) return 1;
		else
			return this.getAg().nbFeuilles()+this.getAd().nbFeuilles();
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
        
        public boolean rechercherABR (Integer val ){
            if(val.compareTo(getRacine()) <=0){
				return true;
			}
			else{
				if(val > getRacine()){
					return getAd().rechercherABR(val);
				}
				else{
					return getAg().rechercherABR(val);
				}
			}
        }

        public ArbreBR supprimer( Integer val )
	{
		if(val.compareTo(getRacine()) == 0){
			if(this.getAd().estVide()){
				return this.getAg();
			}
			Integer valeur = this.getAd().lePlusAGauche();
			return new ArbreBRCons(valeur, this.getAg(),this.getAd().supprimer(valeur));
		}
		else{
			if(val.compareTo(getRacine()) < 0){
				return new ArbreBRCons(this.getRacine(), this.getAg().supprimer(val), this.getAd());
			}
			else{
				return new ArbreBRCons(this.getRacine(), this.getAg(), this.getAd().supprimer(val));
			}
		}

	}
        
	public void arbreBREnTab (ArrayList t) {
		this.getAg().arbreBREnTab(t);
		t.add(this.getRacine());
		this.getAd().arbreBREnTab(t);
	}


	public ArbreBRCons(ArrayList<Integer> t, int d, int f) {
		if(d<f){
			int milieu = (f+d)/2;
			if(d==f-1){
				this.racine=t.get(milieu);
				this.Ag = new ArbreBRVide();
				this.Ad = new ArbreBRCons(t.get(milieu+1));
			}
			else {
				this.racine=t.get(milieu);
				this.Ag = new ArbreBRCons(t, d, milieu-1);
				this.Ad = new ArbreBRCons(t, milieu+1, f);
			}
		}
		else {
			this.racine = t.get(d);
			this.Ag = new ArbreBRVide();
			this.Ad = new ArbreBRVide();
		}
	}


}


