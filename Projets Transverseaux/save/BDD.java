/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.moneymoney;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author josh
 */
public class BDD {
    Connection conn; // l'accès à la base de données
    String nomDB;
    String path;
    public BDD(String user,String password,String port,String nomDB) {
        this.nomDB=nomDB;
        this.path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\mycompany\\moneymoney\\"; 
        try{
            this.conn = connect(user,password,port,nomDB);
            
        }catch(Exception e){
            this.conn = connect(user,password,port,"postgres");
            this.createDb(nomDB);
            this.conn = connect(user,password,port,nomDB);
        }
        this.initSQL();
        this.insertSQL();
        
    }
    
    /*
    * Connecte java à la database locale -> jdbc:postgresql://localhost:5432/money
    * Retourne l'accès à la base de données
    */
    private Connection connect(String user,String password,String port,String nomDB) {
        Connection conn = null;
        try {
           Class.forName("org.postgresql.Driver");
           conn = DriverManager.getConnection("jdbc:postgresql://localhost:"+port+"/"+nomDB,user,password);
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }
        return conn;
      }
    
    
    /*
    * Permet d'envoyer une requête quelquonque autre que SELECT à la BDD
    * -> pour SELECT -> getRequest
    */
    public void insertRequest(String request){
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(request);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /*
    * Permet d'insérer une personne dans la BDD
    * -> appelle la fonctions insertRequest
    */
    public void insertPersonne(String idpers,String nom,String prenom){
        insertRequest("INSERT INTO Personne (idpers, nom, prenom) VALUES ('"+idpers+"','"+nom+"','"+prenom+"');");
    }
    /*
    * Permet d'insérer un compte dans la BDD
    * -> appelle la fonctions insertRequest
    */
    public void insertCompte(String proprietaire,String numero,String iban,String typeCompte,String montant){
        insertRequest("INSERT INTO Compte (proprietaire, numero, iban, typeCompte, montant) VALUES ('"+proprietaire+"','"+numero+"','"+iban+"','"+typeCompte+"','"+montant+"');");
    }
    /*
    * Permet d'insérer une transaction dans la BDD
    * -> appelle la fonctions insertRequest
    */
    public void insertTransaction(String id_transaction,String IbanCredite,String IbanDebite,String montant){
        insertRequest("INSERT INTO Transaction (id_transaction, IbanCredite, IbanDebite, montant) VALUES ('"+id_transaction+"','"+IbanCredite+"','"+IbanDebite+"','"+montant+"');");
    }
    /*
    * Permet d'insérer un bénéficiaire dans la BDD
    * -> appelle la fonctions insertRequest
    */
    public void insertBeneficiaire(String idbenef,String nom,String prenom){
        insertRequest("INSERT INTO Beneficiaire (idbenef, nom, prenom) VALUES ('"+idbenef+"','"+nom+"','"+prenom+"');");
    }
    /*
    * Permet d'insérer un DroitDeGestion dans la BDD
    * -> appelle la fonctions insertRequest
    */
    public void insertDroitDeGestion(String personne, String compte){
        insertRequest("INSERT INTO DroitDeGestion (personne, compte) VALUES ('"+personne+"','"+compte+"');");
    }
    /*
    * Permet d'nevoyer une requête SELECT à la BDD
    * -> que SELECT car affichage prévu
    */
    public ArrayList<String> getRequest(String request){
        ArrayList array = new ArrayList<String>();
        try (
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(request)
            )
                {
                    array=display(rs);
                } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return array;
    }
    
    private ArrayList display(ResultSet rs) throws SQLException {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> column = new ArrayList<String>();
        boolean var = true;
        while (rs.next()) {
            //write foreach in rs -> column.add(rs.getString(1));
        }
        return res;
    }
    /*
     * Creer la BDD
     */
    private void createDb(String nomDB){
        try{
           Statement stmt = conn.createStatement();
           stmt.executeUpdate("DROP DATABASE IF EXISTS "+nomDB+";");
           stmt.executeUpdate("CREATE DATABASE " + nomDB + ";");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    /*
    * Permet d'importer la BDD à chaque ouverture de l'app
    * -> après avoir saisit user,password,port,nomDB
    */
    public void initSQL(){
        try{
            FileReader fr= new FileReader(path + "BDD.sql"); 
            int r=0;  
            String str = "";
            while((r=fr.read())!=-1){  
                str += (char)r;
                //System.out.print((char)r);  //prints the content of the file   
            }
            insertRequest(str);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }  
    /*
    * Permet d'importer les données de la BDD à chaque ouverture de l'app
    * -> après avoir initSQL
    */
    public void insertSQL(){
        try{
            FileReader fr= new FileReader(path + "insert.sql"); 
            int r=0;  
            String str = "";
            while((r=fr.read())!=-1){  
                str += (char)r;
                //System.out.print((char)r);  //prints the content of the file   
            }
            insertRequest(str);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    } 
    /*
    * Permet de sauvegarder la BDD à chaque fermeture de l'app
    */
    public void save(String path){
        //save database to .sql file
    } 
}
