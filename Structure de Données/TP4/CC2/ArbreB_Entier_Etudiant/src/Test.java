
import java.util.ArrayList;


public class Test {
    public static void main( String [] arg){        
  
        Arbre arb = new ArbreCons(1, new ArbreVide(), new ArbreVide());
        Arbre arb2 = new ArbreCons(4, new ArbreCons(3, new ArbreVide(), new ArbreVide()) , new ArbreCons(5, new ArbreVide(), new ArbreVide()));

        System.out.println(arb.max());
    }
}
