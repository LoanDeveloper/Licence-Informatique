package liste;

public class TestListe
{
	public static void main( String [] args)
	{
	
		Liste L = new ListeCons("D", new ListeCons("B", new ListeCons("A", new ListeVide())));
		L.afficher();
		
		if (L.trouver("C")) 
                    System.out.println("trouvé");
		else  
                    System.out.println("pas trouvé");
		
		Liste L3= L.placerFin( "C" );
		L3.afficher();
		System.out.println( L3.size() );
					
		L3=L3.inverser();
		L3.afficher();
		
                L3 = L3.inserer("intru", 3 );
		L3.afficher();
			
		Liste LL = new ListeCons("Z", new ListeCons("B", new ListeCons("A", new ListeVide())));
		LL.afficher();	
		
		Liste L4= LL.intersection(L);
		L4.afficher();
		
		Liste L5= LL.union(L);
		L5.afficher();
		
						
	}
	
	
}