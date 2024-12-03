package liste;



public abstract class Liste  
{
	public abstract boolean estVide();
	public abstract String getPremier();
	public abstract Liste getReste();
	public abstract void afficheIt();
	public abstract boolean rechercherIt(String s);
	public abstract int size();
	public abstract String somme();
	public abstract void afficher();
	public abstract void afficherInverse();
	public abstract Liste copie();
	public abstract Liste placerFin(String val);
}

//************************************************************************************************************

  
class ListeVide extends Liste  
{
	ListeVide ()
	{
	}
	
	public boolean estVide() {return true;}
	
	public String getPremier(){ return null;}
	
	public Liste getReste(){ return null;}
        
	public void afficheIt(){}

	public boolean rechercherIt(String s){ return false;}

	public int size(){
		return 0;
	}

	public String somme(){
		return "";
	}

	public void afficher(){}
	public void afficherInverse(){}

	public Liste copie(){
		return new ListeVide();
	}

	public Liste placerFin(String val){
		return new ListeCons(val, new ListeVide());
	}

}

//************************************************************************************************************

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

	public void afficheIt(){
		Liste liste = this;
		while (!liste.estVide()){
			System.out.println(liste.getPremier() + " ");
			liste = liste.getReste();
		}
	}

	public boolean rechercherIt(String s){
		Liste liste = this;
		while (!liste.estVide()){
			if (liste.getPremier() == s){
				return true;
			}
			liste = liste.getReste();
		}return false;
	}

	public int size(){
		return 1 + this.getReste().size();
	}

	public String somme(){
		return this.getPremier() + this.getReste().somme();
	}

	public void afficher(){
		System.out.print(this.getPremier() + " ");
		this.getReste().afficher();
	}

	public void afficherInverse(){
		this.getReste().afficherInverse();
		System.out.print(this.getPremier() + " ");
	}

	public ListeCons copie(){
		return new ListeCons(this.getPremier(),this.getReste().copie());
	}

	public Liste placerFin(String val) {
		return new ListeCons(this.getPremier(), this.getReste().placerFin(val));
	}
	}