/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licence.annee1.denree;

/**
 * Classe d'utilisation de Denrée.
 *
 * @author jviaud
 */
public class AppDenree {
    public static void main(String[] args) {
        Denree c = new Denree();
        c.setNom("Concombre");
        c.setPrixHT(8.0);
        c.setPrixTTC(15.0);
        System.out.println(c.toString());
    }
}
