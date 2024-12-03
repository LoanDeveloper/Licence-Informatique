package liste;

public abstract class Liste  
{
	public abstract boolean estVide();
	public abstract int getPremier();
	public abstract Liste getReste();
	
        public abstract int  size();
   		
	public abstract void afficher();       
	public abstract Liste majore(int a, int b);
        public abstract int max();

}

//************************************************************************************************************

  
class ListeVide extends Liste  
{
	ListeVide ()
	{
	}
	
	public boolean estVide()
	{
		return true;
	}
	
	public int getPremier(){return -1;}   //ERREUR il faudrait declencher une exception normalement
	
	public Liste getReste(){return null;}  // ERREUR
        
              
        public int size()
	{
		return 0;
	}

		
	public void afficher()
	{
	     System.out.println();
	}
        public Liste majore(int a, int b){return new ListeVide();}
        
        public int max(){return 0;}

}

//************************************************************************************************************

class ListeCons extends Liste
{
	private int valeur;
	private Liste suiv;

	ListeCons(int val, Liste L)
	{
		this.valeur = val; this.suiv = L;
	}
	
	public boolean estVide()
	{
		return false;
	}

	public int getPremier() { return this.valeur; }
	
	public Liste getReste() { return this.suiv; }
	
        
        public int size()
	{
		return 1+ getReste().size();
	}
  
 
	public void afficher()
	{                        
			System.out.print( this.getPremier()+" " ); 
                        this.getReste().afficher();			
	}
	
        public Liste majore(int a, int b){
            if (this.getPremier() >= a && this.getPremier() <= b){
                return new ListeCons(this.getPremier(), this.getReste().majore(a,b));
            }else{
                return this.getReste().majore(a, b);
            }
        }
           
        public int max(){
            int vmax = 0;
            if (this.getPremier() > this.getReste().getPremier() && this.getPremier() > vmax){
                if (this.getReste() == new ListeVide()){
                   vmax = this.getPremier();
                   return vmax;
                }
                vmax = this.getPremier();
                return this.getReste().max();
            }
            return this.getReste().max();
        }
        
        /*
        Liste l;
            if (this.getPremier() > this.getReste().getPremier()){
                l = new ListeCons(this.getPremier(), new ListeCons(this.getReste().max(), new ListeVide()));
                if (this.getReste() == new ListeVide()){
                    return this.getPremier();
                }
                return this.getPremier();
            }else{
                return this.getReste().max();
            }
        
        
        */

}