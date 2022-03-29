import java.util.Scanner;

public class AppJeu {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int x = (int)(Math.random()*100);
        int y = 101;
        
        while (x != y){
            System.out.println("Saisissez un entier entre 0 et 100:");
            y = s.nextInt();
            if (x<y){
                System.out.println("Plus petit !");
            }else if (x>y){
                System.out.println("Plus grand !");
            }
        }System.out.println("Gagné !");
    }
    
}
