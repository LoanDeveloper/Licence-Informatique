public class AppTest {

    public static void main(String[] args) {
        Utilisateur u1 = new Utilisateur("Loan");
        Utilisateur u2 = new Utilisateur("Timothé");
        
        Compte c = new Compte(1234,200.0, u1);
        Compte e = new Compte(1235,1500.0,u1);
        GuichetAutomatique g = new GuichetAutomatique();
        
        u1.setCompteCourantPrincipal(c);
        u2.setCompteCourantSecondaire(c);
        u1.setCompteEpargnePrincipal(e);
       
        System.out.println(g.reserve);
        System.out.println(u1.toString());
        g.retrait(c,u1,10.0);
        System.out.println(u1.toString());
        System.out.println(g.reserve);
    }
    
}