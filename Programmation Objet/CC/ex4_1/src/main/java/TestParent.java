public class TestParent {
    public static void main(String[] args) {
        Repertoire racine = new Repertoire("racine");
        Repertoire rep1 = new Repertoire("rep1");
        Repertoire rep3 = new Repertoire("rep3");
        rep1.ajouteElt(rep3);
        racine.ajouteElt(rep1);
        Fichier f1 = new Fichier("f1", 100);
        racine.ajouteElt(f1);
        /*
                 racine
               /        \
             rep1       f1
              |
             rep3
         */

        // test des liens de parent'e
        if (racine.donneParent() != null)
            throw new Error("Probleme avec TestParent : le repertoire racine n'a pas de parent");
        if (rep3.donneParent() != rep1 || rep1.donneParent() != racine)
            throw new Error("Probleme avec TestParent : mauvaise gestion du lien parent pour rep3 ou rep1");
        if (f1.donneParent() != racine)
            throw new Error("Probleme avec TestParent : mauvaise gestion du lien parent pour f1");

        // test de la methode equals devant prendre en compte la parente
        Fichier f2 = new Fichier("f1", 100);
        if (f1.equals(f2)) {
            throw new Error("Probleme avec TestParent : f1 et f2 n'ont pas le meme parent et ne sont pas egaux");
        }

        // test de la gestion du parent lors d'une suppression
        racine.supprimeElt(f1);
        if (f1.donneParent() == racine)
            throw new Error("Probleme avec TestParent : mauvaise gestion du lien parent lors d'une suppression");

        System.out.println("TestParent OK...");
    }
}
