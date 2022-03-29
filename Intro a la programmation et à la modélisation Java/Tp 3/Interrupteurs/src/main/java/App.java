import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Panneau p = new Panneau();
        /**System.out.println(p.toString());
        
        p.interrupteur2();
        System.out.println(p.toString());
        
        System.out.println(p.allumes());
        
        p.reset();
        System.out.println(p.toString());**/
        
        
        while (p.allumes() == false){
            System.out.println("Etat du panneau : " + p.toString());
            
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Interrupteur à actionner :");
            int d = sc.nextInt();
            
            switch (d){
                case 1: p.interrupteur1();
                break;
                case 2: p.interrupteur2();
                break;
                case 3: p.interrupteur3();
                break;
                case 4: p.interrupteur4();
                break;
                case 5: p.interrupteur5();
                break;         
            }
        }System.out.println("Gagné !");
    }
}
