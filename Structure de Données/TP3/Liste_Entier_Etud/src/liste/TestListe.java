package liste;

public class TestListe
{
	public static void main( String [] args)
	{	
	
            Liste l = new ListeCons(10,new ListeCons(9,new ListeCons(14,new ListeVide())));
            //l.majore(4,14).afficher();
            l.afficher();
            System.out.println(l.max());
                
             				
	}
	
	
}