/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moneymoney;

/**
 *
 * @author mazin
 */
public class test {
    public static void main(String[] args) {
        Compte louis = new Compte("92756738491","FR9375287910572847389201567","Compte Louis 1","Livret A","300.92","Louis MAZIN");
        Compte josh = new Compte("74562946791","FR9375287910593027389201567","Compte Josh 1","Livret A","31.63","Joshua PUGH");
        Gestion g = new Gestion();
        System.out.println(louis.getMontant());
        System.out.println(josh.getMontant());
        g.crediter(louis, josh,"30");
        System.out.println("");
        System.out.println(louis.getMontant());
        System.out.println(josh.getMontant());
        BDD b =new BDD("postgres", "motdepasse","5432","moneybdd"); //mot de passe et nom different pour vous maybe
        //b.getRequest("SELECT * FROM personnes") finir display in BDD pour faire fonctionner
        //louis.addType(b,"Livret B"); a coder
//        b.insertPersonne("002", "pugh", "joshua");
    }
}
