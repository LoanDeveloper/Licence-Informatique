import java.util.HashMap;
import java.io.*;
import java.awt.Color;

public class LSystem
{

   private String axiome;
   private HashMap <Character, String> regles;
   private String expCourante;
   
   public LSystem()
   {
      /* definition regle derivation */
      this.regles = new HashMap <Character, String> ();

      this.regles.put('X',"X+Y++Y-X - -XX-Y+");
      this.regles.put('Y',"-X+YY++Y+X--X-Y");
      this.regles.put('+',"+");
      this.regles.put('-',"-");

      this.expCourante = this.axiome; 
   }

   public void derivation(String nouvelleExp, int nbDeriv)
   {
      this.expCourante = nouvelleExp;

      for (int i = 0; i < this.expCourante.length(); i++){
         nouvelleExp += this.regles.get(expCourante.charAt(i));
      }

      this.expCourante = nouvelleExp;
      System.out.println( this.expCourante );

      if (nbDeriv > 1){
         derivation(nouvelleExp,nbDeriv-1);
      }
   }

   public void resetExp()
   {
      this.expCourante = this.axiome;
   }
   
     
   public void interpretation()
   {
      Logo l = new Logo( 400, 300, 90, Color.black, Logo.PEN_DOWN, 50 );
      // lire l'expression et interpreter les symboles...


      for (int i = 0; i < this.expCourante.length(); i++){
         switch (this.expCourante.charAt(i)){
            case 'X':
               l.av();
               break;
            case 'Y':
               l.av();
               break;
            case '+':
               l.rotG(60);
               break;
            case '-':
               l.rotD(60);
               break;
         }
      }
   }
   
   public int alea(int a, int b )
   {
      return (int) (Math.random()*(b-a+1)+a);   
   }

}
// Fractal
// axiome :"X"
// 'X'->"X+Y++Y-X--XX-Y+"
// 'Y'->"-X+YY++Y+X--X-Y"

// Plante
//  axiome ="X"
//  'X'->"F-[[X]+X]+F[+FX]-X"
//  'F'->"FF"

// Arbre
// axiome ="0"
// '0'->"1[-0]+0"
// '1'->,"11"