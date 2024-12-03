import java.sql.SQLOutput;
import java.util.ArrayList;

public class QStore
{
public static final int N=2100;   // Nombre d'elements dans la liste au depart
//---------------------------------------------------------------------------
private ArrayList <Integer> T ;
//---------------------------------------------------------------------------
public int compteurDicho; // voir la dichotomie O(lg N )
//---------------------------------------------------------------------------

QStore( )
{
	this.compteurDicho=0; 
	this.T = new ArrayList();  	
}
//---------------------------------------------------------------------------

public void exec()
{
	Liste l = new ListeCons(1, new ListeCons(2, new ListeCons(3)));
	Liste l2 = new ListeCons(N);
	l2.listeEnTab(T);

	System.out.println(dicho(45,0,T.size()));
	System.out.println(compteurDicho);
}


// recherche Dichotomique dans le tableau -----------

public boolean dicho( int n , int iDebut, int iFin ) {
	if (iDebut == iFin){
		if (this.T.get(iDebut) == n){
			return true;
		}else{
			return false;
		}
	}else{
		int iM = (iDebut + iFin)/2;
		if (this.T.get(iM) < n){
			compteurDicho++;
			return dicho(n,iM+1,iFin);
		}else{
			compteurDicho++;
			return dicho(n,iDebut,iM);
		}
	}
}

// methode EstTrie ----------------------------------
public boolean estTrie()
{
return false;
}




}