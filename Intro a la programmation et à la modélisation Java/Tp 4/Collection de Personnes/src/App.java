import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        Personne m = new Personne(5,"Dupond","Marc",'h',1978,"Surfeur",3);
        Personne m2 = new Personne(5,"Dupond","Marc",'h',1978,"Surfeur",3);
        Personne m3 = m;
        Personne p = new Personne(6,"Durant","Paul",'h',1980,"Skateur",3);
        
        System.out.println(m.getNom());
        System.out.println(m.getAnneeNaiss());
        System.out.println(m.getGroupe());
        
        System.out.println(p.getNom());
        System.out.println(p.getAnneeNaiss());
        System.out.println(p.getGroupe());
        
        p.afficher();
        System.out.println(m);
        System.out.println(m2);
        System.out.println(m.equals(m2));
        
        CollectionPersonnes c = new CollectionPersonnes();
        System.out.println(c.effectifDeLAnnee(1990));
        System.out.println(m.matchScore(p));
        
        System.out.println(c.laPlusProche(m));
        System.out.println(c.lesPlusProches(m));
        System.out.println(c.personnesGroupe("Bosseur"));
    }
}
