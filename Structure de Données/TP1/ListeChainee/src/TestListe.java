public class TestListe
{
	public static void main( String [] args)
	{

		ListeCons L1 = new ListeCons( "A", new ListeCons( "B", new ListeCons( "C", new ListeCons( "D", new ListeVide() ) )));
		ListeCons L2 = new ListeCons( "E", new ListeCons( "F", new ListeVide()));
		ListeCons L3 = new ListeCons( "A", new ListeCons( "F", new ListeCons( "E", new ListeCons( "D", new ListeVide() ) )));
		//System.out.println(L1.trouver("A"));
		//L1.concat(L2).afficher();
		//L1.inverser().afficher();
		//L1.inserer("E",1).afficher();
		//System.out.println(L1.inclus(L3));

		//L1.union(L3).afficher();
		//*************************** td / tp 2 ***********************************
		ListeCons L4 = new ListeCons( "12", new ListeCons( "8", new ListeCons( "3", new ListeCons( "9", new ListeVide() ) )));
		L4.inferieurs(3).afficher();

	}
	
	
}