
package tp5;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author P. Rodriguez
 */
public class TraitementCommande {

    private ArrayList<LigneDeCommande> lesLignesCommande;
	private DecimalFormat df;
    
    public TraitementCommande() {
       try{ 
        this.lesLignesCommande = lectureFichier("lignesDeCommande.txt") ;
		df = new DecimalFormat("##.00€");
       } catch(IOException e){ 
           System.out.println("ERREUR CHARGEMENT"); 
       }
    }

	
	public ArrayList<LigneDeCommande> lectureFichier(String nomFichier) throws IOException
	{
		ArrayList<LigneDeCommande> resultat ;
		resultat = new ArrayList() ;
		
		FileReader fr = new FileReader(nomFichier) ;
		
		LigneDeCommande li = new LigneDeCommande() ;
		while(li.lireDansFichier(fr))
		{
				resultat.add(li) ;
				li = new LigneDeCommande() ;	
		}
		return resultat ;
	}

	public void afficher(){
		for (LigneDeCommande l : lesLignesCommande){
			System.out.println(l.toString());
		}
	}

	public Double prixTotal(){
		Double total = 0.0;
		for (LigneDeCommande l : lesLignesCommande) {
			total += l.getPrix();
		}
		return total;
	}

	public Double prixTotalDeLaCommande(Integer n){
		Double total = 0.0;
		for (LigneDeCommande l : lesLignesCommande){
			if (l.getNumCommande() == n){
				total += l.getPrix();
			}
		}
		//(Math.round(total*100.0)/100.0);
		//Double total2 = Double.parseDouble(df.format(total))
		return total;
	}

	public int nombreArticle(Integer n){
		int cpt = 0;
		for (LigneDeCommande l : lesLignesCommande){
			if (l.getNumCommande() == n){
				cpt += l.getQuantite();
			}
		}
		return cpt;
	}
	public void afficherLaCommande(Integer n) {
		for (LigneDeCommande l : lesLignesCommande) {
			if (l.getNumCommande() == n) {
				System.out.println(l);
			}
		}
	}

	public ArrayList<LigneDeCommande> ligneDeLaCommande(Integer n){
		ArrayList<LigneDeCommande> array = new ArrayList<LigneDeCommande>();
		lesLignesCommande.forEach(elem -> {
			if (elem.getNumCommande() == n){
				array.add(elem);
			}
		});
		return array;
	}

	public ArrayList<LigneDeCommande> lignesSansLaCommande(Integer n){
		ArrayList<LigneDeCommande> array = new ArrayList<LigneDeCommande>();
		lesLignesCommande.forEach(elem -> {
			if (elem.getNumCommande() != n){
				array.add(elem);
			}
		});
		return array;
	}

	public ArrayList<Integer> listeNumerosCommande(){
		ArrayList<Integer> array = new ArrayList<Integer>();
		lesLignesCommande.forEach(elem -> {
			if (array.contains(elem.getNumCommande()) == false){
				array.add(elem.getNumCommande());
			}
		});
		return array;
	}

	public void afficherCommandes(){
		this.listeNumerosCommande().forEach(num -> {
			System.out.println("Commande n°" + num + " : " + nombreArticle(num) + " Articles pour un montant de " + df.format(prixTotalDeLaCommande(num)));
			this.ligneDeLaCommande(num).forEach(commande -> {
				System.out.println("\t"+commande.toString());
			});
		});
	}
}
