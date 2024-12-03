package liste;



public abstract class Liste  
{
	public abstract boolean estVide();
	public abstract String getPremier();
	public abstract Liste getReste();
		
	public abstract void afficher();
	
	public abstract boolean trouver( String val );
	
	public abstract int  size();
	
	public abstract String somme();
	
	public abstract Liste placerFin( String val);
	
	public abstract Liste copie();
	
	public abstract Liste concat( Liste L1 );
	
	public abstract Liste inverser();

	public abstract Liste inserer(String s , int rang );
	
	public abstract Liste intersection( Liste L );
	
	public abstract Liste union( Liste L );	

	
}

//************************************************************************************************************
// cas non construit : que fait-on si la liste est vide pour la fonction choisie ?
  
class ListeVide extends Liste  
{
	ListeVide ()
	{
	}
	
	public boolean estVide()
	{
		return true;
	}
	
	public String getPremier(){return null;}
	
	public Liste getReste(){return null;}

	
	public void afficher()
	{
		System.out.println();
	}	
	
	
	public boolean trouver( String val )
	{
		return false;
	}

	public String somme()
	{
		return "";
	}
	
	public int size()
	{
		return 0;
	}
	
	public Liste placerFin( String val)
	{
		return new ListeCons( val, new ListeVide() );
	}

	public Liste copie()
	{
		return new ListeVide();
	}

	public Liste concat( Liste L1 )
	{
		return L1.copie();
	}
	
	public Liste inverser()
	{
		return new ListeVide();
	}
	
	public Liste inserer(String s, int rang )
	{
		return new ListeCons( s, new ListeVide() );
	}
	
	public Liste intersection( Liste L )
	{
		return new ListeVide();
	}

	public Liste union( Liste L )
	{
		return L.copie();
	}
	
	
        public Liste intersection2( Liste L ){return new ListeVide();}



}


//**********************************************************************************************************
// cas construit : inclus comme ingredients   
//	1) appel recursif    
// 2) le traitement du premier element 
// 3) constructeur de listes si on retourne une liste

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
		
	
	public void afficher()
	{
			System.out.print( this.getPremier()+" " );
			this.getReste().afficher();
	}
	
	public boolean trouver( String val )
	{
		if (val.equals( this.getPremier() ) )
					return true;
		else
			return this.getReste().trouver(val);	
	}
	
	public int size()
	{
		return 1+ getReste().size();
	}
	
	public String somme()
	{
		return this.getPremier() + this.getReste().somme();
	}

		
	public Liste placerFin( String val)
	{
		return new ListeCons( this.getPremier(), this.getReste().placerFin( val ) );	
	}
	
	public Liste copie()
	{
		return new ListeCons(  getPremier() ,  getReste().copie()  );
	}

	public Liste concat( Liste L1 )  // on consomme la liste this pas L1
	{
		return new ListeCons( getPremier(), getReste().concat( L1) );
	}

	
	public Liste inverser()
	{
		return getReste().inverser().placerFin( getPremier() ); 
	}

	public Liste inserer(String s, int rang )
	{
		if (rang ==1)
			return new ListeCons( s, getReste().copie()  );
		else
			return new ListeCons( getPremier(), getReste().inserer( s, rang-1 ) );
	}

	public Liste intersection( Liste L )
	{
		if ( L.trouver(getPremier() ) )
			return new ListeCons( getPremier(), getReste().intersection( L ) );
		else
			return getReste().intersection( L );
	}

	public Liste union( Liste L )
	{
		if ( L.trouver(getPremier() ) )
			return getReste().union( L);
		else
			return new ListeCons( getPremier() , getReste().union( L ) );
	}
      

}