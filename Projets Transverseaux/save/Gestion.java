/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moneymoney;
import java.lang.Math;
/**
 *
 * @author mazin
 */
public class Gestion {

    //fonction qui transfère de l'argent d'un compte à un autre
    public String crediter(Compte crediteur,Compte debiteur,String somme){
        if(!(Double.parseDouble(debiteur.getMontant())<Double.parseDouble(somme))){//s'il y a assez sur le compte debiteur
            debiteur.setMontant(Math.round((Double.parseDouble(debiteur.getMontant())+Double.parseDouble(somme))*100.0)/100.0+"");
            crediteur.setMontant(Math.round((Double.parseDouble(crediteur.getMontant())-Double.parseDouble(somme))*100.0)/100.0+"");
            return "Virement effectué" ;
        }else{
            return "Fonds insuffisants" ;
        }
    }   
}
