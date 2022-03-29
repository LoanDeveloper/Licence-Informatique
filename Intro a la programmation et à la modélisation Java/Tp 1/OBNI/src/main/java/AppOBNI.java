/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author loant
 */
public class AppOBNI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjetBougeant o1 = new ObjetBougeant();
        ObjetBougeant o2 = new ObjetBougeant();
        
        o1.setNom("Objet1");
        o1.setX(0);
        o1.setY(0);
        o1.setR(2.5);
        
        o2.setNom("Objet 2");
        o2.setX(1);
        o2.setY(1);
        o2.setR(5.0);
        
        o1.deplace(3,4);
        System.out.println(o1);
        
    }
    
}
