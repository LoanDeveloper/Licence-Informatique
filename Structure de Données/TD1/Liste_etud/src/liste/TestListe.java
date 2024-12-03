package liste;

public class TestListe
{
	public static void main( String [] args)
	{

		ListeCons L = new ListeCons( "Un", new ListeCons( "Deux", new ListeCons( "Trois", new ListeCons( "Quatre", new ListeVide() ) )));
		//L.afficheIt();
		//System.out.println(L.rechercherIt("Quatres"));
		ListeCons L2 = L.copie();
		L2.placerFin("Cinq");
		L2.afficher();
	}
	
	
}