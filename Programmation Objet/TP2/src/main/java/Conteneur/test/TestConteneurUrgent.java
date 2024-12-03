package Conteneur.test;
import Conteneur.*;
/**
 *
 * @author loant
 */
public class TestConteneurUrgent {

    public static void testConteneurUrgentAjout(){
        // Poids, volume, distance
        Colis c1 = new Colis(100,100,300);
        Colis c2 = new Colis(100,200,300);
        Colis c3 = new Colis(300,100,300);
        Colis c4 = new Colis(100,100,400);
        
        //Poids, distance,Volume
        ConteneurUrgent contU1 = new ConteneurUrgent(300,300,300);
        ConteneurUrgent contU2 = new ConteneurUrgent(300,300,300);
        if(!contU1.ajout(c1)){
            throw new Error("Erreur sur l'ajout du colis c1 dans contU1");
        }
        if(!contU1.ajout(c2)){
            throw new Error("Erreur sur l'ajout du colis c2 dans contU1");
        }
        if(!contU2.ajout(c1)){
            throw new Error("Erreur sur l'ajout du colis c1 dans contU2");
        }
        if(contU2.ajout(c3)){
            throw new Error("Erreur le colis c3 à été ajouté au conteneur urgent contU2 sans que le poids suffisant ne sois disponible");
        }
        if(contU2.ajout(c4)){
            throw new Error("Erreur, le colis c4 à été ajouté au conteneur urgent contU2 sans que la distance soit la même");
        }
        
    }
    public static void testConteneurUrgentCout(){
        //Poids,distance,volume
        ConteneurUrgent contU1 = new ConteneurUrgent(400,300,400);

        //Poids,volume,distance
        Colis c1 = new Colis(100,200,300);
        Colis c2 = new Colis(100,100,300);
        Colis c3 = new Colis(100,100,300);
        Colis c4 = new Colis(100,100,300);
        contU1.ajout(c1);
        contU1.ajout(c2);
        contU1.ajout(c3);
        contU1.ajout(c4);
        
        
        if(contU1.cout() != ((300*300)*2)){
            System.out.println(contU1.donnePoids());
            System.out.println(contU1.cout());
            throw new Error("Erreur sur le cout du conteneur urgent contU1");
        }        
    }
    public static void main(String[] args){
        testConteneurUrgentAjout();
        testConteneurUrgentCout();
        System.out.println("Classe ConteneurUrgent OK...");
    }
}
