/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moneymoney;
import java.lang.Math;
import java.util.List;
import java.util.Arrays;
/**
 *
 * @author mazin
 */
public class Compte {
    private static List<String> types = Arrays.asList(
        new String[]{"Livret A", "Compte de Dépôt",
        "Livret de développement durable et solidaire",
        "Livret épargne populaire","Livret jeune",
        "Compte épargne logement","Plan épargne logement",
        "Plan épargne retraite populaire",
        "Compte épargne ou livret épargne bancaire",
        "Compte à terme"});
    
    private String numero; //_NUMEROCOMPTE_
    private String iban; //IBAN
    private String intitule; //intitulé
    private String type; //type
    private String montant; //montant
    private String proprietaire; //propriétaire

    public Compte(String numero, String iban, String intitule, String type, String montant, String proprietaire) {
        if(numero.length()<12){
            if(numero.matches("[0-9]{11}")){
                this.numero=numero;
            }
        }
        if(iban.matches("[A-Z]{2}[0-9]{25}")){
            this.iban=iban;
        }
        this.intitule = intitule;
        if(types.contains(type)){
            this.type = type;
        }
        if(montant.matches("[0-9]*[.,][0-9]{2}")){
            this.montant = montant;
        }
        this.proprietaire = proprietaire;
    }

    @Override
    public String toString() {
        return "Compte{" + "numero=" + numero + ", iban=" + iban + 
        ", intitule=" + intitule + ", type=" + type + ", montant=" + 
        montant + ", proprietaire=" + proprietaire + '}';
    }

    public static List<String> getTypes() {
        return types;
    }
    
    //fonctionne mal
    public static void addType(BDD bdd,String type) {
        types.add(type);
        System.out.println(types);
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
        //modifier sur la BDD
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
        //modifier sur la BDD
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
        //modifier sur la BDD
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        //modifier sur la BDD
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
        //modifier sur la BDD
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
        //modifier sur la BDD
    }
}
