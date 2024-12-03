

class TestAppliScrabble
{
	
 
   public static void main(String args[])
   {
      Fenetre maFenetre = new Fenetre("Jeu Scrabble", 1200, 800); 
   
      Mot unMot = new Mot("AMENEE");
      boolean reponse = unMot.motOK("EANMEZZZ"); // il manque un e
      boolean reponse2 = unMot.motOK("EANMEEZZ"); // mot ok !
      
      System.out.println(reponse);
      System.out.println(reponse2);
   }
 
}