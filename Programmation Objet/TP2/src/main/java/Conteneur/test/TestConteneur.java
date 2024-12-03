package Conteneur.test;
import Conteneur.*;
/**
 *
 * @author loant
 */
public class TestConteneur {
        
    public static void testConteneurVolume(){
        //Distance, VolumeMax
        Conteneur cont1 = new Conteneur(300,300);

        //Poids, Volume, Distance
        Colis c1 = new Colis(200,200,300);
        Colis c2 = new Colis(200,200,300);
        cont1.ajout(c1);
        if(cont1.ajout(c2)){
            throw new Error("Erreur sur le volume Max de cont1");
        }
    }
        
    public static void testConteneurPerfect(){
        Conteneur cont2 = new Conteneur(300,300);
        Colis c1 = new Colis(200,200,300);
        Colis c3 = new Colis(100,100,300);
        if(cont2.ajout(c3)){
            
        }else{
            throw new Error("Erreur sur l'ajout de c3 dans cont2");
        }
    }
     
    public static void testConteneurDistance(){
        Conteneur cont3 = new Conteneur(300,300);
        Colis c4 = new Colis(100,100,250);
        if(cont3.ajout(c4)){
            throw new Error("Erreur sur la règlementation de la distance de cont3");
        }
    }

    public static void testConteneurCout(){
        Conteneur cont4 = new Conteneur(300,500);
        Colis c1 = new Colis(100,100,300);
        Colis c2 = new Colis(100,200,300);
        Colis c3 = new Colis(100,200,300);
        cont4.ajout(c1);
        cont4.ajout(c2);
        cont4.ajout(c3);
        if(cont4.cout() != (300*300)){
            throw new Error("Erreur sur le cout du conteneur cont4");
        }
    }
        
    public static void main(String[] args) {
        testConteneurVolume();
        testConteneurPerfect();
        testConteneurDistance();
        testConteneurCout();
        System.out.println("Classe Conteneur OK...");
    }    
     
}
